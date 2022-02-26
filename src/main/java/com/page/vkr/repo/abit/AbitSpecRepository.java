package com.page.vkr.repo.abit;

import com.page.vkr.models.abitSpec.AbitSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AbitSpecRepository extends JpaRepository<AbitSpec, Long> {
    @Query(value = "select * from abit_spec where id_abit=:id_abit", nativeQuery = true)
    List<AbitSpec> findAllById_abit(@Param("id_abit") Long id_abit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM abit_spec " +
            "WHERE id_abit=:id_abit and id_spec=:id_spec and type_of_study=:type_of_study", nativeQuery = true)
    Integer deleteAbitSpecsById_abitAndId_specAndType_of_study(@Param("id_abit") Long id_abit,
                                                              @Param("id_spec") String id_spec,
                                                              @Param("type_of_study") Integer type_of_study);
}
