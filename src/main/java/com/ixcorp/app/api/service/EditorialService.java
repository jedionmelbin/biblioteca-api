package com.ixcorp.app.api.service;

import com.ixcorp.app.api.dto.EditorialDTO;

import java.util.List;

public interface EditorialService {

    List<EditorialDTO> listarEditorial();
    EditorialDTO create(EditorialDTO editorialDTO);
    EditorialDTO update(EditorialDTO editorialDTO);
    EditorialDTO getById(Long id);
}
