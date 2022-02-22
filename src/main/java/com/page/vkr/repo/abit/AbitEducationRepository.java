package com.page.vkr.repo.abit;

import com.page.vkr.models.AbitEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AbitEducationRepository extends JpaRepository<AbitEducation, Long> {
    @Query(value = "select * from abit_education where id_abit=:id_abit", nativeQuery = true)
    AbitEducation findById_abit(@Param("id_abit") Long id_abit);
}
