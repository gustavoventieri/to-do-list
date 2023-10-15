package br.com.gustavomendes.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
public class MinhaPrimeiraController {
    /*
     *  GET - Buscar uma informação/dado 
     *  POST - Adicionar uma informação/dado
     *  PUT - Alterar uma informação/dado
     *  DELETE - Excluir uma informação/dado
     *  PATCH - Alterar somente uma parte da informação/dado
     */
    @GetMapping("/")
    public String primeiraMensagem(){
        return "Funcionou";
    }
}
