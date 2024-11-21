package com.miguel.literalura.repository;

import com.miguel.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> buscarAutoresRegistradosEnUnPeriodo(int fechaInicial, int fechaFinal);
}
