package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ITeacherRepository  extends JpaRepository<Teacher, Integer> {

        @Query("select p from Teacher p where p.state=1")	//JPQL
        List<Teacher> findAllCustom();

        @Query("select p from Teacher p where Upper(p.name) like upper(:name) and p.state=1")	//JPQL
        List<Teacher> findByLikeName(@Param("name") String name);

        @Query("select p from Teacher p where Upper(p.name) like upper(:name) and p.state=1")
        Page<Teacher> findByLikeNamePaging(Pageable pageable, @Param("name") String name);
}
