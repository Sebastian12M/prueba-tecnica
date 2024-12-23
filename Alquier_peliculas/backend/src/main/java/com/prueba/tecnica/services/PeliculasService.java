package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.PeliculasEntity;

import java.util.List;

public interface PeliculasService {
    List<PeliculasEntity> findAll();
    PeliculasEntity findById(Long id);
    void deleteById(Long id);
    PeliculasEntity savePelicula(PeliculasEntity entity);
    List<PeliculasEntity> findAllById(List<Long> ids);
}
