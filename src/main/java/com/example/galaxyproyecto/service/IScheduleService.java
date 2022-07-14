package com.example.galaxyproyecto.service;

import com.example.galaxyproyecto.model.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IScheduleService {

    List<Schedule> findAll();

    Optional<Schedule> findById(Integer id);

    Schedule add(Schedule schedule);

    Schedule update(Schedule schedule);

    Schedule delete(Integer id);


}
