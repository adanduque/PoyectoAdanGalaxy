package com.example.galaxyproyecto.controller;

import com.example.galaxyproyecto.model.CourseInscription;
import com.example.galaxyproyecto.model.modelassembler.CourseInscriptionModelAssembler;
import com.example.galaxyproyecto.service.ICourseInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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

    @Autowired
    CourseInscriptionModelAssembler courseInscriptionModelAssembler;
    @GetMapping("/find-all")
    public CollectionModel<EntityModel<CourseInscription>> findAll() {
        List<CourseInscription> courseInscriptions= courseInscriptionService.findAll();
        return courseInscriptionModelAssembler.toCollectionModel(courseInscriptions);
    }

    @GetMapping(path= "/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
    public  EntityModel<CourseInscription> findById(@PathVariable("id") Integer id) {
        CourseInscription courseInscription=courseInscriptionService.findById(id).orElse(null);
        return  courseInscriptionModelAssembler.toModel(courseInscription);
    }



    @GetMapping("/v2/by-nombre")
    public CourseInscription findByLikeNombrev2(@RequestParam(name="name",defaultValue="") String nombre) {
        return null;//productoService.findById(id).orElse(null);
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
