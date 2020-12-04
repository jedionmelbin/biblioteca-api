package com.ixcorp.app.api.service;

import com.ixcorp.app.api.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO createUser(UsuarioDTO usuarioDTO);
    UsuarioDTO getUserById(Long id);
    UsuarioDTO finByUserName(String userName);

}
