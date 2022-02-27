package com.page.vkr.repo;

import com.page.vkr.models.TypeOfFinancing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeOfFinancingRepository extends JpaRepository<TypeOfFinancing, Integer> {
    @Query(value = "select * from type_of_financing order by id", nativeQuery = true)
    List<TypeOfFinancing> findAll();
}
