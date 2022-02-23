package com.page.vkr.dto;

import com.page.vkr.models.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbitSexNationalityEducationInfo {
    Abit abit;
    Sex sex;
    Nationality nationality;
    Education education;
    Privileges privilege;
}
