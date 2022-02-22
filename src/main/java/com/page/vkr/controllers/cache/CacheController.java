package com.page.vkr.controllers.cache;

import com.page.vkr.dto.min.MinPointsExamInfo;
import com.page.vkr.models.Exams;
import com.page.vkr.repo.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("update_cache")
public class CacheController {
    private final EducationRepository educationRepository;
    private final FacultiesRepository facultiesRepository;
    private final InstitutionsRepository institutionsRepository;
    private final NationalityRepository nationalityRepository;
    private final PrivilegesRepository privilegesRepository;
    private final TypeOfStudyRepository typeOfStudyRepository;
    private final TypeOfFinancingRepository typeOfFinancingRepository;
    private final ExamsRepository examsRepository;
    private final SexRepository sexRepository;
    private final SpecialityRepository specialityRepository;
    private final SpecialityExamsRepository specialityExamsRepository;

    public CacheController(EducationRepository educationRepository, FacultiesRepository facultiesRepository,
                           InstitutionsRepository institutionsRepository, NationalityRepository nationalityRepository,
                           PrivilegesRepository privilegesRepository, TypeOfStudyRepository typeOfStudyRepository,
                           TypeOfFinancingRepository typeOfFinancingRepository, ExamsRepository examsRepository,
                           SexRepository sexRepository, SpecialityRepository specialityRepository,
                           SpecialityExamsRepository specialityExamsRepository) {
        //Init Cache
        this.educationRepository = educationRepository;
        this.facultiesRepository = facultiesRepository;
        this.institutionsRepository = institutionsRepository;
        this.nationalityRepository = nationalityRepository;
        this.privilegesRepository = privilegesRepository;
        this.typeOfStudyRepository = typeOfStudyRepository;
        this.typeOfFinancingRepository = typeOfFinancingRepository;
        this.examsRepository = examsRepository;
        this.sexRepository = sexRepository;
        this.specialityRepository = specialityRepository;
        this.specialityExamsRepository = specialityExamsRepository;
        Cache.educations = educationRepository.findAll();
        Cache.faculties = facultiesRepository.findAll();
        Cache.institutions = institutionsRepository.findAll();
        Cache.nationalities = nationalityRepository.findAll();
        Cache.privileges = privilegesRepository.findAll();
        Cache.typeOfStudies = typeOfStudyRepository.findAll();
        Cache.typeOfFinancings = typeOfFinancingRepository.findAll();
        Cache.exams = examsRepository.findAll();
        Cache.sexes = sexRepository.findAll();
        Cache.specialitiesForAbit = specialityRepository.findAllForAbit(0, 1000);
        Cache.specialitiesForMagistr = specialityRepository.findAllForMagistr(0, 1000);
        Cache.specialitiesForAspirant = specialityRepository.findAllForAspirant(0, 1000);
        Cache.minPointsExamInfos = getMinPointsExams(specialityExamsRepository.findMinPointsExams());
        System.out.println("Cache has been init");
    }

