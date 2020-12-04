package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.config.ServiceResult;

import com.ixcorp.app.api.dto.AutorDTO;
import com.ixcorp.app.api.service.AutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autores")
@CrossOrigin(origins = "*")
public class AutorController {

    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);


    @Autowired
    private AutorService autorService;

    @GetMapping("/listaAutor")
    public ResponseEntity<ServiceResult> listarAutor() {

        try {

            ServiceResult result = new ServiceResult();
            List<AutorDTO> autorDTOS = autorService.ListAutor();

            result.setData(autorDTOS);

            return new ResponseEntity<>(result, HttpStatus.FOUND);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> createAutor(@RequestBody AutorDTO autor) {


        try {
            ServiceResult result = new ServiceResult();
            AutorDTO saveAutor = autorService.Create(autor);

            result.setData(saveAutor);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResult> updateAutor(@RequestBody AutorDTO autor) {


        try {
            ServiceResult result = new ServiceResult();
            AutorDTO saveAutor = autorService.Update(autor);

            result.setData(saveAutor);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
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
