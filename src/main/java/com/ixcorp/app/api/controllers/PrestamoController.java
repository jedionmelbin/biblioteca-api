package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.config.ServiceResult;
import com.ixcorp.app.api.dto.PrestamoDTO;
import com.ixcorp.app.api.rabitmq.publisher.PrestamoPublisher;
import com.ixcorp.app.api.service.PrestamoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/prestamos")
public class PrestamoController {

    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);


    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private PrestamoPublisher prestamoPublisher;

    @PostMapping("/crearPrestamo")
    public ResponseEntity<ServiceResult> createPrestamo(@RequestBody PrestamoDTO prestamoDTO) {


        try {
            ServiceResult result = new ServiceResult();
            //PrestamoDTO returnPrestamo = prestamoService.createPrestamo(prestamoDTO);
            prestamoPublisher.generarPrestamo(prestamoDTO);

            result.setData(prestamoDTO);
            logger.trace("Final creaciond de prestamo");
            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }

    @PostMapping("/devolucion")
    public ResponseEntity<ServiceResult> devolucion(@RequestBody PrestamoDTO prestamoDTO) {

        try {
            ServiceResult result = new ServiceResult();
            //PrestamoDTO returnPrestamo = prestamoService.createPrestamo(prestamoDTO);
            prestamoPublisher.generarPrestamo(prestamoDTO);

            result.setData(prestamoDTO);
            logger.trace("Final creaciond de prestamo");
            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }

    @PostMapping("/reservas")
    public ResponseEntity<ServiceResult> reservas(@RequestBody PrestamoDTO prestamoDTO) {

        try {
            ServiceResult result = new ServiceResult();
            //PrestamoDTO returnPrestamo = prestamoService.createPrestamo(prestamoDTO);
            prestamoPublisher.generarPrestamo(prestamoDTO);

            result.setData(prestamoDTO);
            logger.trace("Final creaciond de prestamo");
            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }

    @GetMapping("/listarPrestamos")
    public ResponseEntity<ServiceResult> listarPrestamo() {

        try {

            ServiceResult result = new ServiceResult();
            Map<String, Object> parameters = new HashMap<>();

            List<PrestamoDTO> prestamoDTOS = prestamoService.listarPrestamo(parameters);

            result.setData(prestamoDTOS);

            return new ResponseEntity<>(result, HttpStatus.FOUND);

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }
}
