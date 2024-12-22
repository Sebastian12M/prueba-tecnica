package com.prueba.tecnica.dto;

import java.util.List;

public class CamaraDTO {
    private String modelo;
    private Long marca;
    private boolean soporteFlash;
    private List<Long> peliculas;
    private String estado;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isSoporteFlash() {
        return soporteFlash;
    }

    public void setSoporteFlash(boolean soporteFlash) {
        this.soporteFlash = soporteFlash;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long marca) {
        this.marca = marca;
    }

    public List<Long> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Long> peliculas) {
        this.peliculas = peliculas;
    }
}
