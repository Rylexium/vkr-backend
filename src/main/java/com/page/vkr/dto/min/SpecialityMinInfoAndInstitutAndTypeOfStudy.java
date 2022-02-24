package com.page.vkr.dto.min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialityMinInfoAndInstitutAndTypeOfStudy {
    SpecialityMinInfo specialityMinInfo;
    String institut;
    String typeOfStudy;
}
