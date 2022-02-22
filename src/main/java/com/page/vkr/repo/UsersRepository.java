package com.page.vkr.repo;

import com.page.vkr.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "select * from users where login=:login", nativeQuery = true)
    Users findUserByLogin(@Param("login") String login);
}
