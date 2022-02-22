package com.page.vkr.dto;

import com.page.vkr.models.Exams;
import com.page.vkr.models.abitExams.AbitExams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbitExamsInfo {
    List<AbitExams> abitExams;
    List<Exams> exams;
}
