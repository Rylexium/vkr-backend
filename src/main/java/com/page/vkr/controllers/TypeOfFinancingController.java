package com.page.vkr.controllers;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.models.TypeOfFinancing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type_of_financing")
public class TypeOfFinancingController {

    @GetMapping
    public List<TypeOfFinancing> type_of_financing() {
        return Cache.typeOfFinancings;
    }
}
