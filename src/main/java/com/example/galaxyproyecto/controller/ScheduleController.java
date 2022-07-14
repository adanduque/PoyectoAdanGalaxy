package com.example.galaxyproyecto.controller;

import com.example.galaxyproyecto.model.Schedule;
import com.example.galaxyproyecto.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/v1/schedules",
        produces= {MediaType.APPLICATION_JSON_VALUE}
        /*consumes={MediaType.APPLICATION_JSON_VALUE}*/)
public class ScheduleController {


    @Autowired
    private IScheduleService scheduleService;

    @GetMapping("/find-all")
    public List<Schedule> findAll() {
        return scheduleService.findAll();
    }

    @GetMapping(path= "/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
    public Schedule findById(@PathVariable("id") Integer id) {
        return scheduleService.findById(id).orElse(null);
    }


    @GetMapping("/v2/by-nombre")
    public Schedule findByLikeNombrev2(@RequestParam(name="name",defaultValue="") String nombre) {
        return null;//productoService.findById(id).orElse(null);
    }


    @PostMapping(/*path="/add", consumes={MediaType.APPLICATION_JSON_VALUE}*/)
    public Schedule add(@RequestBody Schedule schedule) {
        return scheduleService.add(schedule);
    }

    @PutMapping("/{id}")
    public Schedule update(@PathVariable("id") Integer id, @RequestBody Schedule schedule) {
        schedule.setIdSchedule(id);
        return scheduleService.update(schedule);
    }

    @DeleteMapping("/{id}")
    public Schedule delete(@PathVariable("id") Integer id) {
        return scheduleService.delete(id);
    }

}
