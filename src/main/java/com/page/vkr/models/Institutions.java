package com.page.vkr.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="institutions")
@Data //auto generat getters and setters
public class Institutions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Integer id_director;
    private String contact_phone;

    public Institutions(){
    }

    public Institutions(String name, String description, Integer id_director, String contact_phone){
        this.name = name;
        this.description = description;
        this.id_director = id_director;
        this.contact_phone = contact_phone;
    }
}
