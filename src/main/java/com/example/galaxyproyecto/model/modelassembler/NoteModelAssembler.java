package com.example.galaxyproyecto.model.modelassembler;

import com.example.galaxyproyecto.controller.NoteController;
import com.example.galaxyproyecto.model.Note;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class NoteModelAssembler implements RepresentationModelAssembler<Note, EntityModel<Note>>{
    @Override
    public EntityModel<Note> toModel(Note note) {
        return EntityModel.of(
                note,
                linkTo(methodOn(NoteController.class).findById(note.getIdNote())).withSelfRel(),
                linkTo(methodOn(NoteController.class).findAll()).withRel("notes"),
                linkTo(methodOn(NoteController.class).delete(note.getIdNote())).withRel("delete"));
    }

    @Override
    public CollectionModel<EntityModel<Note>> toCollectionModel(Iterable<? extends Note> notes) {
        //return RepresentationModelAssembler.super.toCollectionModel(notes);
        CollectionModel<EntityModel<Note>> model = RepresentationModelAssembler.super.toCollectionModel(notes);
        model.add(linkTo(methodOn(NoteController.class).findAll()).withSelfRel());
        model.add(Link.of(linkTo(NoteController.class).toUriComponentsBuilder().build().toUriString()).withRel("add"));
        return model;
    }
}
