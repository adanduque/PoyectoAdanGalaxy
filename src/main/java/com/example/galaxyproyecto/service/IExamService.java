package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.Course;
import com.example.galaxyproyecto.model.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IExamService {

    List<Exam> findAll();

    List<Exam> findByLikeName(Exam exam);

    Optional<Exam> findById(Integer id);

    Exam add(Exam exam);

    Exam update(Exam exam);

    Exam delete(Integer id);

    Page<Exam> findByLikeNamePaging(Pageable pageable, String name);
}
