package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.MarcasEntity;

import java.util.List;

public interface MarcasService {
    List<MarcasEntity> findAll();
    MarcasEntity updateMarca();
    void deleteMarc(Long id);
    MarcasEntity saveMarca(MarcasEntity marca);
    MarcasEntity findById(Long id);
}
