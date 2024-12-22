package com.prueba.tecnica.repositorys;

import com.prueba.tecnica.entitys.MarcasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepository extends JpaRepository<MarcasEntity,Long> {

}
