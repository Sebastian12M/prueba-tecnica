package com.prueba.tecnica.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="camaras")
public class CamaraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private MarcasEntity marca;

    @JoinColumn(name = "soporte_flash")
    private boolean soporteFlash;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "peliculas_camaras",
            joinColumns =@JoinColumn(name = "camara_id"),
            inverseJoinColumns = @JoinColumn(name = "peliculas_id")
    )
    private List<PeliculasEntity> peliculas;

    private String estado;

    public CamaraEntity() {
    }

    public CamaraEntity(Long id, String estado, List<PeliculasEntity> peliculas, boolean soporteFlash, MarcasEntity marca, String modelo) {
        this.id = id;
        this.estado = estado;
        this.peliculas = peliculas;
        this.soporteFlash = soporteFlash;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PeliculasEntity> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculasEntity> peliculas) {
        this.peliculas = peliculas;
    }

    public boolean isSoporteFlash() {
        return soporteFlash;
    }

    public void setSoporteFlash(boolean soporteFlash) {
        this.soporteFlash = soporteFlash;
    }

    public MarcasEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcasEntity marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
