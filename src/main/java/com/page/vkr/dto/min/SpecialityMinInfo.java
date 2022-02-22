package com.page.vkr.dto.min;

import lombok.Data;

@Data //auto generat getters and setters
public class SpecialityMinInfo {
    String id;
    Integer type_of_study;
    String name;
    Integer id_institut;
    Integer budget;
    Integer pay;


    public SpecialityMinInfo(){}

    public SpecialityMinInfo(String id, String name, Integer id_institut,
                      Integer type_of_study, Integer budget, Integer pay){
        this.id = id;
        this.name = name;
        this.id_institut = id_institut;
        this.type_of_study = type_of_study;
        this.budget = budget;
        this.pay = pay;
    }
}
