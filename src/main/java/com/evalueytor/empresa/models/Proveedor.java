package com.evalueytor.empresa.models;


import lombok.Data;
import jakarta.persistence.Entity;

@Entity
@Data
public class Proveedor extends Empresa {

    private Long calificacion;
}
