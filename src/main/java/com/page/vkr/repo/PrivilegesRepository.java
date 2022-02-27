package com.page.vkr.repo;


import com.page.vkr.models.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivilegesRepository extends JpaRepository<Privileges, Integer> {
    @Query(value = "select * from privileges order by id", nativeQuery = true)
    List<Privileges> findAll();
}
