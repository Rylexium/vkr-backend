package com.page.vkr.controllers.abit;


import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.models.abitSpec.AbitSpec;
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

    @GetMapping(value = "")
    public List<HashMap<String, Object>> abitSpecs(@RequestParam("id_abit") Long id_abit) {
        List<AbitSpec> list = abitSpecRepository.findAllById_abit(id_abit);
        if(list.size() == 0) return null;

        List<HashMap<String, Object>> res = new ArrayList<>();
        res.add(new HashMap<String, Object>(){{put("abit_spec", list);}});
        res.add(new HashMap<String, Object>(){{put("type_of_study", Cache.typeOfStudies);}});
        res.add(new HashMap<String, Object>(){{put("type_of_financing",Cache.typeOfFinancings);}});
        return res;
    }

    @PostMapping(value = "/add")
    public void addAbitSpec(@RequestBody AbitSpec abitSpec){
        abitSpecRepository.save(abitSpec);
    }

    @DeleteMapping(value = "/delete")
    public HashMap<String, String> editAbitSpec(@RequestParam("id_abit") Long id_abit,
                               @RequestParam("id_spec") String id_spec,
                               @RequestParam("type_of_study") Integer type_of_study){
        return abitSpecRepository.deleteAbitSpecsById_abitAndId_specAndType_of_study(id_abit, id_spec, type_of_study) == 1?
                new HashMap<String, String>(){{put("status", "successful");}} : new HashMap<String, String>(){{put("status", "failed");}};
    }

}
