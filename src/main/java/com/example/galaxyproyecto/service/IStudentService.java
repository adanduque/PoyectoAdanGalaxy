package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.Student;
import com.example.galaxyproyecto.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> findAll();

    List<Student> findByLikeName(Student student);

    Optional<Student> findById(Integer id);

    Student add(Student teacher);

    Student update(Student student);

    Student delete(Integer id);

    Page<Student> findByLikeNamePaging(Pageable pageable, String name);
}
