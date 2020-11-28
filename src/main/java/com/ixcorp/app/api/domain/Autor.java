package com.ixcorp.app.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private long autorId;

    @Column(name = "nombres")
    private String nombres;

    @Column(name =  "apellidos")
    private String apellidos;

    @Column(name =  "nacionalidad")
    private String nacionalidad;

    @Column(name = "genero")
    private String genero;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name =  "fecha_nacim")
    private Date fechaNacimiento;


    public Autor() {
    }

    public long getAutorId() {
        return autorId;
    }

    public void setAutorId(long autorId) {
        this.autorId = autorId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


}
