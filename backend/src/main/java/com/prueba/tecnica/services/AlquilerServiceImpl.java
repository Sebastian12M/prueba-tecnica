package com.prueba.tecnica.services;

import com.prueba.tecnica.entitys.AlquilerEntity;
import com.prueba.tecnica.entitys.CamaraEntity;
import com.prueba.tecnica.entitys.ClienteEntity;
import com.prueba.tecnica.exceptions.AlquilerImposibleException;
import com.prueba.tecnica.exceptions.CamaraNoDisponibleException;
import com.prueba.tecnica.repositorys.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerServiceImpl implements AlquilerService{
    @Autowired
    private AlquilerRepository alquilerRepository;
    @Autowired
    CamaraService camaraService;

    @Autowired
    ClienteService clienteService;
    @Override
    public Optional<AlquilerEntity> findById(Long id) {
        return  alquilerRepository.findById(id);
    }

    @Override
    public AlquilerEntity save(AlquilerEntity alquiler) {
        Optional<CamaraEntity> camara = camaraService.findById(alquiler.getCamara().getId());
        Optional<ClienteEntity>cliente= clienteService.findById(alquiler.getCliente().getId());
        if(!permitirAlquiler(cliente.get())){
            if(camara.isPresent() && camara.get().getEstado().equals("DISPONIBLE")){
                camara.get().setEstado("ALQUILADO");
                camaraService.saveCamara(camara.get());
                return alquilerRepository.save(alquiler);
            }else{
                throw new CamaraNoDisponibleException("La camara no esta disponible");
            }
        }else {
            throw new AlquilerImposibleException("No puede alquilar mas de una camara");
        }






    }

    @Override
    public List<AlquilerEntity> findAll() {
        return alquilerRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean permitirAlquiler(ClienteEntity cliente) {
        List<AlquilerEntity> alquileres = alquilerRepository.findByCliente(cliente);
         boolean estado = alquileres.stream().anyMatch(alquiler-> alquiler.isEstado()==false);

        return estado;
    }


}
