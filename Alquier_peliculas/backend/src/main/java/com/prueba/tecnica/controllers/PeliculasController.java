package com.prueba.tecnica.controllers;

import com.prueba.tecnica.entitys.PeliculasEntity;
import com.prueba.tecnica.services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruebatecnica/peliculas")
public class PeliculasController {
    @Autowired
    private PeliculasService peliculasService;
    @GetMapping
    public List<PeliculasEntity> obtenerPeliculas(){
        return peliculasService.findAll();
    }

    @PostMapping
    public PeliculasEntity crearPelicula(@RequestBody  PeliculasEntity pelicula){

        return peliculasService.savePelicula(pelicula);
    }
}
