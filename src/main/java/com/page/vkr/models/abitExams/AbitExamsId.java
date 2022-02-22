package com.page.vkr.models.abitExams;

import java.io.Serializable;

public class AbitExamsId implements Serializable {
    private Long id_abit;
    private Integer id_exam;

    public AbitExamsId(){}

    public AbitExamsId(Long id_abit, Integer id_exam){
        this.id_abit = id_abit;
        this.id_exam = id_exam;
    }
}
