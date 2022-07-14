package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {

        @Query("select p from Schedule p where p.state=1")	//JPQL
        List<Schedule> findAllCustom();


}
