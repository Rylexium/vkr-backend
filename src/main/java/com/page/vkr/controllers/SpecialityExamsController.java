package com.page.vkr.controllers;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.SpecialityExamsAndNameExams;
import com.page.vkr.dto.min.MinPointsExamInfo;
import com.page.vkr.models.specialityExams.SpecialityExams;
import com.page.vkr.repo.SpecialityExamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("speciality_exams")
public class SpecialityExamsController {
    private final SpecialityExamsRepository specialityExamsRepository;

    @GetMapping
    public Object specialityExams(@RequestParam(value = "id_spec") String id_spec) {
        if(id_spec == null) return specialityExamsRepository.findAll();
        else {
            List<Object> res = new ArrayList<>();
            for(SpecialityExams item : specialityExamsRepository.findById_spec(id_spec))
                res.add(SpecialityExamsAndNameExams.builder()
                            .specialityExams(item)
                            .exams(Cache.exams.stream()
                                    .filter(e->e.getId().equals(item.getId_exam()))
                                    .findFirst()
                                    .orElse(null))
                            .build());
            return res;
        }
    }

    @GetMapping(value = "/min")
    public List<MinPointsExamInfo> minPointsExams(){
        return Cache.minPointsExamInfos;
    }

}
