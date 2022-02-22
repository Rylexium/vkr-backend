package com.page.vkr.models.specialityExams;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="speciality_exams")
@Data //auto generat getters and setters
@IdClass(SpecialityExamsId.class)
public class SpecialityExams {
    @Id
    private String id_spec;
    @Id
    private Integer id_exam;
    private Integer min_points;

    public SpecialityExams(){}
    public SpecialityExams(String id_spec, Integer id_exam, Integer min_points){
        this.id_spec = id_spec;
        this.id_exam = id_exam;
        this.min_points = min_points;
    }
}
