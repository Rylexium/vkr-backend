package com.page.vkr.controllers;

import com.page.vkr.controllers.cache.Cache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exams")
public class ExamsController {
    @GetMapping
    public Object exams(@RequestParam(value = "id", defaultValue = "-1") Integer id) {
        return (id == -1)? Cache.exams :
                           Cache.exams.stream().filter(e-> e.getId().equals(id)).findAny().orElse(null);
    }

}
