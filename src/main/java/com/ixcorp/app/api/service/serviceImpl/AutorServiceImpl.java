package com.ixcorp.app.api.service.serviceImpl;

import com.ixcorp.app.api.config.ObjectMapperUtils;
import com.ixcorp.app.api.domain.Autor;
import com.ixcorp.app.api.dto.AutorDTO;
import com.ixcorp.app.api.repository.AutorRepository;
import com.ixcorp.app.api.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorDTO> ListAutor() {

        try {
            List<Autor> autors = autorRepository.findAll();

            List<AutorDTO> autorDTOS = ObjectMapperUtils.mapAll(autors, AutorDTO.class);

            return autorDTOS;


        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public AutorDTO Create(AutorDTO autorDTO) {
        try {

            Autor autor = ObjectMapperUtils.map(autorDTO, Autor.class);
            Autor autorEntity = autorRepository.save(autor);

            return ObjectMapperUtils.map(autorEntity, AutorDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public AutorDTO Update(AutorDTO autorDTO) {
        try {

            Autor autor = ObjectMapperUtils.map(autorDTO, Autor.class);
            Autor autorEntity = autorRepository.save(autor);

            return ObjectMapperUtils.map(autorEntity, AutorDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public AutorDTO GetById(Long id) {
        try {


            Optional<Autor> autorEntity = autorRepository.findById(id);
            return ObjectMapperUtils.map(autorEntity.get(), AutorDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
