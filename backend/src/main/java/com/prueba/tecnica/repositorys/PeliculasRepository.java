package com.prueba.tecnica.repositorys;

import com.prueba.tecnica.entitys.PeliculasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculasRepository extends JpaRepository<PeliculasEntity,Long> {
}
