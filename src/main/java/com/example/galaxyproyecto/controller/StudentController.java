package com.example.galaxyproyecto.controller;

import com.example.galaxyproyecto.model.Student;
import com.example.galaxyproyecto.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path="/v1/students",
        produces= {MediaType.APPLICATION_JSON_VALUE}
        /*consumes={MediaType.APPLICATION_JSON_VALUE}*/)
public class StudentController {


    @Autowired
    private IStudentService studentService;
   // @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/find-all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping(path= "/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
    public Student findById(@PathVariable("id") Integer id) {
        return studentService.findById(id).orElse(null);
    }

    @GetMapping("/by-nombre")
    public List<Student> findByLikeName(@RequestParam(name="name",defaultValue="") String name) {
        return studentService.findByLikeName(Student.builder().name(name).build());
    }

    @GetMapping("/v2/by-nombre")
    public Student findByLikeNombrev2(@RequestParam(name="name",defaultValue="") String nombre) {
        return null;//
    }

    @GetMapping("/by-nombre/pagin")
    public Page<Student> findByLikeNombrePagin(
            @RequestParam(name="name",defaultValue="") String name,
            @RequestParam(name="pagina",defaultValue="1") Integer pagina,
            @RequestParam(name="tamanio",defaultValue="10") Integer tamanio) {

        Pageable pageable= PageRequest.of(pagina-1, tamanio);

        return studentService.findByLikeNamePaging(pageable, name);
    }

    @GetMapping("/by-nombre/pagin-order")
    public Page<Student> findByLikeNombrePaginOrden(

            @RequestParam(name="nombre",defaultValue="") String name,

            @RequestParam(name="pagina",defaultValue="1") Integer pagina,
            @RequestParam(name="tamanio",defaultValue="10") Integer tamanio,

            @RequestParam(name="campo",defaultValue="id") String campo,
            @RequestParam(name="orden",defaultValue="ASC") String orden

    ) {

        Pageable pageable=PageRequest.of(pagina-1, tamanio, Sort.by(Sort.Direction.valueOf(orden), campo));

        return studentService.findByLikeNamePaging(pageable, name);
    }


    @PostMapping(/*path="/add", consumes={MediaType.APPLICATION_JSON_VALUE}*/)
    public ResponseEntity<Student> add(@RequestBody Student student) {

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getIdStudent()).toUri();
        studentService.add(student);
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public Student update(@PathVariable("id") Integer id, @RequestBody Student student) {
        student.setIdStudent(id);
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable("id") Integer id) {
        return studentService.delete(id);
    }

}
