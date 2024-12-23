package com.prueba.tecnica.controllers;

import com.prueba.tecnica.entitys.ClienteEntity;
import com.prueba.tecnica.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruebatecnica/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> obtenerClientes(){
        return clienteService.findAll();
    }

    @PostMapping
    public ClienteEntity crearCliente(@RequestBody ClienteEntity cliente){
        System.out.println(cliente.getCedula());
        return clienteService.saveCliente(cliente);
    }
}
