package com.miguel.literalura.repository;

import com.miguel.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    List<Libro> buscarLibroPorIdioma(String idioma);
}
