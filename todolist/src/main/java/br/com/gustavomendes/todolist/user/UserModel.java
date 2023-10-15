package br.com.gustavomendes.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//fazendo get e set
@Data

//nome da tabela
@Entity(name = "tb_users")
public class UserModel {

    //fazendo chave id
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;


    //defini um valor unico, so um registro
    @Column(unique = true)
    private String username;
    private String name;

    //@Column(unique = true)
    private String password;

    @CreationTimestamp
    private LocalDateTime createAt;

    
}
