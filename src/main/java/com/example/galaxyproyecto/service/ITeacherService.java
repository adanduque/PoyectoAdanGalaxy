package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {

    List<Teacher> findAll();

    List<Teacher> findByLikeName(Teacher teacher);

    Optional<Teacher> findById(Integer id);

    Teacher add(Teacher teacher);

    Teacher update(Teacher teacher);

    Teacher delete(Integer id);

    Page<Teacher> findByLikeNamePaging(Pageable pageable, String name);

}
