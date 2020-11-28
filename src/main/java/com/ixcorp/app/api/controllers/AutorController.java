package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.domain.Autor;
import com.ixcorp.app.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/autor")
public class AutorController {


    @Autowired
    private AutorService  autorService;

    @GetMapping("/listaAutor")
    public List<Autor> retrieveAllAutor() {
        return autorService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createStudent(@RequestBody Autor autor) {
        Autor savedStudent = autorService.create(autor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getAutorId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
