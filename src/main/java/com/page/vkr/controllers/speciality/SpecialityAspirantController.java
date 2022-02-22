package com.page.vkr.controllers.speciality;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.repo.InstitutionsRepository;
import com.page.vkr.repo.SpecialityRepository;
import com.page.vkr.repo.TypeOfStudyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.page.vkr.controllers.speciality.SpecialityController.getInstitutsMinInfos;
import static com.page.vkr.controllers.speciality.SpecialityController.getSpecialityMinInfos;


@RestController
@RequestMapping("speciality/aspirant")
public class SpecialityAspirantController {

    public SpecialityAspirantController(SpecialityRepository specialityRepository,
                                        InstitutionsRepository institutionsRepository,
                                        TypeOfStudyRepository typeOfStudyRepository) {
        if(Cache.specialitiesForAspirant == null) Cache.specialitiesForAspirant = specialityRepository.findAllForAspirant(0, 1000);
        if(Cache.typeOfStudies == null) Cache.typeOfStudies = typeOfStudyRepository.findAll();
        if(Cache.institutions == null) Cache.institutions = institutionsRepository.findAll();
    }

    @GetMapping
    public Object forAspirant(@RequestParam(value = "id_institut", defaultValue = "-1") Integer id_institut,
                                        @RequestParam(value = "start", defaultValue = "0") Integer start,
                                        @RequestParam(value = "next", defaultValue = "100") Integer next){
        if((start + next) > Cache.specialitiesForAspirant.size()){
            start = 0;
            next = Cache.specialitiesForAspirant.size();
        }

        return id_institut == -1? Cache.specialitiesForAspirant.subList(start, next) :
                                  Cache.specialitiesForAspirant.stream()
                                            .filter(e-> e.getId_facult().equals(id_institut))
                                            .findFirst()
                                            .orElse(null);
    }

    @GetMapping(value = "/min")
    public List<Object> forAspirantMinInfo(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                           @RequestParam(value = "next", defaultValue = "100") Integer next){
        if((start + next) > Cache.specialitiesForAspirant.size()){
            start = 0;
            next = Cache.specialitiesForAspirant.size();
        }
        List<Object> res = new ArrayList<>();
        res.add(getSpecialityMinInfos(Cache.specialitiesForAspirant.subList(start, next)));
        res.add(getInstitutsMinInfos(Cache.institutions));
        res.add(Cache.typeOfStudies);
        return res;
    }
}
