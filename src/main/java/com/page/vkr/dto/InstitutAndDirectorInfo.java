package com.page.vkr.dto;

import com.page.vkr.models.Employees;
import com.page.vkr.models.Institutions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutAndDirectorInfo {
    Institutions institution;
    Employees director;
}
