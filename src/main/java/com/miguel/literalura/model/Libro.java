package com.miguel.literalura.model;

import com.miguel.literalura.repository.LibroRepository;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private List<String> lenguajes;
    private Integer descargas;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Autor> autores;
    private LibroRepository repository;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.lenguajes = datosLibro.lenguajes();
        this.descargas = datosLibro.descargas();

        if (datosLibro.autores() != null) {
            this.autores = datosLibro.autores().stream()
                    .map(autor -> new Autor(autor)) // Suponiendo que Autor tiene un constructor que recibe DatosAutores
                    .collect(Collectors.toList());
            repository.saveAll(autores);
        }

   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        autores.forEach(a -> a.setLibro(this));
        this.autores = autores;
    }
}
