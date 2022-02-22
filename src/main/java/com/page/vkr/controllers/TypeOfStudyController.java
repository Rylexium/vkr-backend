package com.page.vkr.controllers;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.models.TypeOfStudy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type_of_study")
public class TypeOfStudyController {

    @GetMapping
    public List<TypeOfStudy> type_of_study() {
        return Cache.typeOfStudies;
    }
}