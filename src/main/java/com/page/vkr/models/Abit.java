package com.page.vkr.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="abit")
@Data //auto generat getters and setters
public class Abit {

    @Id
    private Long id;
    private String phone;
    private String email;
    private String family;
    private String name;
    private String patronymic;
    private Boolean sex;
    private Integer id_nationality;
    private Long passport;
    private Integer departament_code;
    private String const_address;
    private String actual_address;
    private Integer id_education;
    private Long number_education;
    private Long reg_number_education;
    private String date_of_issing_passport;
    private String date_of_issing_education;
    private String date_of_birthday;
    private Integer id_privileges;

    private String passport1;
    private String passport2;
    private String snills;

    private String education1;
    private String education2;

    private String achievement1;
    private String achievement2;
    private String achievement3;
    private String achievement4;
    private String achievement5;

    private String privileges;

    public Abit(){
    }

    public Abit(Long id,
            String phone,
            String email,
            String family,
            String name,
            String patronymic,
            Boolean sex,
            Integer id_nationality,
            Long passport,
            Integer departament_code,
            String const_address,
            String actual_address,
            Integer id_education,
            Long number_education,
            Long reg_number_education,
            String date_of_issing_passport,
            String date_of_issing_education,
            String date_of_birthday,
            Integer id_privileges,
            String passport1,
            String passport2,
            String snills,
            String education1,
            String education2,
            String achievement1,
            String achievement2,
            String achievement3,
            String achievement4,
            String achievement5)
    {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.id_nationality = id_nationality;
        this.passport = passport;
        this.departament_code = departament_code;
        this.const_address = const_address;
        this.actual_address = actual_address;
        this.id_education = id_education;
        this.number_education = number_education;
        this.reg_number_education = reg_number_education;
        this.date_of_issing_passport = date_of_issing_passport;
        this.date_of_issing_education = date_of_issing_education;
        this.date_of_birthday = date_of_birthday;
        this.id_privileges = id_privileges;
        this.passport1 = passport1;
        this.passport2 = passport2;
        this.snills = snills;
        this.education1 = education1;
        this.education2 = education2;
        this.achievement1 = achievement1;
        this.achievement2 = achievement2;
        this.achievement3 = achievement3;
        this.achievement4 = achievement4;
        this.achievement5 = achievement5;

    }
}
