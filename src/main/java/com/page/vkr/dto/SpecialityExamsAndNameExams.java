package com.page.vkr.dto;

import com.page.vkr.models.Exams;
import com.page.vkr.models.specialityExams.SpecialityExams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialityExamsAndNameExams {
    SpecialityExams specialityExams;
    Exams exams;
}
