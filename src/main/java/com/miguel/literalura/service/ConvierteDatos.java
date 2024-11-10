package com.miguel.literalura.service;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        return null;
    }
}
