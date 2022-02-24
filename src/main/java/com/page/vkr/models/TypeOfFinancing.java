package com.page.vkr.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="type_of_financing")
@Data //auto generat getters and setters
public class TypeOfFinancing {
    @Id
    private Integer id;
    private String name;

    public TypeOfFinancing(){}
}
