package com.prueba.tecnica.repositorys;

import com.prueba.tecnica.entitys.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
    ClienteEntity save(ClienteEntity cliente);
    Optional<ClienteEntity>findByCedula(Long cedula);
}
