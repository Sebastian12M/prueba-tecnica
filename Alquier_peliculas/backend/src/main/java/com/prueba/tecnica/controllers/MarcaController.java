package com.prueba.tecnica.controllers;

import com.prueba.tecnica.entitys.MarcasEntity;
import com.prueba.tecnica.services.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruebatecnica/marcas")
public class MarcaController {
    @Autowired
    MarcasService marcasService;
    @GetMapping
    public List<MarcasEntity> obtenerMarcas(){
        return marcasService.findAll();
    }

    @PostMapping
    public MarcasEntity crearMarca(@RequestBody  MarcasEntity marca){
        System.out.println(marca.getDireccion());
        return marcasService.saveMarca(marca);
    }

}
