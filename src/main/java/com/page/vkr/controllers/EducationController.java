package com.page.vkr.controllers;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.models.Education;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("education")
public class EducationController {
    @GetMapping
    public List<Education> educations() {
        return Cache.educations;
    }
}
