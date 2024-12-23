package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteEntity> findAll();
    Optional<ClienteEntity> findById(Long id);
    void deleteCliente(Long id);
    ClienteEntity saveCliente(ClienteEntity entity);
    Optional<ClienteEntity>findByCedula(Long cedula);
    ClienteEntity update(ClienteEntity entity);
}
