package com.page.vkr.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="faculties")
@Data //auto generat getters and setters
public class Faculties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer id_institute;

    public Faculties(){
    }

    public Faculties(String name, Integer id_institute){
        this.name = name;
        this.id_institute = id_institute;
    }

}
