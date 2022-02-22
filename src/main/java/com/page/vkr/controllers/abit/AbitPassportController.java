package com.page.vkr.controllers.abit;;


import com.page.vkr.models.AbitPassport;
import com.page.vkr.repo.abit.AbitPassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("abit/passport")
public class AbitPassportController {
    private final AbitPassportRepository abitPassportRepository;

    @GetMapping
    public AbitPassport abitPassports(@RequestParam("id_abit") Long id_abit) {
        return abitPassportRepository.findById(id_abit).get();
    }

    @PostMapping(value = "/add")
    public void addAbitPassports(@RequestBody AbitPassport abitPassport){
        abitPassportRepository.save(abitPassport);
    }
}
