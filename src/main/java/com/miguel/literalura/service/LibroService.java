package com.miguel.literalura.service;

import com.miguel.literalura.model.Autor;
import com.miguel.literalura.model.DatosLibro;
import com.miguel.literalura.model.Libro;
import com.miguel.literalura.repository.AutorRepository;
import com.miguel.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;

    public LibroService(){}

    public void guardarLibro(DatosLibro datosLibro) {
        Libro libro = new Libro(datosLibro);
        libro.setLenguajes(datosLibro.lenguajes());

        if (datosLibro.autores() != null) {
            List<Autor> autores = datosLibro.autores().stream()
                    .map(autor -> new Autor(autor))
                    .collect(Collectors.toList());
            autores.forEach(autor -> autor.setLibro(libro));
            libro.setAutores(autores);
            libroRepository.save(libro);
            autorRepository.saveAll(autores);
        }
    }
}
