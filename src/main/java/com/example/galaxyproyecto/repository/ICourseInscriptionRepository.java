package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.CourseInscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseInscriptionRepository extends JpaRepository<CourseInscription, Integer> {

        @Query("select p from CourseInscription p where p.state=1")	//JPQL
        List<CourseInscription> findAllCustom();
}
