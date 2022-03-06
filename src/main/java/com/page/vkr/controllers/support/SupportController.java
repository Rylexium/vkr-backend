package com.page.vkr.controllers.support;

import com.page.vkr.repo.UsersRepository;
import com.page.vkr.repo.abit.AbitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("support")
public class SupportController {
    private final UsersRepository usersRepository;
    private final AbitRepository abitRepository;


    @GetMapping(value = "password")
    public HashMap<String, String> rememberPassword(@RequestParam(value = "login", required = false) String login,
                                                    @RequestParam(value = "phone", required = false) String phone,
                                                    @RequestParam(value = "id", required = false) Long id){
        String email = null;

        if(login != null)email = abitRepository.findById(usersRepository.findUserByLogin(login).getId_abit()).get().getEmail();
        else if (phone != null) email = abitRepository.findEmailByPhone(phone);
        else if(id != null) email = abitRepository.findById(id).get().getEmail();

        String finalEmail = email;
        return new HashMap<String, String>(){{put("email", finalEmail);}};
    }


    @GetMapping(value = "login")
    public HashMap<String, String> rememberLogin(@RequestParam(value = "id_abit", required = false) Long id_abit,
                                                 @RequestParam(value = "phone", required = false) String phone){
        String login = null;
        if(id_abit != null) login = usersRepository.findById_abit(id_abit).getLogin();
        else if(phone != null) login = abitRepository.findLoginById(phone);
        String finalLogin = login;
        return new HashMap<String, String>(){{put("login", finalLogin);}};
    }
}
