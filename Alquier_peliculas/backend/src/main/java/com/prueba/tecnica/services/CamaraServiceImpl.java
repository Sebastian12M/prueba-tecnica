package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.CamaraEntity;
import com.prueba.tecnica.repositorys.CamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamaraServiceImpl implements CamaraService {
    @Autowired
    private CamaraRepository camaraRepository;

    @Override
    public List<CamaraEntity> findAll() {
        return camaraRepository.findAll();
    }

    @Override
    public Optional<CamaraEntity> findById(Long id) {
        return camaraRepository.findById(id);
    }

    @Override
    public CamaraEntity updateCamara(CamaraEntity camara) {
        return camaraRepository.save(camara);
    }

    @Override
    public void deleteCamara(Long id) {

    }

    @Override
    public CamaraEntity saveCamara(CamaraEntity camara) {
        return camaraRepository.save(camara);
    }
}
