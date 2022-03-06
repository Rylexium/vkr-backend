package com.page.vkr.controllers.support;

import com.page.vkr.models.Users;
import com.page.vkr.repo.UsersRepository;
import com.page.vkr.repo.abit.AbitRepository;
import com.page.vkr.service.EmailSenderService;
import com.page.vkr.utils.HashPass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("support")
public class SupportController {
    private final UsersRepository usersRepository;
    private final AbitRepository abitRepository;

    @Autowired
    private EmailSenderService emailSenderService;


    @GetMapping(value = "password")
    public HashMap<String, String> rememberPassword(@RequestParam(value = "login", required = false) String login,
                                                    @RequestParam(value = "phone", required = false) String phone,
                                                    @RequestParam(value = "id", required = false) Long id){
        String email = "";
        Users user = null;
        if(login != null){
            email = abitRepository.findById(usersRepository.findUserByLogin(login).getId_abit()).get().getEmail();
            user = usersRepository.findUserByLogin(login);
        }
        else if (phone != null){
            email = abitRepository.findEmailByPhone(phone);
            user = usersRepository.findByPhone(phone);
        }
        else if(id != null){
            email = abitRepository.findById(id).get().getEmail();
            user = usersRepository.findById_abit(id);
        }

        StringBuilder code = new StringBuilder("");
        for(int i = 0; i<4; ++i)
            code.append((int)Math.floor(Math.random()*10));
        String finalEmail = email;

        user.setConfirm_code(code.toString());
        usersRepository.save(user);
        new Thread(()-> emailSenderService.sendSimpleEmail(finalEmail, "Код подтверждения: " + code, "spring")).start();

        if(login == null) login = user.getLogin();
        String finalLogin = login;
        return new HashMap<String, String>(){{put("login", finalLogin);}};
    }

    @GetMapping(value = "confirm_code")
    public HashMap<String, String> confirmCodeForUser(@RequestParam(value = "login", required = false) String login,
                                                      @RequestParam(value = "code") String code){
        Users user = usersRepository.findUserByLogin(login);

        if(user.getConfirm_code().equals(code)) {
            user.setConfirm_code("");
            usersRepository.save(user);
            return new HashMap<String, String>() {{put("status", "successful");}};
        }
        return null;
    }

    @PostMapping(value = "change_password")
    public HashMap<String, String> changePasswordForUser(@RequestParam(value = "login") String login,
                                                         @RequestParam("password") String password){
        Users user = usersRepository.findUserByLogin(login);

        user.setPassword(HashPass.getHashSha256(password, user.getSalt1(), user.getSalt2()));
        usersRepository.save(user);
        return new HashMap<String, String>() {{put("status", "successful");}};
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
