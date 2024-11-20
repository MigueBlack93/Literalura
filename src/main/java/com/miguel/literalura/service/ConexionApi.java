package com.miguel.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ConexionApi {
    private final String url = "https://gutendex.com/books?search=";

    public String conectarApi(String libro) {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        String fullUrl = url + libro.replace(" ", "%20");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .timeout(Duration.ofSeconds(10))
                .header("User-Agent", "Java HttpClient")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

//            System.out.println("Estado HTTP: " + response.statusCode());
//            System.out.println("Encabezados: " + response.headers().map());
//            System.out.println("Cuerpo: " + response.body());

            if (response.body() == null || response.body().isEmpty()) {
                throw new RuntimeException("El cuerpo de la respuesta está vacío");
            }

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con la API", e);
        }
    }
}