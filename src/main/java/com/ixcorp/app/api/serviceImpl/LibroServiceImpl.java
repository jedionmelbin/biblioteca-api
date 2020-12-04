package com.ixcorp.app.api.serviceImpl;

import com.ixcorp.app.api.domain.Libro;
import com.ixcorp.app.api.dto.LibroDTO;
import com.ixcorp.app.api.repository.LibroRepository;
import com.ixcorp.app.api.service.LibroService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;


    @Override
    public List<LibroDTO> ListLibro() {

        try {

            List<Libro> libros = libroRepository.findAll();

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            List<LibroDTO> operacionDTOList = new ArrayList<>();
            for (Libro libro : libros) {
                LibroDTO libroDTO = modelMapper.map(libro, LibroDTO.class);
                operacionDTOList.add(libroDTO);
            }
            return operacionDTOList;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public LibroDTO Create(LibroDTO libroDTO) {
        return null;
    }

    @Override
    public LibroDTO Update(LibroDTO libroDTO) {
        return null;
    }

    @Override
    public LibroDTO GetById(Long id) {
        return null;
    }
}
