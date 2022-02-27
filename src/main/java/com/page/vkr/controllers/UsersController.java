package com.page.vkr.controllers;


import com.page.vkr.models.Users;
import com.page.vkr.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersRepository usersRepository;
    @PostMapping(value = "/add")
    public HashMap<String, String> addUser(@RequestBody Users user){
        usersRepository.save(new Users(user));
        return new HashMap<String, String>(){{put("status", "successful");}};
    }

    @PutMapping
    public void updateIsEntry(@RequestParam("id_abit") Long id_abit){
        Users user = usersRepository.findById_abit(id_abit);
        user.setIs_entry(true);
        usersRepository.save(user);
    }
}
