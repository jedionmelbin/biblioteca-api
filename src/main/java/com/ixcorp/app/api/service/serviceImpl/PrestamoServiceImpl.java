package com.ixcorp.app.api.service.serviceImpl;

import com.ixcorp.app.api.config.ObjectMapperUtils;
import com.ixcorp.app.api.domain.Cliente;
import com.ixcorp.app.api.domain.Libro;
import com.ixcorp.app.api.domain.Prestamo;
import com.ixcorp.app.api.dto.PrestamoDTO;
import com.ixcorp.app.api.repository.ClienteRepository;
import com.ixcorp.app.api.repository.LibroRepository;
import com.ixcorp.app.api.repository.PrestamoRepository;
import com.ixcorp.app.api.service.PrestamoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public PrestamoDTO createPrestamo(PrestamoDTO prestamoDTO) {

        try {

            Optional<Cliente> cliente = clienteRepository.
                    findById(prestamoDTO.getClientes().getClienteId());

            Optional<Libro> libros = libroRepository
                    .findById(prestamoDTO.getLibro().getLibroId());


            Prestamo prestamo = ObjectMapperUtils.map(prestamoDTO, Prestamo.class);
            prestamo.setCliente(cliente.get());
            prestamo.setLibro(libros.get());
            Prestamo prestamos = prestamoRepository.save(prestamo);

            return ObjectMapperUtils.map(prestamos, PrestamoDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public PrestamoDTO updatePrestamo(PrestamoDTO prestamoDTO) {
        try {

            Prestamo prestamo = ObjectMapperUtils.map(prestamoDTO, Prestamo.class);

            Prestamo prestamos = prestamoRepository.save(prestamo);

            return ObjectMapperUtils.map(prestamos, PrestamoDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<PrestamoDTO> listarPrestamo(Map<String, Object> parameters) {
        List<PrestamoDTO> prestamoDTOS = new ArrayList<>();

        try {

            List<Prestamo> prestamoList = prestamoRepository.findAll();

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

            for (Prestamo prestamo : prestamoList) {
                PrestamoDTO prestamoDTO = modelMapper.map(prestamo, PrestamoDTO.class);
                prestamoDTOS.add(prestamoDTO);
            }
            return prestamoDTOS;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
