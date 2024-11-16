package com.miguel.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private List lenguajes;
    private Integer descargas;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DatosAutores> autores;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.lenguajes = datosLibro.lenguajes();
        this.descargas = datosLibro.descargas();
        this.autores = datosLibro.autores();
    }
}
