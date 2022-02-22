package com.page.vkr.repo;


import com.page.vkr.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    Employees findById(@Param("id") Integer id);
}
