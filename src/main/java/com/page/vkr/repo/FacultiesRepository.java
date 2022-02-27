package com.page.vkr.repo;


import com.page.vkr.models.Faculties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FacultiesRepository extends JpaRepository<Faculties, Integer> {
    @Query(value = "select * from faculties where id=:id", nativeQuery = true)
    Optional<Faculties> findById(@Param("id") Integer id);

    @Query(value = "select * from faculties order by id", nativeQuery = true)
    List<Faculties> findAll();
}
