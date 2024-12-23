package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.CamaraEntity;

import java.util.List;
import java.util.Optional;

public interface CamaraService {
    List<CamaraEntity> findAll();
    Optional<CamaraEntity> findById(Long id);
    CamaraEntity updateCamara();
    void deleteCamara(Long id);
    CamaraEntity saveCamara(CamaraEntity camara);
}
