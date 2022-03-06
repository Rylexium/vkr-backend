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
@RequestMapping("speciality/magistr")
public class SpecialityMagistrController {
    private final SpecialityRepository specialityRepository;
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

        if(next > Cache.specialitiesForMagistr.size()) next = Cache.specialitiesForMagistr.size();


        List<Object> res = new ArrayList<>();
        for(SpecialityMinInfo item : getSpecialityMinInfos(Cache.specialitiesForMagistr.subList(start, next))) {
            getInfoSpecialitys(res, item);
        }
        return res;
    }

    @GetMapping(value = "/info")
    public Object forInfoIdNameSpeciality(@RequestParam(value = "id_institut") Integer id_institut){
        List<Object> res = new ArrayList<>();
        for(String item : specialityRepository.findAllSpecialityForMagistrById_institut(id_institut)){
            String[] listItem = item.split(",");
            res.add(SpecialityIdNameInfo.builder()
                    .id(listItem[0])
                    .name(listItem[1])
                    .build());
        }
        return res;
    }

}
