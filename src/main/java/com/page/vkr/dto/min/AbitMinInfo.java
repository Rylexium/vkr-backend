package com.page.vkr.dto.min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbitMinInfo {
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
}
