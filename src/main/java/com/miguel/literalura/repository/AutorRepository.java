package com.miguel.literalura.repository;

import com.miguel.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    //List<Autor> buscarAutoresRegistradosEnUnPeriodo(Integer fechaInicial, Integer fechaFinal);
}
