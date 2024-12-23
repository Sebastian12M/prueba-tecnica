package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.PeliculasEntity;
import com.prueba.tecnica.repositorys.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculasServiceImpl implements PeliculasService{
    @Autowired
    PeliculasRepository peliculasRepository;
    @Override
    public List<PeliculasEntity> findAll() {
        return null;
    }

    @Override
    public PeliculasEntity findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public PeliculasEntity savePelicula(PeliculasEntity pelicula) {
        return peliculasRepository.save(pelicula);
    }

    @Override
    public List<PeliculasEntity> findAllById(List<Long> ids) {
        return peliculasRepository.findAllById(ids);
    }
}
