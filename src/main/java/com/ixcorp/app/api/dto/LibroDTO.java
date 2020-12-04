package com.ixcorp.app.api.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LibroDTO {

    private Long libroId;

    private String nombre;


    private String genero;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaEmision;

    private AutorDTO autors;

    private EditorialDTO editorials;


    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public AutorDTO getAutors() {
        return autors;
    }

    public void setAutors(AutorDTO autors) {
        this.autors = autors;
    }

    public EditorialDTO getEditorials() {
        return editorials;
    }

    public void setEditorials(EditorialDTO editorials) {
        this.editorials = editorials;
    }
}
