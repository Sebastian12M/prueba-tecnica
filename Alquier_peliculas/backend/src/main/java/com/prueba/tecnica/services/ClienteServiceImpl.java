package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.ClienteEntity;
import com.prueba.tecnica.exceptions.ClienteInexistenteException;
import com.prueba.tecnica.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<ClienteEntity> findById(Long id) {
            return clienteRepository.findById(id);
    }

    @Override
    public void deleteCliente(Long id) {

    }

    @Override
    public ClienteEntity saveCliente(ClienteEntity entity) {
        Optional<ClienteEntity>clienrte = clienteRepository.findByCedula(entity.getCedula());
        if(!clienrte.isPresent()){
            return clienteRepository.save(entity);
        }else {
            throw new ClienteInexistenteException("El cliente con la cédula "+entity.getCedula()+" ya existe.");
        }

    }

    @Override
    public Optional<ClienteEntity> findByCedula(Long cedula) {
        return clienteRepository.findByCedula(cedula);
    }

    @Override
    public ClienteEntity update(ClienteEntity entity) {
        return clienteRepository.save(entity);
    }
}
