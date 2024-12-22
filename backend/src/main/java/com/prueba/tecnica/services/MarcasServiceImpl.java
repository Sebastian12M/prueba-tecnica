package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.MarcasEntity;
import com.prueba.tecnica.repositorys.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcasServiceImpl implements MarcasService{
    @Autowired
    MarcasRepository marcaRepository;
    @Override
    public List<MarcasEntity> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public MarcasEntity updateMarca() {
        return null;
    }

    @Override
    public void deleteMarc(Long id) {

    }

    @Override
    public MarcasEntity saveMarca(MarcasEntity marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public MarcasEntity findById(Long id) {
        Optional<MarcasEntity>marca = marcaRepository.findById(id);
        return marca.get();
    }
}
