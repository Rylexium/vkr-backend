package com.page.vkr.repo;

import com.page.vkr.models.TypeOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeOfStudyRepository extends JpaRepository<TypeOfStudy, Integer> {
    @Query(value = "select * from type_of_study order by id", nativeQuery = true)
    List<TypeOfStudy> findAll();
}
