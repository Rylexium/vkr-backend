package com.page.vkr.repo;


import com.page.vkr.models.specialityExams.SpecialityExams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecialityExamsRepository extends JpaRepository<SpecialityExams, Integer> {

    @Query(value = "select distinct id_exam,min_points from speciality_exams order by id_exam, min_points", nativeQuery = true)
    List<String> findMinPointsExams();

    @Query(value = "select * from speciality_exams where id_spec=:id_spec", nativeQuery = true)
    List<SpecialityExams> findById_spec(@Param("id_spec") String id_spec);

}
