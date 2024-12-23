package com.prueba.tecnica.dto;

import com.prueba.tecnica.entitys.CamaraEntity;
import com.prueba.tecnica.entitys.ClienteEntity;
import jakarta.persistence.*;

import java.util.Date;

public class AlquilerDTO {


    private Long camara;
    private Long cliente;
    private Date fechaEntrega;
    private boolean estado;


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getCamara() {
        return camara;
    }

    public void setCamara(Long camara) {
        this.camara = camara;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }



    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }
}
