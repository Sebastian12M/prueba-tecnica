package com.prueba.tecnica.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "alquileres")

public class AlquilerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;


    @ManyToOne
    @JoinColumn(name = "camara_id")
    private CamaraEntity camara;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    private Date fechaInicio;

    private Date fechaEntrega;

    private boolean estado;
    public AlquilerEntity() {
    }

    public AlquilerEntity(boolean estado, Date fechaEntrega, Date fechaInicio, ClienteEntity cliente, CamaraEntity camara) {
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.fechaInicio = fechaInicio;
        this.cliente = cliente;
        this.camara = camara;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public CamaraEntity getCamara() {
        return camara;
    }

    public void setCamara(CamaraEntity camara) {
        this.camara = camara;
    }
}
