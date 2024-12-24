package com.prueba.tecnica.controllers;

import com.prueba.tecnica.dto.CamaraDTO;
import com.prueba.tecnica.entitys.CamaraEntity;
import com.prueba.tecnica.entitys.MarcasEntity;
import com.prueba.tecnica.entitys.PeliculasEntity;
import com.prueba.tecnica.services.CamaraServiceImpl;
import com.prueba.tecnica.services.MarcasService;
import com.prueba.tecnica.services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pruebatecnica/camaras")
public class CamaraController {
    @Autowired
    private MarcasService marcasService;
    @Autowired
    private CamaraServiceImpl camaraService;
    @Autowired
    PeliculasService peliculasService;

    @GetMapping
    public List<CamaraEntity> obtenerCamaras(){
        return camaraService.findAll();
    }

    @PostMapping
    public CamaraEntity saveCamara(@RequestBody CamaraDTO camaraDTO){

      CamaraEntity camara = new CamaraEntity();
      List<PeliculasEntity> peliculas = peliculasService.findAllById(camaraDTO.getPeliculas());
      camara.setModelo(camaraDTO.getModelo());
      camara.setMarca(marcasService.findById(camaraDTO.getMarca()));
      camara.setSoporteFlash(camaraDTO.isSoporteFlash());
      camara.setPeliculas(peliculas);
      camara.setEstado(camaraDTO.getEstado());

      camara.getPeliculas().forEach(pelicula->{
          System.out.println( pelicula.getNombre());
      });

      return camaraService.saveCamara(camara);
    }

    @GetMapping("{id}")
    public CamaraEntity obtenerCamaraPorId(@PathVariable Long id){
        Optional<CamaraEntity> camara = camaraService.findById(id);
        return camara.get();
    }

    @PutMapping
    public CamaraEntity updateCamara(@RequestBody CamaraEntity camara){

        return camaraService.updateCamara(camara);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEstado(@PathVariable Long id, @RequestBody String estado){
        Optional<CamaraEntity> camara = camaraService.findById(id);
        if (camara.isPresent()){
            camara.get().setEstado(estado);
        }

        return ResponseEntity.ok().body(camaraService.saveCamara(camara.get()));
    }

}
