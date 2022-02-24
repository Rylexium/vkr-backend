package com.page.vkr.controllers.speciality;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.min.SpecialityMinInfo;
import com.page.vkr.dto.min.SpecialityMinInfoAndInstitutAndTypeOfStudy;
import com.page.vkr.models.Institutions;
import com.page.vkr.models.TypeOfStudy;
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

import static com.page.vkr.controllers.speciality.SpecialityController.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("speciality/aspirant")
public class SpecialityAspirantController {

    @GetMapping
    public Object forAspirant(@RequestParam(value = "id_institut", defaultValue = "-1") Integer id_institut,
                                        @RequestParam(value = "start", defaultValue = "0") Integer start,
                                        @RequestParam(value = "next", defaultValue = "100") Integer next){
        if(next > Cache.specialitiesForAbit.size()) next = Cache.specialitiesForAspirant.size();

        return id_institut == -1? Cache.specialitiesForAspirant.subList(start, next) :
                                  Cache.specialitiesForAspirant.stream()
                                            .filter(e-> e.getId_facult().equals(id_institut))
                                            .findFirst()
                                            .orElse(null);
    }

    @GetMapping(value = "/min")
    public Object forAspirantMinInfo(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                           @RequestParam(value = "next", defaultValue = "100") Integer next){

        if(next > Cache.specialitiesForAspirant.size()) next = Cache.specialitiesForAspirant.size();

        List<Object> res = new ArrayList<>();
        for(SpecialityMinInfo item : getSpecialityMinInfos(Cache.specialitiesForAspirant.subList(start, next))) {
            getInfoSpecialitys(res, item);
        }
        return res;
    }
}
