package com.page.vkr.controllers.abit;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.AbitExamsInfo;
import com.page.vkr.models.abitExams.AbitExams;
import com.page.vkr.repo.abit.AbitExamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("abit/exams")
public class AbitExamsController {
    private final AbitExamsRepository abitExamsRepository;

    @GetMapping
    public List<Object> abitExams(@RequestParam("id_abit") Long id_abit) {
        List<AbitExams> abitExams = abitExamsRepository.findAllById_abit(id_abit);
        List<Object> result = null;
        if(abitExams != null){
            result = new ArrayList<Object>();
            for(AbitExams item : abitExams){
                result.add(AbitExamsInfo.builder()
                        .abitExams(item)
                        .exams(Cache.exams.stream().filter(e -> e.getId().equals(item.getId_exam()))
                                .findFirst()
                                .orElse(null))
                        .build());
            }
        }
        return result;
    }
    @PostMapping(value = "/add")
    public HashMap<String, String> addAbitExams(@RequestBody List<AbitExams> exams){
        abitExamsRepository.saveAll(exams);
        return new HashMap<String, String>(){{put("status", "successful");}};
    }
}
