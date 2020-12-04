package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.config.ServiceResult;
import com.ixcorp.app.api.dto.EditorialDTO;
import com.ixcorp.app.api.service.EditorialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/editorial")
public class EditorialController {
    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);

    @Autowired
    private EditorialService editorialService;


    @GetMapping("/listaEditorial")
    public ResponseEntity<ServiceResult> listarEditorial() {

        try {

            ServiceResult result = new ServiceResult();
            List<EditorialDTO> editorialDTOS = editorialService.listarEditorial();

            result.setData(editorialDTOS);

            return new ResponseEntity<>(result, HttpStatus.FOUND);

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }
}
