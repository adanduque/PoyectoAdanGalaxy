package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    List<Course> findAll();

    List<Course> findByLikeName(Course course);

    Optional<Course> findById(Integer id);

    Course add(Course course);

    Course update(Course course);

    Course delete(Integer id);

    Page<Course> findByLikeNamePaging(Pageable pageable, String name);

}
