package com.page.vkr.repo;

import com.page.vkr.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "select * from users where login=:login", nativeQuery = true)
    Users findUserByLogin(@Param("login") String login);

    @Query(value = "select * from users where id_abit=:id_abit", nativeQuery = true)
    Users findById_abit(@Param("id_abit") Long id_abit);

    @Query(value = "select * from users where id_abit=(select id from abit where phone=:phone)", nativeQuery = true)
    Users findByPhone(@Param("phone") String phone);
}
