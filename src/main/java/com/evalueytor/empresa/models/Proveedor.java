package com.evalueytor.empresa.models;

import jakarta.persistence.Entity;

@Entity
public class Proveedor extends Empresa {

    private Integer calificacion;

    // Getters y Setters
    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}
