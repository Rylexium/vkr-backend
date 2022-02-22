package com.page.vkr.controllers;

import com.page.vkr.repo.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("employees")
public class EmployeesController {
    private final EmployeesRepository employeesRepository;
    @GetMapping
    public Object employees(@RequestParam(value = "id", defaultValue = "-1") Integer id){
        return (id == -1)? employeesRepository.findAll() : employeesRepository.findById(id);
    }
}
