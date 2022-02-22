package com.page.vkr.controllers;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.InstitutAndDirectorInfo;
import com.page.vkr.models.Institutions;
import com.page.vkr.repo.EmployeesRepository;;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("institutions")
public class InstitutionsController {
    private final EmployeesRepository employeesRepository;

    @GetMapping
    public Object institutions(@RequestParam(value = "id", defaultValue = "-1") Integer id_institut) {
        if(id_institut == -1) return Cache.institutions;
        Institutions institution = Cache.institutions.stream()
                                            .filter(e -> e.getId().equals(id_institut))
                                            .findFirst()
                                            .orElse(null);
        return (institution == null)? null: InstitutAndDirectorInfo.builder()
                                                                .institution(institution)
                                                                .director(employeesRepository.findById(institution.getId_director()))
                                                                .build();
    }
}
