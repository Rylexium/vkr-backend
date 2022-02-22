package com.page.vkr.dto.min;

public class MinPointsExamInfo {
    public Integer id_exam;
    public String name;
    public Integer min_points;

    public MinPointsExamInfo(Integer id, String name){}

    public MinPointsExamInfo(Integer id_exam, String name, Integer min_points){
        this.id_exam = id_exam;
        this.name = name;
        this.min_points = min_points;
    }

}
