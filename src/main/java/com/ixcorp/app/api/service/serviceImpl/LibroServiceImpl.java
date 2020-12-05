package com.ixcorp.app.api.service.serviceImpl;

import com.ixcorp.app.api.config.ObjectMapperUtils;
import com.ixcorp.app.api.domain.Autor;
import com.ixcorp.app.api.domain.Editorial;
import com.ixcorp.app.api.domain.Libro;
import com.ixcorp.app.api.dto.LibroDTO;
import com.ixcorp.app.api.repository.AutorRepository;
import com.ixcorp.app.api.repository.EditorialRepository;
import com.ixcorp.app.api.repository.LibroRepository;
import com.ixcorp.app.api.service.LibroService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;


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
        try {

            Optional<Autor> autor = autorRepository
                    .findById(libroDTO.getAutors().getAutorId());

            Optional<Editorial> editorial = editorialRepository
                    .findById(libroDTO.getEditorials().getEditorialId());

            Libro entity = ObjectMapperUtils.map(libroDTO, Libro.class);

            entity.setAutor(autor.get());
            entity.setEditorial(editorial.get());
            Libro libro = libroRepository.save(entity);

            return ObjectMapperUtils.map(libro, LibroDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public LibroDTO Update(LibroDTO libroDTO) {

        try {
            Libro entity = ObjectMapperUtils.map(libroDTO, Libro.class);

            Libro libro = libroRepository.save(entity);

            return ObjectMapperUtils.map(libro, LibroDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public LibroDTO GetById(Long id) {

        try {

            Optional<Libro> autorEntity = libroRepository.findById(id);
            return ObjectMapperUtils.map(autorEntity.get(), LibroDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
