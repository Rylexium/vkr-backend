package com.page.vkr.dto;

import com.page.vkr.models.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationInfo {
    private Users user;
    private Integer idEducation;
}
