package com.page.vkr.controllers;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.models.Privileges;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("privileges")
public class PrivilegesController {
    @GetMapping
    public List<Privileges> privileges() {
        return Cache.privileges;
    }
}
