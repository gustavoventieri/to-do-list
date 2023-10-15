package br.com.gustavomendes.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity(name = "TB_TASKS")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    //definindo o limite de carac
    @Column(length = 50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    @CreationTimestamp
    private LocalDateTime createAt;

    private UUID idUser;


    public void setTittle(String title) throws Exception{
        

        if (title.length() > 50) {
         throw new Exception("O titulo execede a quantidade de caracteres permitidas");
        }
        this.title =  title;
    }
    
}
