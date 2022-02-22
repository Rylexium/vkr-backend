package com.page.vkr.controllers;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.min.MinPointsExamInfo;
import com.page.vkr.models.specialityExams.SpecialityExams;
import com.page.vkr.repo.SpecialityExamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("speciality_exams")
public class SpecialityExamsController {
    private final SpecialityExamsRepository specialityExamsRepository;

    @GetMapping
    public List<SpecialityExams> specialityExams(@RequestParam(value = "id_spec") String id_spec) {
        return (id_spec == null)? specialityExamsRepository.findAll() :
                                  specialityExamsRepository.findById_spec(id_spec);
    }

    @GetMapping(value = "/min")
    public List<MinPointsExamInfo> minPointsExams(){
        return Cache.minPointsExamInfos;
    }

}
