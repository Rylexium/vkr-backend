package com.page.vkr.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="privileges")
@Data //auto generat getters and setters
public class Privileges {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    public Privileges(){}

    public Privileges(String name){
        this.name = name;
    }
}
