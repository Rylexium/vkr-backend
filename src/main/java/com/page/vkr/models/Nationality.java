package com.page.vkr.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="nationality")
@Data //auto generat getters and setters
public class Nationality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Nationality(){}

    public Nationality(String name){
        this.name = name;
    }
}
