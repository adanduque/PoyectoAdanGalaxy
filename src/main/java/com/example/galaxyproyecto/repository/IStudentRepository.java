package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

        @Query("select p from Student p where p.state=1")	//JPQL
        List<Student> findAllCustom();

        @Query("select p from Student p where Upper(p.name) like upper(:name) and p.state=1")	//JPQL
        List<Student> findByLikeName(@Param("name") String name);

        @Query("select p from Student p where Upper(p.name) like upper(:name) and p.state=1")
        Page<Student> findByLikeNamePaging(Pageable pageable, @Param("name") String name);
}
