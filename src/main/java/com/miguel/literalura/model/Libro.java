package com.miguel.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    private Integer id;
    private String titulo;
    private List<Autores> autores;
    private List lenguajes;
    private Integer descargas;
}
