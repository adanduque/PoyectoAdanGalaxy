package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.Note;
import com.example.galaxyproyecto.repository.INoteRepository;
import com.example.galaxyproyecto.service.INoteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl  implements INoteService {
    @Autowired
    private INoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAllCustom();
    }

    @Override
    public Note add(Note note) {

        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> findById(Integer id) {

        return noteRepository.findById(id);
    }

    @Override
    public Note update(Note note) {

        Optional<Note> optNote = noteRepository.findById(note.getIdNote());

        if (optNote.isPresent()) {
            Note retNote = optNote.get();
            BeanUtils.copyProperties(note, retNote);
            return noteRepository.save(retNote);
        }
        return null;
    }

    @Override
    public Note delete(Integer id) {
        Optional<Note> optNote = noteRepository.findById(id);

        if (optNote.isPresent()) {
            Note retNote = optNote.get();
            retNote.setState(0);
            return noteRepository.save(retNote);
        }
        return null;
    }


}
