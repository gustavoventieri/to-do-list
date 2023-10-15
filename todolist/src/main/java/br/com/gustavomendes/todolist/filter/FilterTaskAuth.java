package br.com.gustavomendes.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.gustavomendes.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//colocar quando quiser que o spring controle a classe
@Component
public class FilterTaskAuth extends OncePerRequestFilter {
    @Autowired
    private IUserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
                //verificar se está passando pela a rota desejada
                var ServeletPath = request.getServletPath();

                if(ServeletPath.startsWith("/tasks/")) {
                    var authorization = request.getHeader("Authorization");
                    var authEndoc = authorization.substring("Basic".length()).trim();
                    byte[] authDecode = Base64.getDecoder().decode(authEndoc);
                    var authString = new String(authDecode);
                    String[] credentials = authString.split(":");

                    String username = credentials[0];
                    String password = credentials[1];



                    var user = this.userRepository.findByUsername(username);

                        if(user == null) {

                            response.sendError(401);

                        } else {
                        var result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

                        if(result.verified) {
                            request.setAttribute("idUser", user.getId());
                            filterChain.doFilter(request, response);
                        } else {
                        response.sendError(401);

                        }

                    
                } 
        } else {
            filterChain.doFilter(request, response);
            }
              
    }
}
