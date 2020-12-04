package com.ixcorp.app.api.service;


import com.ixcorp.app.api.dto.LibroDTO;

import java.util.List;

public interface LibroService {
    List<LibroDTO> ListLibro();
    LibroDTO Create(LibroDTO libroDTO);
    LibroDTO Update(LibroDTO libroDTO);
    LibroDTO GetById(Long id);
}
