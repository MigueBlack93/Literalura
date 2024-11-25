package com.miguel.literalura.repository;

import com.miguel.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
    //List<Libro> buscarLibroPorIdioma(String idioma);
}
