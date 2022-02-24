package com.page.vkr.repo;


import com.page.vkr.models.Institutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InstitutionsRepository extends JpaRepository<Institutions, Integer> {

    @Query(value = "select * from institutions where id=:id", nativeQuery = true)
    Optional<Institutions> findById(@Param("id") Integer id);

    @Query(value = "SELECT (select name from institutions where id=id_institut) from speciality " +
            "where id=:id_spec and type_of_study=:type_of_study", nativeQuery = true)
    String getNameInstitutionsById(@Param("id_spec") String id_spec, @Param("type_of_study") Integer type_of_study);

}
