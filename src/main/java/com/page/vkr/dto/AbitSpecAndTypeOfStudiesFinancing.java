package com.page.vkr.dto;

import com.page.vkr.models.Institutions;
import com.page.vkr.models.TypeOfFinancing;
import com.page.vkr.models.TypeOfStudy;
import com.page.vkr.models.abitSpec.AbitSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbitSpecAndTypeOfStudiesFinancing {
    AbitSpec abitSpec;
    TypeOfStudy typeOfStudy;
    String nameInstitution;
}
