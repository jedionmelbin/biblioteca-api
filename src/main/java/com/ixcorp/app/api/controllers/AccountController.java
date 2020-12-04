package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.config.ServiceResult;
import com.ixcorp.app.api.dto.UsuarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);


    @PostMapping("/login")
    public ResponseEntity<ServiceResult> Login(@RequestBody UsuarioDTO usuario) {


        try {
            ServiceResult result = new ServiceResult();


            return new ResponseEntity<>(result, HttpStatus.FOUND);

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }

    @PostMapping("/auth/create")
    public ResponseEntity<ServiceResult> Create(@RequestBody UsuarioDTO usuario) {


        try {
            ServiceResult result = new ServiceResult();


            return new ResponseEntity<>(result, HttpStatus.FOUND);

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
            throw ex;
        }

    }
}
