package com.example.galaxyproyecto.model.modelassembler;

import com.example.galaxyproyecto.controller.CourseController;
import com.example.galaxyproyecto.controller.TeacherController;
import com.example.galaxyproyecto.model.Course;
import com.example.galaxyproyecto.model.Teacher;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Service
public class CourseModelAssembler implements RepresentationModelAssembler<Course, EntityModel<Course>> {


    @Override
    public EntityModel<Course> toModel(Course course) {
        return EntityModel.of(
                course,
                linkTo(methodOn(CourseController.class).findById(course.getIdCourse())).withSelfRel(),
                linkTo(methodOn(CourseController.class).findAll()).withRel("courses"),
                linkTo(methodOn(CourseController.class).delete(course.getIdCourse())).withRel("delete"));
    }

    @Override
    public CollectionModel<EntityModel<Course>> toCollectionModel(Iterable<? extends Course> courses) {
        //return RepresentationModelAssembler.super.toCollectionModel(courses);
        CollectionModel<EntityModel<Course>> model = RepresentationModelAssembler.super.toCollectionModel(courses);
        model.add(linkTo(methodOn(CourseController.class).findAll()).withSelfRel());
        model.add(Link.of(linkTo(CourseController.class).toUriComponentsBuilder().build().toUriString()).withRel("add"));
        return model;
    }
}
