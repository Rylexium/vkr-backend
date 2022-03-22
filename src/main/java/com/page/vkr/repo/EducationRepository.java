package com.page.vkr.repo;

import com.page.vkr.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Integer> {
    @Query(value = "select * from education order by id", nativeQuery = true)
    List<Education> findAll();
}
