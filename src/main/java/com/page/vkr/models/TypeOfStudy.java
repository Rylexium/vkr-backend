package com.page.vkr.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type_of_study")
@Data //auto generat getters and setters
public class TypeOfStudy {
    @Id
    private Long id;
    private String name;

    public TypeOfStudy(){
    }

}
