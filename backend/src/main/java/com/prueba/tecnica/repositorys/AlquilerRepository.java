package com.prueba.tecnica.repositorys;

import com.prueba.tecnica.entitys.AlquilerEntity;
import com.prueba.tecnica.entitys.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlquilerRepository  extends JpaRepository<AlquilerEntity,Long> {
    List<AlquilerEntity> findByCliente(ClienteEntity cliente);
}
