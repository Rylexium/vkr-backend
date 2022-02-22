package com.page.vkr.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="employees")
@Data //auto generat getters and setters
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String family;
    private String name;
    private String patronymic;

    public Employees(){}

    public Employees(String family, String name, String patronymic){
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
    }
}
