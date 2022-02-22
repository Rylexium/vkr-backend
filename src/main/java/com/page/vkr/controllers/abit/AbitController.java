package com.page.vkr.controllers.abit;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.AbitSexNationalityEducationInfo;
import com.page.vkr.models.Abit;
import com.page.vkr.repo.EducationRepository;
import com.page.vkr.repo.NationalityRepository;
import com.page.vkr.repo.SexRepository;
import com.page.vkr.repo.abit.AbitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("abit")
public class AbitController {
    private final AbitRepository abitRepository;

    @GetMapping(value = "")
    public Object abit(@RequestParam("id") Long id) {
        Abit abit;
        try {
            abit = abitRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }
        AbitSexNationalityEducationInfo.AbitSexNationalityEducationInfoBuilder res = AbitSexNationalityEducationInfo.builder();

        res.abit(abit);
        if(abit.getSex() != null)
            res.sex(Cache.sexes.stream().filter(e -> e.getId().equals(abit.getSex())).findFirst().orElse(null));
        if(abit.getId_nationality() != null)
            res.nationality(Cache.nationalities.stream()
                                            .filter(e -> e.getId().equals(abit.getId_nationality()))
                                            .findFirst().orElse(null));
        if(abit.getId_education() != null)
            res.education(Cache.educations.stream()
                                        .filter(e -> e.getId().equals(abit.getId_education()))
                                        .findFirst().orElse(null));

        return res.build();
    }

    @GetMapping(value = "check_unique")
    public HashMap<String, String> chechUniqueAttr(@RequestParam("id") String id,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("email") String email,
                                   @RequestParam("passport") String passport,
                                   @RequestParam("number_education") String number_education,
                                   @RequestParam("login") String login){
        List<String> uniqueAttrAbitList = abitRepository.findAllUniqueAttrAbit();
        for(String item : uniqueAttrAbitList){
            List<String> row = Arrays.asList(item.split(","));
            if(row.get(0).equals(id)) return new HashMap<String, String>(){{put("error", "id");}};
            if(row.get(1).equals(phone)) return new HashMap<String, String>(){{put("error", "phone");}};
            if(row.get(2).equals(email)) return new HashMap<String, String>(){{put("error", "email");}};
            if(row.get(3).equals(passport)) return new HashMap<String, String>(){{put("error", "passport");}};
            if(row.get(4).equals(number_education)) return new HashMap<String, String>(){{put("error", "number_education");}};
            if(row.get(5).equals(login)) return new HashMap<String, String>(){{put("error", "login");}};
        }
        return new HashMap<String, String>(){{put("error", "ok");}};
    }

    @PostMapping(value = "/add")
    public void addAbit(@RequestBody Abit abit){
        abitRepository.save(abit);
    }
}
