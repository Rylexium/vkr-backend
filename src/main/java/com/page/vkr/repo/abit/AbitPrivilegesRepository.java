package com.page.vkr.repo.abit;

import com.page.vkr.models.AbitPrivileges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AbitPrivilegesRepository extends JpaRepository<AbitPrivileges, Long> {
    @Query(value = "select * from abit_privileges where id_abit=:id_abit", nativeQuery = true)
    AbitPrivileges findAllById_abit(@Param("id_abit") Long id_abit);
}
