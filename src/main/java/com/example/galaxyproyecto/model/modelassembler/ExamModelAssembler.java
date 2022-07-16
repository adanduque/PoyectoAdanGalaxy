package com.example.galaxyproyecto.model.modelassembler;

import com.example.galaxyproyecto.controller.ExamController;
import com.example.galaxyproyecto.model.Exam;
import com.example.galaxyproyecto.model.Exam;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ExamModelAssembler implements RepresentationModelAssembler<Exam, EntityModel<Exam>> {
@Override
public EntityModel<Exam> toModel(Exam exam) {
        return EntityModel.of(
        exam,
        linkTo(methodOn(ExamController.class).findById(exam.getIdExam())).withSelfRel(),
        linkTo(methodOn(ExamController.class).findAll()).withRel("exams"),
        linkTo(methodOn(ExamController.class).delete(exam.getIdExam())).withRel("delete"));
        }

@Override
public CollectionModel<EntityModel<Exam>> toCollectionModel(Iterable<? extends Exam> exams) {
        //return RepresentationModelAssembler.super.toCollectionModel(exams);
        CollectionModel<EntityModel<Exam>> model = RepresentationModelAssembler.super.toCollectionModel(exams);
        model.add(linkTo(methodOn(ExamController.class).findAll()).withSelfRel());
        model.add(Link.of(linkTo(ExamController.class).toUriComponentsBuilder().build().toUriString()).withRel("add"));
        return model;
        }
        }
