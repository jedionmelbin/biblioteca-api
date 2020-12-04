package com.ixcorp.app.api.service.serviceImpl;

import com.ixcorp.app.api.config.ObjectMapperUtils;
import com.ixcorp.app.api.domain.Editorial;
import com.ixcorp.app.api.dto.EditorialDTO;
import com.ixcorp.app.api.repository.EditorialRepository;
import com.ixcorp.app.api.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public List<EditorialDTO> listarEditorial() {
        try {

            List<Editorial> editorials = editorialRepository.findAll();

            List<EditorialDTO> editorialDTOS = ObjectMapperUtils.mapAll(editorials, EditorialDTO.class);

            return editorialDTOS;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public EditorialDTO create(EditorialDTO editorialDTO) {
        return null;
    }

    @Override
    public EditorialDTO update(EditorialDTO editorialDTO) {
        return null;
    }

    @Override
    public EditorialDTO getById(Long id) {
        return null;
    }
}
