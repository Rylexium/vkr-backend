package com.page.vkr.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="exams")
@Data //auto generat getters and setters
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Exams(){
    }

    public Exams(String name){
        this.name = name;
    }
}
