package com.page.vkr.controllers;


import com.page.vkr.models.Users;
import com.page.vkr.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersRepository usersRepository;
    @PostMapping(value = "/add")
    public void addUser(@RequestBody Users user){
        usersRepository.save(new Users(user));
    }
}
