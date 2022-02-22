package com.page.vkr.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="education")
@Data //auto generat getters and setters
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Education(){
    }

    public Education(String name){
        this.name = name;
    }

}