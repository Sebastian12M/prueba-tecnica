package com.prueba.tecnica.services;

import com.prueba.tecnica.dto.AlquilerDTO;
import com.prueba.tecnica.entitys.AlquilerEntity;
import com.prueba.tecnica.entitys.CamaraEntity;
import com.prueba.tecnica.entitys.ClienteEntity;
import com.prueba.tecnica.exceptions.AlquilerImposibleException;
import com.prueba.tecnica.exceptions.CamaraNoDisponibleException;
import com.prueba.tecnica.exceptions.ClienteInexistenteException;
import com.prueba.tecnica.repositorys.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

            if(cliente.isPresent()){
                if (cliente.get().getDiasMulta()<=0){
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
                }else {
                    throw new AlquilerImposibleException("El cliente cuenta con una multa de: "+cliente.get().getDiasMulta()+" dias");
                }

            }else{
                throw new ClienteInexistenteException("El cliente no existe");
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

    @Override
    public AlquilerEntity ingresarDevolucion(AlquilerDTO alquiler) {
        Optional<ClienteEntity> cliente = clienteService.findByCedula(alquiler.getCliente());
        AlquilerEntity alquilerUpdate = new AlquilerEntity();
        if(cliente.isPresent()){
            List<AlquilerEntity> alquileres = alquilerRepository.findByCliente(cliente.get());
            if(permitirAlquiler(cliente.get())){
                for (AlquilerEntity itemAlquiler: alquileres){
                    if(!itemAlquiler.isEstado()){
                        itemAlquiler.setEstado(true);
                        itemAlquiler.getCamara().setEstado("DISPONIBLE");
                        itemAlquiler.setFechaEntrega(alquiler.getFechaEntrega());

                        Long diasPasados = itemAlquiler.getFechaEntrega().getTime()-itemAlquiler.getFechaInicio().getTime() ;
                        Long dias = TimeUnit.MILLISECONDS.toDays(diasPasados);
                        System.out.println("Validando dias de multa "+ dias +" dias en mili "+ diasPasados);
                        if(dias> 7){
                            Long diasMulta = (dias - 7) *30;
                            cliente.get().setDiasMulta(cliente.get().getDiasMulta()+diasMulta.intValue());
                            clienteService.update(cliente.get());
                        }
                        alquilerUpdate=itemAlquiler;

                        break;
                    }


                }
                return  alquilerRepository.save(alquilerUpdate);
            }else {
                throw new AlquilerImposibleException("El cliente no tiene alquieleres pendientes");
            }
        }else {
            throw new ClienteInexistenteException("El cliente no existe");
        }
    }


}
