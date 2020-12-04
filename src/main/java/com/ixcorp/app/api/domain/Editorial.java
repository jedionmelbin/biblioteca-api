package com.ixcorp.app.api.domain;

import javax.persistence.*;

@Entity
@Table(name = "editorial")
public class Editorial {

    @Id
    @Column(name =  "editorial_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long editorialId;

    @Column(name =  "nombre")
    private String nombres;

    public Long getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Long editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
