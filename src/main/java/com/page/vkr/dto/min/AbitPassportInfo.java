package com.page.vkr.dto.min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbitPassportInfo {
    private String passport1;
    private String passport2;
    private String snills;
}
