package com.page.vkr.models.abitExams;

import com.page.vkr.models.abitExams.AbitExamsId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="abit_exams")
@Data //auto generat getters and setters
@IdClass(AbitExamsId.class)
public class AbitExams {
    @Id
    private Long id_abit;
    @Id
    private Integer id_exam;
    private Integer points;
    private Integer year;

    public AbitExams(){
    }

    public AbitExams(Long id_abit, Integer id_exam, Integer points , Integer year){
        this.id_abit = id_abit;
        this.id_exam = id_exam;
        this.points = points;
        this.year = year;
    }
}
