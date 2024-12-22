package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.AlquilerEntity;
import com.prueba.tecnica.entitys.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlquilerService{
    Optional<AlquilerEntity> findById(Long id);
    AlquilerEntity save(AlquilerEntity alquiler);
    List<AlquilerEntity> findAll();
    void deleteById(Long id);boolean permitirAlquiler(ClienteEntity cliente);

}
