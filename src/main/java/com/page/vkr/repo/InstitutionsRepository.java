package com.page.vkr.repo;


import com.page.vkr.models.Institutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InstitutionsRepository extends JpaRepository<Institutions, Integer> {

    @Query(value = "select * from institutions where id=:id", nativeQuery = true)
    Optional<Institutions> findById(@Param("id") Integer id);

}
