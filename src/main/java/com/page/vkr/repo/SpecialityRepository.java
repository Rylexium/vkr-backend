package com.page.vkr.repo;

import com.page.vkr.models.speciality.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    @Query(value = "select * from speciality where id like '%.03.%' or id like '%.05.%' order by id " +
                    "OFFSET :start ROWS FETCH NEXT :next ROWS ONLY", nativeQuery = true)
    List<Speciality > findAllForAbit(@Param("start") Integer start,
                                     @Param("next") Integer next);

    @Query(value = "select * from speciality where id like '%.04.%' order by id " +
                    "OFFSET :start ROWS FETCH NEXT :next ROWS ONLY", nativeQuery = true)
    List<Speciality > findAllForMagistr(@Param("start") Integer start,
                                        @Param("next") Integer next);

    @Query(value = "select * from speciality where id like '%.06.%' order by id " +
                    "OFFSET :start ROWS FETCH NEXT :next ROWS ONLY", nativeQuery = true)
    List<Speciality > findAllForAspirant(@Param("start") Integer start,
                                         @Param("next") Integer next);

    @Query(value = "select * from speciality " +
            "where id_institut=:id_institut and id like '%.03.%' or id like '%.05.%' order by id", nativeQuery = true)
    List<Speciality > findAllForAbitWhereInstitut(@Param("id_institut") Integer id_institut);

    @Query(value = "select * from speciality " +
            "where id_institut=:id_institut and id like '%.04.%' order by id", nativeQuery = true)
    List<Speciality > findAllForMagistrWhereInstitut(@Param("id_institut") Integer id_institut);

    @Query(value = "select * from speciality " +
            "where id_institut=:id_institut and id like '%.06.%' order by id", nativeQuery = true)
    List<Speciality > findAllForAspirantWhereInstitut(@Param("id_institut") Integer id_institut);


    @Query(value = "select * from speciality where id=:id and type_of_study=:type_of_study", nativeQuery = true)
    Speciality findByIdAndTypeOfStudy(@Param("id") String id,
                        @Param("type_of_study") Integer type_of_study);

}
