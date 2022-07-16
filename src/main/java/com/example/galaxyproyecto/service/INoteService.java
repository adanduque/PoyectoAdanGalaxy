package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.Exam;
import com.example.galaxyproyecto.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface INoteService {

    List<Note> findAll();

    Optional<Note> findById(Integer id);

    Note add(Note exam);

    Note update(Note exam);

    Note delete(Integer id);

}
