package com.ixcorp.app.api.service.serviceImpl;

import com.ixcorp.app.api.config.ObjectMapperUtils;
import com.ixcorp.app.api.domain.Cliente;
import com.ixcorp.app.api.dto.ClienteDTO;
import com.ixcorp.app.api.repository.ClienteRepository;
import com.ixcorp.app.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarCliente() {

        try {

            List<Cliente> clientes = clienteRepository.findAll();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return null;
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteDTO) {
        try {

            Cliente entity = ObjectMapperUtils.map(clienteDTO, Cliente.class);

            Cliente cliente = clienteRepository.save(entity);

            return ObjectMapperUtils.map(cliente, ClienteDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        try {

            Cliente entity = ObjectMapperUtils.map(clienteDTO, Cliente.class);

            Cliente cliente = clienteRepository.save(entity);

            return ObjectMapperUtils.map(cliente, ClienteDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public ClienteDTO getById(Long id) {
        try {

            Optional<Cliente> cliente = clienteRepository.findById(id);

            return ObjectMapperUtils.map(cliente.get(), ClienteDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
