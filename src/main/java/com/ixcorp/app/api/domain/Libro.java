package com.ixcorp.app.api.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name =  "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long libroId;

    @Column(name =  "nombre")
    private String nombre;

    @Column(name = "genero")
    private  String genero;

    @Column(name =  "fecha_emision")
    private Date fechaEmision;


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


}
