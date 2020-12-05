package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.config.ServiceResult;

import com.ixcorp.app.api.domain.Autor;
import com.ixcorp.app.api.dto.AutorDTO;
import com.ixcorp.app.api.service.AutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/autores")
@CrossOrigin(origins = "*")
public class AutorController {

    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);


    @Autowired
    private AutorService autorService;

    @GetMapping("/listaAutor")
    public List<AutorDTO> listarAutor() {

        try {

            ServiceResult result = new ServiceResult();
            List<AutorDTO> autorDTOS = autorService.ListAutor();
            return  autorDTOS;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }


    @PostMapping("/create")
    public ResponseEntity<Object> createAutor(@RequestBody AutorDTO autor) {
        AutorDTO saveAutor = autorService.Create(autor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveAutor.getAutorId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/update")
    public ResponseEntity<AutorDTO> updateAutor(@RequestBody AutorDTO autor) {


        try {
            ServiceResult result = new ServiceResult();
            AutorDTO saveAutor = autorService.Update(autor);

            result.setData(saveAutor);

            return new ResponseEntity<>(saveAutor, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }

    @GetMapping("/getById")
    public ResponseEntity<ServiceResult> getByAutorId(@PathVariable("id") Long id) {


        try {
            ServiceResult result = new ServiceResult();
            AutorDTO saveAutor = autorService.GetById(id);
            result.setData(saveAutor);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }
}
