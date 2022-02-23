package com.page.vkr.controllers;

import com.page.vkr.dto.AuthorizationInfo;
import com.page.vkr.models.Users;
import com.page.vkr.repo.UsersRepository;
import com.page.vkr.repo.abit.AbitRepository;
import com.page.vkr.utils.HashPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("authorization")
public class AuthorizationController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AbitRepository abitRepository;

    @GetMapping
    public Object authorization(@RequestParam(value = "login")      String login,
                                           @RequestParam(value = "password")   String password) {
        Users user = usersRepository.findUserByLogin(login);
        if(user != null && user.getPassword().equals(HashPass.getHashSha256(password, user.getSalt1(), user.getSalt2()))){
            return AuthorizationInfo.builder()
                    .user(user)
                    .idEducation(abitRepository.findEducationById(user.getId_abit()))
                    .build();
        }
        return new ArrayList<HashMap<String, String>>() {{add(new HashMap<String, String>() {{put("status", "failed");}});}};
    }
}
