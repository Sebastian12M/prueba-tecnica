package com.prueba.tecnica.controllers;

import com.prueba.tecnica.dto.AlquilerDTO;
import com.prueba.tecnica.entitys.AlquilerEntity;
import com.prueba.tecnica.entitys.CamaraEntity;
import com.prueba.tecnica.entitys.ClienteEntity;
import com.prueba.tecnica.services.AlquilerService;
import com.prueba.tecnica.services.CamaraService;
import com.prueba.tecnica.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pruebatecnica/alquiler")
public class AlquilerController {
    @Autowired
    private AlquilerService alquilerService;

    @Autowired
    private CamaraService camaraService;
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public List<AlquilerEntity> obtenerAlquileres(){
        return alquilerService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crearAlquiler(@RequestBody AlquilerDTO alquiler){
        Optional<ClienteEntity> cliente = clienteService.findByCedula(alquiler.getCliente());
        Optional<CamaraEntity> camara = camaraService.findById(alquiler.getCamara());



        AlquilerEntity alquilerBD = new AlquilerEntity();
        alquilerBD.setCamara(camara.get());
        alquilerBD.setCliente(cliente.get());
        alquilerBD.setFechaEntrega(alquiler.getFechaEntrega());
        alquilerBD.setFechaInicio(new Date());



        return ResponseEntity.ok(alquilerService.save(alquilerBD));
    }
}
