package com.page.vkr.models.speciality;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="speciality")
@Data //auto generat getters and setters
@IdClass(SpecialityId.class)
public class Speciality {
    @Id
    private String id;
    @Id
    private Integer type_of_study;

    private String name;
    private Integer budget;
    private Integer pay;
    private Integer id_institut;
    private String description;
    private String competencies;
    private String professions;
    private String partners;
    private String direction;
    private Integer studying_time;
    private Integer curator;
    private Integer pay_per_year;
    private String contact_number;
    private Integer id_facult;
    private Integer passing_score;

    public Speciality(){}
}
