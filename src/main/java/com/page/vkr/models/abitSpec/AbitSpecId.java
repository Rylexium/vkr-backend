package com.page.vkr.models.abitSpec;

import java.io.Serializable;

public class AbitSpecId implements Serializable {
    private Long id_abit;
    private String id_spec;
    private Integer type_of_study;

    public AbitSpecId(){}

    public AbitSpecId(Long id_abit, String id_spec, Integer type_of_study){
        this.id_abit = id_abit;
        this.id_spec = id_spec;
        this.type_of_study = type_of_study;
    }
}
