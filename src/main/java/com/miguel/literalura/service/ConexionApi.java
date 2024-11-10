package com.miguel.literalura.service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    private final String url = "https://gutendex.com/books";

    public String conectarApi (String tipo){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().build();
        HttpResponse response =
    }
}
