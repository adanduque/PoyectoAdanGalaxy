package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

        @Query("select p from Course p where p.state=1")	//JPQL
        List<Course> findAllCustom();

        @Query("select p from Course p where Upper(p.name) like upper(:name) and p.state=1")	//JPQL
        List<Course> findByLikeName(@Param("name") String name);

        @Query("select p from Course p where Upper(p.name) like upper(:name) and p.state=1")
        Page<Course> findByLikeNamePaging(Pageable pageable, @Param("name") String name);
}
