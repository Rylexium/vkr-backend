package com.page.vkr.controllers.abit;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.AbitSpecAndTypeOfStudiesFinancing;
import com.page.vkr.models.Institutions;
import com.page.vkr.models.abitSpec.AbitSpec;
import com.page.vkr.repo.InstitutionsRepository;
import com.page.vkr.repo.SpecialityRepository;
import com.page.vkr.repo.abit.AbitSpecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("abit/spec")
public class AbitSpecController {
    private final AbitSpecRepository abitSpecRepository;
    private final InstitutionsRepository institutionsRepository;
    private final SpecialityRepository specialityRepository;

    @GetMapping(value = "")
    public List<AbitSpecAndTypeOfStudiesFinancing> abitSpecs(@RequestParam("id_abit") Long id_abit) {
        List<AbitSpec> list = abitSpecRepository.findAllById_abit(id_abit);
        if(list.size() == 0) return null;
        List<AbitSpecAndTypeOfStudiesFinancing> res = new ArrayList<>();

        list.forEach(abitSpec-> {
            AbitSpecAndTypeOfStudiesFinancing.AbitSpecAndTypeOfStudiesFinancingBuilder item = AbitSpecAndTypeOfStudiesFinancing.builder();
            item.abitSpec(abitSpec);
            if(abitSpec.getType_of_study() != null)
                item.typeOfStudy(Cache.typeOfStudies.stream()
                        .filter(e -> e.getId().equals(abitSpec.getType_of_study()))
                        .findFirst().orElse(null));
            item.nameInstitution(institutionsRepository.getNameInstitutionsById(abitSpec.getId_spec(), abitSpec.getType_of_study()));
            item.nameSpec(specialityRepository.getNameSpecByIdAndType_of_study(abitSpec.getId_spec(), abitSpec.getType_of_study()));
            res.add(item.build());
        });

        return res;
    }

    @PostMapping(value = "/add")
    public void addAbitSpec(@RequestBody List<AbitSpec> abitSpec){
        abitSpecRepository.saveAll(abitSpec);
    }

    @DeleteMapping(value = "/delete")
    public HashMap<String, String> deleteAbitSpec(@RequestParam("id_abit") Long id_abit,
                               @RequestParam("id_spec") String id_spec,
                               @RequestParam("type_of_study") Integer type_of_study){
        return abitSpecRepository.deleteAbitSpecsById_abitAndId_specAndType_of_study(id_abit, id_spec, type_of_study) == 1?
                new HashMap<String, String>(){{put("status", "successful");}} : new HashMap<String, String>(){{put("status", "failed");}};
    }

    @PutMapping(value = "/update")
    public void updateAbitSpec(@RequestBody List<AbitSpec> abitSpec){
        abitSpecRepository.saveAll(abitSpec);
    }

}
