package com.page.vkr.controllers.cache;


import com.page.vkr.dto.min.MinPointsExamInfo;
import com.page.vkr.models.*;
import com.page.vkr.models.speciality.Speciality;

import java.util.List;

public class Cache {
    //Кэш неизменяемых таблиц
    public static List<Education> educations;
    public static List<Faculties> faculties;
    public static List<Institutions> institutions;
    public static List<Nationality> nationalities;
    public static List<Privileges> privileges;
    public static List<TypeOfStudy> typeOfStudies;
    public static List<TypeOfFinancing> typeOfFinancings;
    public static List<Exams> exams;
    public static List<MinPointsExamInfo> minPointsExamInfos;
    public static List<Sex> sexes;
    public static List<Speciality> specialitiesForAbit;
    public static List<Speciality> specialitiesForMagistr;
    public static List<Speciality> specialitiesForAspirant;
}
