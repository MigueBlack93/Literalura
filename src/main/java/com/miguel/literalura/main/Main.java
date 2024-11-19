package com.miguel.literalura.main;

import com.miguel.literalura.model.Autor;
import com.miguel.literalura.model.DatosResultados;
import com.miguel.literalura.model.Libro;
import com.miguel.literalura.repository.LibroRepository;
import com.miguel.literalura.service.ConexionApi;
import com.miguel.literalura.service.ConvierteDatos;

import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner teclado = new Scanner(System.in);
    private ConexionApi conexionApi = new ConexionApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Libro libro = new Libro();
    private Autor autor = new Autor();
    private LibroRepository repository;
    private List<Libro> libros;
    private List<Autor> autores;

    public Main(LibroRepository repository){
        this.repository = repository;
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
        var nombreABuscar = teclado.nextLine();
        var json = conexionApi.conectarApi(nombreABuscar);
        DatosResultados datosResultados = convierteDatos.obtenerDatos(json, DatosResultados.class);
        System.out.println(datosResultados);
    }

    private void mostrarLibrosRegistrados() {
        libros = repository.findAll();

        libros.forEach(l -> System.out.println(l.toString()));
    }

    private void mostrarAutoresRegistrados() {

    }

    private void mostrarAutoresRegistradosPorPeriodo() {
    }

    private void mostrarLibrosPorIdioma() {
    }
}
