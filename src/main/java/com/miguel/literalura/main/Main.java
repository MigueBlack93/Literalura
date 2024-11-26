package com.miguel.literalura.main;

import com.miguel.literalura.model.Autor;
import com.miguel.literalura.model.DatosResultados;
import com.miguel.literalura.model.Libro;
import com.miguel.literalura.repository.AutorRepository;
import com.miguel.literalura.repository.LibroRepository;
import com.miguel.literalura.service.ConexionApi;
import com.miguel.literalura.service.ConvierteDatos;
import com.miguel.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Main {
    private Scanner teclado = new Scanner(System.in);
    private ConexionApi conexionApi = new ConexionApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private LibroRepository repository;
    private AutorRepository autorRepository;
    private List<Libro> libros;
    private List<Autor> autores;
    private Integer fechaInicial;
    private Integer fechaFinal;
    private List<Autor> autoresPorFecha;
    private List<Libro> librosPorIdioma;
    private LibroService libroService;

    @Autowired
    public Main(LibroRepository repository, AutorRepository autorRepository, LibroService libroService){
        this.repository = repository;
        this.autorRepository = autorRepository;
        this.libroService = libroService;
    }

    public void menu(){
        boolean salir = false;
        int opcion;
        Scanner teclado = new Scanner(System.in);

        while (!salir){
            System.out.println("""
                    1 - Buscar Libro por nombre o por autor.
                    2 - Mostrar libros registrados.
                    3 - Mostrar autores registrados.
                    4 - Mostrar autores vivos en un período determinado.
                    5 - Mostar libros por idioma.
                    
                    0 - SALIR.
                    """);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    mostrarAutoresRegistradosPorPeriodo();
                    break;
                case 5:
                    mostrarLibrosPorIdioma();
                    break;
                case 0:
                    salir = true;
                    System.out.println("""
                            Muchas gracias por utilizar nuestro programa.
                            ¡Hasta pronto!""");
                    break;
                default:
                    System.out.println("""
                            ¡Opción errónea!
                            Por favor elija una opción del 1 al 5, o 0 para salir.""");
            }
        }
    }

    private void buscarLibro() {
        System.out.println("Ingresa el nombre del libro o el autor que quieres buscar:");
        String nombreABuscar = teclado.nextLine();
        String json = conexionApi.conectarApi(nombreABuscar);
        DatosResultados datosResultados = convierteDatos.obtenerDatos(json, DatosResultados.class);
        System.out.println(datosResultados);
        datosResultados.libros().forEach(datosLibro -> libroService.guardarLibro(datosLibro));
    }

    private void mostrarLibrosRegistrados() {
        libros = repository.findAll();

        libros.forEach(l -> System.out.println(l.toString()));
    }

    private void mostrarAutoresRegistrados() {
        autores = autorRepository.findAll();

        autores.forEach(a -> System.out.println(a.toString()));
    }

    private void mostrarAutoresRegistradosPorPeriodo() {
        System.out.println("Ingresa el año inicial del período:");
        fechaInicial = teclado.nextInt();
        System.out.println("Ingresa el año final del período:");
        fechaFinal = teclado.nextInt();

//        autoresPorFecha = autorRepository.buscarAutoresRegistradosEnUnPeriodo(fechaInicial, fechaFinal);
//
//        if (!autoresPorFecha.isEmpty()){
//            autoresPorFecha.forEach(autor -> System.out.println(autor.toString()));
//        }else {
//            System.out.println("¡No se ha encontrado ningún autor registrado dentro de esas fechas!");
//        }
    }

    private void mostrarLibrosPorIdioma() {
        System.out.println("Ingresa el nombre del libro o el autor que quieres buscar:");
        String idiomaABuscar = teclado.nextLine();
//        librosPorIdioma = repository.buscarLibroPorIdioma(idiomaABuscar);
//
//        if (!librosPorIdioma.isEmpty()){
//            librosPorIdioma.forEach(autor -> System.out.println(autor.toString()));
//        }else {
//            System.out.println("¡No se ha encontrado ningún autor registrado dentro de esas fechas!");
//        }
    }
}
