package com.example.galaxyproyecto.model.modelassembler;

import com.example.galaxyproyecto.controller.TeacherController;
import com.example.galaxyproyecto.model.Schedule;
import com.example.galaxyproyecto.model.Teacher;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ScheduleModelAssembler implements RepresentationModelAssembler<Schedule, EntityModel<Schedule>> {

    @Override
    public EntityModel<Schedule> toModel(Schedule entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(TeacherController.class).findById(entity.getIdSchedule())).withSelfRel(),
                linkTo(methodOn(TeacherController.class).findAll()).withRel("schedules"),
                linkTo(methodOn(TeacherController.class).delete(entity.getIdSchedule())).withRel("delete"));
    }

    @Override
    public CollectionModel<EntityModel<Schedule>> toCollectionModel(Iterable<? extends Schedule> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
