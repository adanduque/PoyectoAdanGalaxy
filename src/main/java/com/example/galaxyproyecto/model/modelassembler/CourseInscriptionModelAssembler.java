package com.example.galaxyproyecto.model.modelassembler;

import com.example.galaxyproyecto.controller.CourseInscriptionController;
import com.example.galaxyproyecto.model.CourseInscription;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CourseInscriptionModelAssembler implements RepresentationModelAssembler<CourseInscription, EntityModel<CourseInscription>> {


    @Override
    public EntityModel<CourseInscription> toModel(CourseInscription course) {
        return EntityModel.of(
                course,
                linkTo(methodOn(CourseInscriptionController.class).findById(course.getIdCourseInscription())).withSelfRel(),
                linkTo(methodOn(CourseInscriptionController.class).findAll()).withRel("courses"),
                linkTo(methodOn(CourseInscriptionController.class).delete(course.getIdCourseInscription())).withRel("delete"));
    }

    @Override
    public CollectionModel<EntityModel<CourseInscription>> toCollectionModel(Iterable<? extends CourseInscription> courses) {
        //return RepresentationModelAssembler.super.toCollectionModel(courses);
        CollectionModel<EntityModel<CourseInscription>> model = RepresentationModelAssembler.super.toCollectionModel(courses);
        model.add(linkTo(methodOn(CourseInscriptionController.class).findAll()).withSelfRel());
        model.add(Link.of(linkTo(CourseInscriptionController.class).toUriComponentsBuilder().build().toUriString()).withRel("add"));
        return model;
    }
}



