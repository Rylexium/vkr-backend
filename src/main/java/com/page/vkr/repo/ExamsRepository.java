package com.page.vkr.repo;


import com.page.vkr.models.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExamsRepository extends JpaRepository<Exams, Integer> {
    @Query(value = "select * from exams where id=:id", nativeQuery = true)
    Optional<Exams> findById(@Param("id") Integer id);

    @Query(value = "select * from exams order by id", nativeQuery = true)
    List<Exams> findAll();
}
