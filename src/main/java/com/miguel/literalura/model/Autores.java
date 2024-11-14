package com.miguel.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer nacimiento;
    private Integer deceso;
    @ManyToOne
    private Libro libro;

    public Autores(){}

}
