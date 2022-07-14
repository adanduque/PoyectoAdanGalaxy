package com.example.galaxyproyecto.controller;

import com.example.galaxyproyecto.model.CourseInscription;
import com.example.galaxyproyecto.service.ICourseInscriptionService;
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
@RequestMapping(path="/v1/courseInscriptions",
        produces= {MediaType.APPLICATION_JSON_VALUE}
        /*consumes={MediaType.APPLICATION_JSON_VALUE}*/)
public class CourseInscriptionController {


    @Autowired
    private ICourseInscriptionService courseInscriptionService;

    @GetMapping("/find-all")
    public List<CourseInscription> findAll() {
        return courseInscriptionService.findAll();
    }

    @GetMapping(path= "/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
    public CourseInscription findById(@PathVariable("id") Integer id) {
        return courseInscriptionService.findById(id).orElse(null);
    }


    @PostMapping(/*path="/add", consumes={MediaType.APPLICATION_JSON_VALUE}*/)
    public CourseInscription add(@RequestBody CourseInscription courseInscription) {
        return courseInscriptionService.add(courseInscription);
    }

    @PutMapping("/{id}")
    public CourseInscription update(@PathVariable("id") Integer id, @RequestBody CourseInscription courseInscription) {
        courseInscription.setIdCourseInscription(id);
        return courseInscriptionService.update(courseInscription);
    }

    @DeleteMapping("/{id}")
    public CourseInscription delete(@PathVariable("id") Integer id) {
        return courseInscriptionService.delete(id);
    }

}
