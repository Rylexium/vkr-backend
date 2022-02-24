package com.page.vkr.dto;

import com.page.vkr.models.Employees;
import com.page.vkr.models.Faculties;
import com.page.vkr.models.Institutions;
import com.page.vkr.models.TypeOfStudy;
import com.page.vkr.models.speciality.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialityInstitutCuratorFacultInfo {
    Speciality speciality;
    Institutions institution;
    Employees curator;
    Faculties facult;
    TypeOfStudy typeOfStudy;
}
