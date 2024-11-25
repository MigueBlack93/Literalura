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

    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public Libro guardarLibro(DatosLibro datosLibro) {
        Libro libro = new Libro(datosLibro);

        if (datosLibro.autores() != null) {
            List<Autor> autores = datosLibro.autores().stream()
                    .map(autor -> new Autor(autor))
                    .collect(Collectors.toList());
            autores.forEach(autor -> autor.setLibro(libro));
            libro.setAutores(autores);
            autorRepository.saveAll(autores);
        }

        return libroRepository.save(libro);
    }
}
