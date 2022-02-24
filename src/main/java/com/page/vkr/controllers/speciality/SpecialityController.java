package com.page.vkr.controllers.speciality;

import com.page.vkr.controllers.cache.Cache;
import com.page.vkr.dto.SpecialityInstitutCuratorFacultInfo;
import com.page.vkr.dto.min.InstitutionsMinInfo;
import com.page.vkr.dto.min.SpecialityMinInfo;
import com.page.vkr.models.Institutions;
import com.page.vkr.models.speciality.Speciality;
import com.page.vkr.repo.EmployeesRepository;
import com.page.vkr.repo.FacultiesRepository;
import com.page.vkr.repo.InstitutionsRepository;
import com.page.vkr.repo.SpecialityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("speciality")
public class SpecialityController {

    private final SpecialityRepository specialityRepository;
    private final EmployeesRepository employeesRepository;

    public SpecialityController(SpecialityRepository specialityRepository,
                                EmployeesRepository employeesRepository,
                                InstitutionsRepository institutionsRepository,
                                FacultiesRepository facultiesRepository) {
        this.specialityRepository = specialityRepository;
        this.employeesRepository = employeesRepository;
        if(Cache.institutions == null) Cache.institutions = institutionsRepository.findAll();
        if(Cache.faculties == null) Cache.faculties = facultiesRepository.findAll();
    }


    @GetMapping
    public Object speciality(@RequestParam(value = "id") String id,
                               @RequestParam(value = "type_of_study") Integer type_of_study) {

        if(id == null || type_of_study == null) return specialityRepository.findAll();

        try{
            Speciality speciality = specialityRepository.findByIdAndTypeOfStudy(id, type_of_study);

            SpecialityInstitutCuratorFacultInfo
                    .SpecialityInstitutCuratorFacultInfoBuilder res = SpecialityInstitutCuratorFacultInfo.builder();

            res.speciality(speciality);
            if(speciality.getCurator() != null)
                res.curator(employeesRepository.findById(speciality.getCurator()));
            if(speciality.getId_institut() != null)
                res.institution(Cache.institutions.stream().filter(e -> e.getId().equals(speciality.getId_institut()))
                                                            .findFirst()
                                                            .orElse(null));
            if(speciality.getId_facult() != null)
                res.facult(Cache.faculties.stream().filter(e -> e.getId().equals(speciality.getId_facult()))
                                                            .findFirst()
                                                            .orElse(null));

            return res.build();
        }
        catch (Exception e){
            return null;
        }
    }

    public static List<SpecialityMinInfo> getSpecialityMinInfos(List<Speciality> query) {
        List<SpecialityMinInfo> list = new ArrayList<>();
        for (Speciality speciality : query)
            list.add(new SpecialityMinInfo(speciality.getId(), speciality.getName(), speciality.getId_institut(),
                    speciality.getType_of_study(), speciality.getBudget(), speciality.getPay()));
        return list;
    }

    public static List<InstitutionsMinInfo> getInstitutsMinInfos(List<Institutions> query){
        List<InstitutionsMinInfo> res = new ArrayList<>();
        for (Institutions institutions : query)
            res.add(new InstitutionsMinInfo(institutions.getId(), institutions.getName()));
        return res;
    }
}
