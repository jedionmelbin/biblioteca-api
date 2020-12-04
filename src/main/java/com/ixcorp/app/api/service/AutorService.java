package com.ixcorp.app.api.service;

import com.ixcorp.app.api.dto.AutorDTO;

import java.util.List;


public interface AutorService {
    List<AutorDTO> ListAutor();
    AutorDTO Create(AutorDTO autorDTO);
    AutorDTO Update(AutorDTO autorDTO);
    AutorDTO GetById(Long id);
}
