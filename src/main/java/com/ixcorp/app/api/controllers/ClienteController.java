package com.ixcorp.app.api.controllers;

import com.ixcorp.app.api.config.ServiceResult;
import com.ixcorp.app.api.dto.ClienteDTO;
import com.ixcorp.app.api.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/clientes")
public class ClienteController {
    private static final Logger logger = LoggerFactory.getLogger(PrestamoController.class);


    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listaCliente")
    public List<ClienteDTO> listarAutor() {

        try {

            ServiceResult result = new ServiceResult();
            List<ClienteDTO> clienteDTOS = clienteService.listarCliente();
            return clienteDTOS;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> createCliente(@RequestBody ClienteDTO clienteDTO) {


        try {
            ServiceResult result = new ServiceResult();
            ClienteDTO clientes = clienteService.create(clienteDTO);

            result.setData(clientes);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResult> updateAutor(@RequestBody ClienteDTO cliente) {


        try {
            ServiceResult result = new ServiceResult();
            ClienteDTO clientes = clienteService.update(cliente);

            result.setData(clientes);

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
            ClienteDTO clienteDTO = clienteService.getById(id);
            result.setData(clienteDTO);

            return new ResponseEntity<>(result, HttpStatus.FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();

            throw ex;
        }

    }
}
