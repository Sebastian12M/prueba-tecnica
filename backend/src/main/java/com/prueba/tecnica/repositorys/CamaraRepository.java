package com.prueba.tecnica.repositorys;

import com.prueba.tecnica.entitys.CamaraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamaraRepository extends JpaRepository<CamaraEntity, Long> {

}
