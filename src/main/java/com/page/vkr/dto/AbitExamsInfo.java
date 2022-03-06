package com.page.vkr.dto;

import com.page.vkr.models.Exams;
import com.page.vkr.models.abitExams.AbitExams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbitExamsInfo {
    AbitExams abitExams;
    Exams exams;
}
