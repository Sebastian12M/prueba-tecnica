package com.prueba.tecnica.exceptions;

public class ClienteExistenteException extends  RuntimeException{
    public ClienteExistenteException(String message) {
        super(message);
    }
}
