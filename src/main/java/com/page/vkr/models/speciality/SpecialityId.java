package com.page.vkr.models.speciality;

import java.io.Serializable;

public class SpecialityId implements Serializable {
    private String id;
    private Integer type_of_study;
    public SpecialityId(){}
    public SpecialityId(String id, Integer type_of_study){
        this.id = id;
        this.type_of_study = type_of_study;
    }

}
