package com.page.vkr.dto;

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
    String nameSpec;
    TypeOfStudy typeOfStudy;
    String nameInstitution;
}
