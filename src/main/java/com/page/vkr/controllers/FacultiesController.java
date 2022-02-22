package com.page.vkr.controllers;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.models.Faculties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("faculties")
public class FacultiesController {

    @GetMapping
    public List<Faculties> faculties() {
        return Cache.faculties;
    }
}
