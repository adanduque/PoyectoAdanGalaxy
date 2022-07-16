package com.example.galaxyproyecto.model.modelassembler;

import com.example.galaxyproyecto.controller.ProgrammingController;
import com.example.galaxyproyecto.model.Programming;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProgrammingModelAssembler implements RepresentationModelAssembler<Programming, EntityModel<Programming>> {
@Override
public EntityModel<Programming> toModel(Programming programming) {
        return EntityModel.of(
        programming,
        linkTo(methodOn(ProgrammingController.class).findById(programming.getIdProgramming())).withSelfRel(),
        linkTo(methodOn(ProgrammingController.class).findAll()).withRel("programmings"),
        linkTo(methodOn(ProgrammingController.class).delete(programming.getIdProgramming())).withRel("delete"));
        }

@Override
public CollectionModel<EntityModel<Programming>> toCollectionModel(Iterable<? extends Programming> programmings) {
        //return RepresentationModelAssembler.super.toCollectionModel(programmings);
        CollectionModel<EntityModel<Programming>> model = RepresentationModelAssembler.super.toCollectionModel(programmings);
        model.add(linkTo(methodOn(ProgrammingController.class).findAll()).withSelfRel());
        model.add(Link.of(linkTo(ProgrammingController.class).toUriComponentsBuilder().build().toUriString()).withRel("add"));
        return model;
        }
        }
