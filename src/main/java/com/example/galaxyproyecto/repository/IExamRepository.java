package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.Course;
import com.example.galaxyproyecto.model.Exam;
import com.example.galaxyproyecto.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExamRepository extends JpaRepository<Exam, Integer> {
    @Query("select p from Exam p where p.state=1")	//JPQL
    List<Exam> findAllCustom();

    @Query("select p from Exam p where Upper(p.name) like upper(:name) and p.state=1")	//JPQL
    List<Exam> findByLikeName(@Param("name") String name);

    @Query("select p from Exam p where Upper(p.name) like upper(:name) and p.state=1")
    Page<Exam> findByLikeNamePaging(Pageable pageable, @Param("name") String name);
}
