package com.page.vkr.controllers.speciality;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.repo.InstitutionsRepository;
import com.page.vkr.repo.SpecialityRepository;
import com.page.vkr.repo.TypeOfStudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.page.vkr.controllers.speciality.SpecialityController.getInstitutsMinInfos;
import static com.page.vkr.controllers.speciality.SpecialityController.getSpecialityMinInfos;

@RequiredArgsConstructor
@RestController
@RequestMapping("speciality/magistr")
public class SpecialityMagistrController {

    @GetMapping
    public Object forMagistr(@RequestParam(value = "id_institut", defaultValue = "-1") Integer id_institut,
                                       @RequestParam(value = "start", defaultValue = "0") Integer start,
                                       @RequestParam(value = "next", defaultValue = "100") Integer next){
        if(next > Cache.specialitiesForAbit.size()) next = Cache.specialitiesForMagistr.size();

        return id_institut == -1? Cache.specialitiesForMagistr.subList(start, next) :
                                  Cache.specialitiesForMagistr.stream()
                                            .filter(e-> e.getId_facult().equals(id_institut))
                                            .findFirst()
                                            .orElse(null);
    }
    @GetMapping(value = "/min")
    public Object forMagistrMinInfo(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                          @RequestParam(value = "next", defaultValue = "100") Integer next){

        if(next > Cache.specialitiesForAbit.size()) next = Cache.specialitiesForMagistr.size();

        return getSpecialityMinInfos(Cache.specialitiesForMagistr.subList(start, next));
    }
}
