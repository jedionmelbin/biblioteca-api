package com.ixcorp.app.api.dto;

import javax.persistence.Column;

public class EditorialDTO {

    private Long editorialId;
    private String descripcion;

    public Long getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Long editorialId) {
        this.editorialId = editorialId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
