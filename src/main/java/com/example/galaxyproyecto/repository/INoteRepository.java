package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.Course;
import com.example.galaxyproyecto.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INoteRepository extends JpaRepository<Note, Integer> {

    @Query("select p from Note p where p.state=1")	//JPQL
    List<Note> findAllCustom();

}
