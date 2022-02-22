package com.page.vkr.repo;

import com.page.vkr.models.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SexRepository extends JpaRepository<Sex, Integer> {
    @Query(value = "select * from sex where id=:id", nativeQuery = true)
    Sex findById(@Param("id") Boolean id);

}
