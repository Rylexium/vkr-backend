package com.page.vkr.controllers.speciality;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.min.SpecialityIdNameInfo;
import com.page.vkr.dto.min.SpecialityMinInfo;
import com.page.vkr.repo.SpecialityRepository;
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
@RequestMapping("speciality/abit")
public class SpecialityAbitController {
    private final SpecialityRepository specialityRepository;

    @GetMapping
    public Object forAbit(@RequestParam(value = "id_institut", defaultValue = "-1") Integer id_institut,
                                    @RequestParam(value = "start", defaultValue = "0") Integer start,
                                    @RequestParam(value = "next", defaultValue = "100") Integer next){

        if(next > Cache.specialitiesForAbit.size()) next = Cache.specialitiesForAbit.size();

        return id_institut == -1? Cache.specialitiesForAbit.subList(start, next) :
                                  Cache.specialitiesForAbit.stream()
                                            .filter(e-> e.getId_facult().equals(id_institut))
                                            .findFirst()
                                            .orElse(null);
    }

    @GetMapping(value = "min")
    public Object forAbitMinInfo(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                       @RequestParam(value = "next", defaultValue = "100") Integer next){

        if(next > Cache.specialitiesForAbit.size()) next = Cache.specialitiesForAbit.size();
        List<Object> res = new ArrayList<>();
        for(SpecialityMinInfo item : getSpecialityMinInfos (Cache.specialitiesForAbit.subList(start, next))) {
            getInfoSpecialitys(res, item);
        }
        return res;
    }

    @GetMapping(value = "/info")
    public Object forInfoIdNameSpeciality(@RequestParam(value = "id_institut") Integer id_institut){
        List<Object> res = new ArrayList<>();
        for(String item : specialityRepository.findAllSpecialityForAbitById_institut(id_institut)){
            List<String> listItem = List.of(item.split(","));
            res.add(SpecialityIdNameInfo.builder()
                    .id(listItem.get(0))
                    .name(listItem.get(1))
                    .build());
        }
        return res;
    }

}
