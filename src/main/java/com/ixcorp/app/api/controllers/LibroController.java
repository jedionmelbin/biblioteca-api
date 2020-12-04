package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.config.ServiceResult;
import com.ixcorp.app.api.dto.LibroDTO;
import com.ixcorp.app.api.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroController {


    @Autowired
    private LibroService libroService;

    @GetMapping("/listaLibro")
    public ResponseEntity<ServiceResult> listarAutor() {

        try {

            ServiceResult result = new ServiceResult();
            List<LibroDTO> libroDTOS = libroService.ListLibro();

            result.setData(libroDTOS);

            return new ResponseEntity<>(result, HttpStatus.FOUND);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> createAutor(@RequestBody LibroDTO libro) {


        try {
            ServiceResult result = new ServiceResult();
            LibroDTO libroDTO = libroService.Create(libro);

            result.setData(libroDTO);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResult> updateAutor(@RequestBody LibroDTO libro) {


        try {
            ServiceResult result = new ServiceResult();
            LibroDTO saveAutor = libroService.Update(libro);

            result.setData(saveAutor);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }

    @PutMapping("/getById")
    public ResponseEntity<ServiceResult> getByAutorId(@PathVariable("id") Long id) {


        try {
            ServiceResult result = new ServiceResult();
            LibroDTO libroDTO = libroService.GetById(id);
            result.setData(libroDTO);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }
}
