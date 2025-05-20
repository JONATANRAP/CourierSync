package com.FabricaEscuela.API_REST.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}