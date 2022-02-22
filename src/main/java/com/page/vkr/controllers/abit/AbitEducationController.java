package com.page.vkr.controllers.abit;

import com.page.vkr.models.AbitEducation;
import com.page.vkr.repo.abit.AbitEducationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("abit")
public class AbitEducationController {
    private AbitEducationRepository abitEducationRepository = null;

    public AbitEducationController() {
    }
    public AbitEducationController(AbitEducationRepository abitEducationRepository) {
        this.abitEducationRepository = abitEducationRepository;
    }

    @GetMapping(value = "/education")
    public AbitEducation abitEducations(@RequestParam("id_abit") Long id_abit){
        return abitEducationRepository.findById_abit(id_abit);
    }
}