    @GetMapping(value = "/rylexium")
    public List<HashMap<String, String>> updateCache(
                                               @RequestParam(value = "all", required = false, defaultValue = "false") Boolean all,
                                               @RequestParam(value = "education", required = false, defaultValue = "false") Boolean education,
                                               @RequestParam(value = "faculties", required = false, defaultValue = "false") Boolean faculties,
                                               @RequestParam(value = "institutions", required = false, defaultValue = "false") Boolean institutions,
                                               @RequestParam(value = "nationalities",required = false, defaultValue = "false") Boolean nationalities,
                                               @RequestParam(value = "privileges",required = false, defaultValue = "false") Boolean privileges,
                                               @RequestParam(value = "typeOfStudies",required = false, defaultValue = "false") Boolean typeOfStudies,
                                               @RequestParam(value = "typeOfFinancings",required = false, defaultValue = "false") Boolean typeOfFinancings,
                                               @RequestParam(value = "exams", required = false, defaultValue = "false") Boolean exams,
                                               @RequestParam(value = "sexes",required = false, defaultValue = "false") Boolean sexes,
                                               @RequestParam(value = "specialitiesForAbit", required = false,  defaultValue = "false") Boolean specialitiesForAbit,
                                               @RequestParam(value = "specialitiesForMagistr", required = false, defaultValue = "false") Boolean specialitiesForMagistr,
                                               @RequestParam(value = "specialitiesForAspirant", required = false, defaultValue = "false") Boolean specialitiesForAspirant,
                                               @RequestParam(value = "minPointsExamInfos", required = false, defaultValue = "false") Boolean minPointsExamInfos) {

        if(all){
            education = true;
            faculties = true;
            institutions = true;
            nationalities = true;
            privileges = true;
            typeOfStudies = true;
            typeOfFinancings = true;
            exams = true;
            sexes = true;
            specialitiesForAbit = true;
            specialitiesForMagistr = true;
            specialitiesForAspirant = true;
            minPointsExamInfos = true;
        }
        List<HashMap<String, String>> statusUpdate = new ArrayList<>();
        if(education){
            Cache.educations = educationRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("education", "cache updated");}});
        }
        if(faculties){
            Cache.faculties = facultiesRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("faculties", "cache updated");}});
        }
        if(institutions){
            Cache.institutions = institutionsRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("institutions", "cache updated");}});
        }
        if(nationalities){
            Cache.nationalities = nationalityRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("nationalities", "cache updated");}});
        }
        if(privileges){
            Cache.privileges = privilegesRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("privileges", "cache updated");}});
        }
        if(typeOfStudies){
            Cache.typeOfStudies = typeOfStudyRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("typeOfStudies", "cache updated");}});
        }
        if(typeOfFinancings){
            Cache.typeOfFinancings = typeOfFinancingRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("typeOfFinancings", "cache updated");}});
        }
        if(exams){
            Cache.exams = examsRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("exams", "cache updated");}});
        }
        if(sexes){
            Cache.sexes = sexRepository.findAll();
            statusUpdate.add(new HashMap<String, String>(){{put("sexes", "cache updated");}});
        }
        if(specialitiesForAbit){
            Cache.specialitiesForAbit = specialityRepository.findAllForAbit(0, 1000);
            statusUpdate.add(new HashMap<String, String>(){{put("specialitiesForAbit", "cache updated");}});
        }
        if(specialitiesForMagistr){
            Cache.specialitiesForMagistr = specialityRepository.findAllForMagistr(0, 1000);
            statusUpdate.add(new HashMap<String, String>(){{put("specialitiesForMagistr", "cache updated");}});
        }
        if(specialitiesForAspirant){
            Cache.specialitiesForAspirant = specialityRepository.findAllForAspirant(0, 1000);
            statusUpdate.add(new HashMap<String, String>(){{put("specialitiesForAspirant", "cache updated");}});
        }
        if(minPointsExamInfos){
            Cache.minPointsExamInfos = getMinPointsExams(specialityExamsRepository.findMinPointsExams());
            statusUpdate.add(new HashMap<String, String>(){{put("minPointsExamInfos", "cache updated");}});
        }

        if(statusUpdate.size() == 13) statusUpdate.add(new HashMap<String, String>(){{put("status", "all cache updated");}});
        return statusUpdate;
    }

    public static List<MinPointsExamInfo> getMinPointsExams(List<String> paramMinPointsExams){
        List<MinPointsExamInfo> returnedList = new ArrayList<>();
        Map<Integer, String> dictExams = new HashMap<>();
        for (Exams item : Cache.exams)
            dictExams.put(item.getId(), item.getName());

        for (String minPointsExam : paramMinPointsExams) {
            List<String> item = Arrays.asList(minPointsExam.split(","));
            boolean isAlready = false;
            for (int j = 0; j < returnedList.size() && !isAlready; j++) {
                if (returnedList.get(j).id_exam == Integer.parseInt(item.get(0)))
                    isAlready = true;
            }
            if (!isAlready)
                returnedList.add(new MinPointsExamInfo(Integer.parseInt(item.get(0)),
                        dictExams.get(Integer.parseInt(item.get(0))),
                        Integer.parseInt(item.get(1))));
        }
        return returnedList;
    }

}
