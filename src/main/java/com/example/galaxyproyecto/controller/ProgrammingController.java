package com.example.galaxyproyecto.controller;

import com.example.galaxyproyecto.model.Programming;
import com.example.galaxyproyecto.service.IProgrammingService;
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
@RequestMapping(path="/v1/programmings",
        produces= {MediaType.APPLICATION_JSON_VALUE}
        /*consumes={MediaType.APPLICATION_JSON_VALUE}*/)
public class ProgrammingController {


    @Autowired
    private IProgrammingService programmingService;

    @GetMapping("/find-all")
    public List<Programming> findAll() {
        return programmingService.findAll();
    }

    @GetMapping(path= "/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
    public Programming findById(@PathVariable("id") Integer id) {
        return programmingService.findById(id).orElse(null);
    }

    
    @PostMapping(/*path="/add", consumes={MediaType.APPLICATION_JSON_VALUE}*/)
    public Programming add(@RequestBody Programming programming) {
        return programmingService.add(programming);
    }

    @PutMapping("/{id}")
    public Programming update(@PathVariable("id") Integer id, @RequestBody Programming programming) {
        programming.setIdProgramming(id);
        return programmingService.update(programming);
    }

    @DeleteMapping("/{id}")
    public Programming delete(@PathVariable("id") Integer id) {
        return programmingService.delete(id);
    }

}
