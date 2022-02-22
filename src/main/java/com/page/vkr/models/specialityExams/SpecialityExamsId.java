package com.page.vkr.models.specialityExams;

import java.io.Serializable;

public class SpecialityExamsId implements Serializable {
    private String id_spec;
    private Integer id_exam;

    public SpecialityExamsId(){}

    public SpecialityExamsId(String id_spec, Integer id_exam){
        this.id_spec = id_spec;
        this.id_exam = id_exam;
    }
}
