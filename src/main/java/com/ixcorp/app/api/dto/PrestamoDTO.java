package com.ixcorp.app.api.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PrestamoDTO {

    private  String prestamoGuiId;

    private  Long prestamoId;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaEmision;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaFinal;

    private LibroDTO libro;

    private ClienteDTO clientes;


    public PrestamoDTO() {
    }

    public Long getPrestamoId() {
        return prestamoId;
    }

    public String getPrestamoGuiId() {
        return prestamoGuiId;
    }

    public void setPrestamoGuiId(String prestamoGuiId) {
        this.prestamoGuiId = prestamoGuiId;
    }

    public void setPrestamoId(Long prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public LibroDTO getLibro() {
        return libro;
    }

    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }

    public ClienteDTO getClientes() {
        return clientes;
    }

    public void setClientes(ClienteDTO clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "PrestamoDTO{" +
                "prestamoGuiId='" + prestamoGuiId + '\'' +
                ", prestamoId=" + prestamoId +
                ", fechaEmision=" + fechaEmision +
                ", fechaFinal=" + fechaFinal +
                ", libro=" + libro +
                ", clientes=" + clientes +
                '}';
    }
}
