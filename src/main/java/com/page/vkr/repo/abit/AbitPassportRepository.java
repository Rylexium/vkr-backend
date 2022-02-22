package com.page.vkr.repo.abit;

import com.page.vkr.models.AbitPassport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AbitPassportRepository extends JpaRepository<AbitPassport, Long> {
    @Query(value = "select * from abit_passport where id_abit=:id_abit", nativeQuery = true)
    Optional<AbitPassport> findById(@Param("id_abit") Long id_abit);
}
