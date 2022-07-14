package com.example.galaxyproyecto.model.modelassembler;

import com.example.galaxyproyecto.controller.TeacherController;
import com.example.galaxyproyecto.model.Teacher;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class TeacherModelAssembler implements RepresentationModelAssembler<Teacher, EntityModel<Teacher>> {

    @Override
    public EntityModel<Teacher> toModel(Teacher teacher) {
        return EntityModel.of(
                teacher,
                linkTo(methodOn(TeacherController.class).findById(teacher.getIdTeacher())).withSelfRel(),
                linkTo(methodOn(TeacherController.class).findAll()).withRel("teachers"),
                linkTo(methodOn(TeacherController.class).delete(teacher.getIdTeacher())).withRel("delete"));
    }

    @Override
    public CollectionModel<EntityModel<Teacher>> toCollectionModel(Iterable<? extends Teacher> teachers) {
        //return RepresentationModelAssembler.super.toCollectionModel(entities);
        CollectionModel<EntityModel<Teacher>> model = RepresentationModelAssembler.super.toCollectionModel(teachers);
        model.add(linkTo(methodOn(TeacherController.class).findAll()).withSelfRel());
        model.add(Link.of(linkTo(TeacherController.class).toUriComponentsBuilder().build().toUriString()).withRel("add"));
        return model;
    }
}
