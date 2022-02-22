package com.page.vkr.controllers.abit;

import com.page.vkr.models.AbitPrivileges;
import com.page.vkr.repo.abit.AbitPrivilegesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("abit")
public class AbitPrivilegesController {
    private final AbitPrivilegesRepository abitPrivilegesRepository;

    @GetMapping(value = "/privileges")
    public List<AbitPrivileges> abitPrivileges(@RequestParam("id_abit") Long id_abit){
        return abitPrivilegesRepository.findAllById_abit(id_abit);
    }
}
