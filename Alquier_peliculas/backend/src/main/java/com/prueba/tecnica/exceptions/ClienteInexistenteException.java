package com.prueba.tecnica.exceptions;

public class ClienteInexistenteException extends RuntimeException{
    public ClienteInexistenteException(String message) {
        super(message);
    }
}
