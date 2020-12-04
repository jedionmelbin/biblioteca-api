package com.ixcorp.app.api.service;

import com.ixcorp.app.api.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarCliente();
    ClienteDTO create(ClienteDTO clienteDTO);
    ClienteDTO update(ClienteDTO clienteDTO);
    ClienteDTO getById(Long id);
}
