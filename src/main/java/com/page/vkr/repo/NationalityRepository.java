package com.page.vkr.repo;

import com.page.vkr.models.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NationalityRepository extends JpaRepository<Nationality, Integer> {
    @Query(value = "select * from nationality order by id", nativeQuery = true)
    List<Nationality> findAll();
}
