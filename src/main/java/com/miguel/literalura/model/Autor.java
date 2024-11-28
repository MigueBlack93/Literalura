package com.miguel.literalura.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Objects;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nombre;

    private Integer nacimiento;

    private Integer deceso;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    public Autor() {}

    public Autor(DatosAutores datosAutores) {
        this.nombre = datosAutores.nombre();
        this.nacimiento = datosAutores.nacimiento();
        this.deceso = datosAutores.deceso();
    }

    public Autor(DatosAutores datosAutores, Libro libro) {
        this(datosAutores);
        this.libro = libro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getDeceso() {
        return deceso;
    }

    public void setDeceso(Integer deceso) {
        this.deceso = deceso;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", deceso=" + deceso +
                ", libro=" + libro +
                '}';
    }
}