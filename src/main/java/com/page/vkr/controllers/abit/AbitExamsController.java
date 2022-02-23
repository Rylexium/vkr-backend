package com.page.vkr.controllers.abit;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.AbitExamsInfo;
import com.page.vkr.models.abitExams.AbitExams;
import com.page.vkr.repo.ExamsRepository;
import com.page.vkr.repo.abit.AbitExamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("abit/exams")
public class AbitExamsController {
    private final AbitExamsRepository abitExamsRepository;

    @GetMapping
    public Object abitExams(@RequestParam("id_abit") Long id_abit) {
        List<AbitExams> abitExams = abitExamsRepository.findAllById_abit(id_abit);

        return (abitExams != null) ? AbitExamsInfo.builder()
                .abitExams(abitExams)
                .exams(Cache.exams)
                .build() : null;
    }
    @PostMapping(value = "/add")
    public void addAbitExams(@RequestBody List<AbitExams> exams){
        abitExamsRepository.saveAll(exams);
    }
}
