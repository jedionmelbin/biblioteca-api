package com.ixcorp.app.api.service;

import com.ixcorp.app.api.dto.PrestamoDTO;

import java.util.List;
import java.util.Map;

public interface PrestamoService {

    PrestamoDTO createPrestamo(PrestamoDTO prestamoDTO);
    PrestamoDTO updatePrestamo(PrestamoDTO prestamoDTO);
    List<PrestamoDTO> listarPrestamo(Map<String,Object> parameters);
}
