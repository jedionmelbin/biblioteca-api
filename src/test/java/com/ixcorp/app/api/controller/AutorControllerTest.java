package com.ixcorp.app.api.controller;

import com.ixcorp.app.api.controllers.AutorController;
import com.ixcorp.app.api.dto.AutorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class AutorControllerTest {

    @Test
    void create() {
        AutorController controller = new AutorController();
        int id = 0;
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setNombres("Jose");
        autorDTO.setApellidos("Marquez");
        autorDTO.setNacionalidad("Colombia");
        autorDTO.setSexo("Masculino");
        autorDTO.setFechaNacimiento(Calendar.getInstance().getTime());
        controller.createAutor(autorDTO);

        Assertions.assertTrue(id > 0);
    }
}
