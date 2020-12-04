package com.ixcorp.app.api.dto;


import java.util.Date;

public class LibroDTO {

    private Long libroId;

    private String nombre;


    private String genero;

    private Date fechaEmision;

    private AutorDTO autors;

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
}
