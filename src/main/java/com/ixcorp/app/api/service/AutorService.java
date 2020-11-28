package com.ixcorp.app.api.service;

import com.ixcorp.app.api.domain.Autor;
import com.ixcorp.app.api.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor create(Autor autor) {
        return autorRepository.save(autor);
    }
}
