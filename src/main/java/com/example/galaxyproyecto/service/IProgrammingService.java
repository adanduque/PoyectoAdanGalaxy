package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.Programming;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProgrammingService {

    List<Programming> findAll();
    
    Optional<Programming> findById(Integer id);

    Programming add(Programming programming);

    Programming update(Programming programming);

    Programming delete(Integer id);
    
}
