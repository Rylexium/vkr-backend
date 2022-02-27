package com.page.vkr.controllers.abit;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.AbitSexNationalityEducationInfo;
import com.page.vkr.dto.min.AbitEducationInfo;
import com.page.vkr.dto.min.AbitMinInfo;
import com.page.vkr.dto.min.AbitPassportInfo;
import com.page.vkr.dto.min.AbitPrivivelegesInfo;
import com.page.vkr.models.Abit;
import com.page.vkr.repo.EducationRepository;
import com.page.vkr.repo.NationalityRepository;
import com.page.vkr.repo.SexRepository;
import com.page.vkr.repo.abit.AbitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
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

        res.abit(AbitMinInfo.builder() //всё кроме фото
                .id(abit.getId())
                .phone(abit.getPhone())
                .email(abit.getEmail())
                .family(abit.getFamily())
                .name(abit.getName())
                .patronymic(abit.getPatronymic())
                .sex(abit.getSex())
                .id_nationality(abit.getId_nationality())
                .passport(abit.getPassport())
                .departament_code(abit.getDepartament_code())
                .const_address(abit.getConst_address())
                .actual_address(abit.getActual_address())
                .id_education(abit.getId_education())
                .number_education(abit.getNumber_education())
                .reg_number_education(abit.getReg_number_education())
                .date_of_issing_passport(abit.getDate_of_issing_passport())
                .date_of_issing_education(abit.getDate_of_issing_education())
                .date_of_birthday(abit.getDate_of_birthday())
                .id_privileges(abit.getId_privileges())
                .build());



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
        if(abit.getId_privileges() != null)
            res.privilege(Cache.privileges.stream()
                                            .filter(e -> e.getId().equals(abit.getId_privileges()))
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
    public HashMap<String, String> addAbit(@RequestBody Abit abit){
        abitRepository.save(abit);
        return new HashMap<String, String>(){{put("status", "successful");}};
    }

    @GetMapping(value = "/passport")
    public Object passports(@RequestParam("id") Long id){
        Abit abit;
        try {
            abit = abitRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }

        return AbitPassportInfo.builder()
                .passport1(abit.getPassport1())
                .passport2(abit.getPassport2())
                .snills(abit.getSnills())
                .build();

    }

    @GetMapping(value = "/education")
    public Object educations(@RequestParam("id") Long id){
        Abit abit;
        try {
            abit = abitRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }

        return AbitEducationInfo.builder()
                .education1(abit.getEducation1())
                .education2(abit.getEducation2())
                .build();

    }

    @GetMapping(value = "/privileges")
    public Object privileges(@RequestParam("id") Long id){
        Abit abit;
        try {
            abit = abitRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }

        return AbitPrivivelegesInfo.builder()
                .achievement1(abit.getAchievement1())
                .achievement2(abit.getAchievement2())
                .achievement3(abit.getAchievement3())
                .achievement4(abit.getAchievement4())
                .achievement5(abit.getAchievement5())
                .build();

    }
}
