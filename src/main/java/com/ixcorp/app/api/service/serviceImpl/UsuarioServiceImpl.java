package com.ixcorp.app.api.service.serviceImpl;

import com.ixcorp.app.api.config.ObjectMapperUtils;
import com.ixcorp.app.api.domain.Usuario;
import com.ixcorp.app.api.dto.UsuarioDTO;
import com.ixcorp.app.api.repository.UsuarioRepository;
import com.ixcorp.app.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO createUser(UsuarioDTO usuarioDTO) {

        try {

            Usuario usuario = ObjectMapperUtils.map(usuarioDTO, Usuario.class);
            usuarioRepository.save(usuario);

            return usuarioDTO;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public UsuarioDTO getUserById(Long id) {

        try {

            Optional<Usuario> usuario = usuarioRepository.findById(id);
            return ObjectMapperUtils.map(usuario.get(), UsuarioDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public UsuarioDTO finByUserName(String userName) {
        try {

            Usuario usuario = usuarioRepository.findUsuarioByUserName(userName);
            return ObjectMapperUtils.map(usuario, UsuarioDTO.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
