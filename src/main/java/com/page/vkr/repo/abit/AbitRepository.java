package com.page.vkr.repo.abit;

import com.page.vkr.models.Abit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AbitRepository extends JpaRepository<Abit, Long> {

    @Query(value = "select * from abit where id=:id", nativeQuery = true)
    Optional<Abit> findById(@Param("id") Long id);

    @Query(value = "select id_education from abit where id=:id", nativeQuery = true)
    Integer findEducationById(@Param("id") Long id);

    @Query(value = "SELECT id, phone, email, passport, number_education, login FROM abit, users where id_abit=id", nativeQuery = true)
    List<String> findAllUniqueAttrAbit();
}
