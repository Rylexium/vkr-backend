package com.page.vkr.controllers;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.models.Nationality;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("nationality")
public class NationalityController {

    @GetMapping
    public List<Nationality> nationalities() {
        return Cache.nationalities;
    }
}
