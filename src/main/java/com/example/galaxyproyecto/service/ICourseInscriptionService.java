package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.CourseInscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICourseInscriptionService {

    List<CourseInscription> findAll();

    Optional<CourseInscription> findById(Integer id);
    CourseInscription add(CourseInscription courseInscription);

    CourseInscription update(CourseInscription courseInscription);

    CourseInscription delete(Integer id);

}
