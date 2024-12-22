package com.prueba.tecnica.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "peliculas")

public class PeliculasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String nombre;
    private Integer sensibilidadIso;
    private String formato;

    public PeliculasEntity() {
    }

    public PeliculasEntity(String formato, Integer sensibilidadIso, String nombre, String marca) {
        this.formato = formato;
        this.sensibilidadIso = sensibilidadIso;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getSensibilidadIso() {
        return sensibilidadIso;
    }

    public void setSensibilidadIso(Integer sensibilidadIso) {
        this.sensibilidadIso = sensibilidadIso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
