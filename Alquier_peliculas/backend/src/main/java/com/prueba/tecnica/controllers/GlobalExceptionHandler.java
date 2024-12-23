package com.prueba.tecnica.controllers;

import com.prueba.tecnica.exceptions.AlquilerImposibleException;
import com.prueba.tecnica.exceptions.CamaraNoDisponibleException;
import com.prueba.tecnica.exceptions.ClienteExistenteException;
import com.prueba.tecnica.exceptions.ClienteInexistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CamaraNoDisponibleException.class)
    public ResponseEntity<?> hanldleCamaraNoDisponible(CamaraNoDisponibleException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AlquilerImposibleException.class)
    public ResponseEntity<?> handleAlquilerImposible(AlquilerImposibleException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClienteInexistenteException.class)
    public ResponseEntity<?> handleClienteInexistente(ClienteInexistenteException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClienteExistenteException.class)
    public ResponseEntity<?> handleClienteExistente(ClienteExistenteException ex, WebRequest request){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
