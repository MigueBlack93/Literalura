package com.miguel.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autores {
    private Integer id;
    private String nombre;
    private Integer nacimiento;
    private Integer deceso;
}
