package com.page.vkr.repo.abit;

import com.page.vkr.models.abitExams.AbitExams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbitExamsRepository extends JpaRepository<AbitExams, Long> {
    @Query(value = "select * from abit_exams where id_abit=:id_abit", nativeQuery = true)
    List<AbitExams> findAllById_abit(@Param("id_abit") Long id_abit);
}
