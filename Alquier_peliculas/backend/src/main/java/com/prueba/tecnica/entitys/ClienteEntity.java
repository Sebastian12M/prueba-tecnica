package com.prueba.tecnica.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cedula;
    private String nombre;
    private String correo;
    @JoinColumn(name = "dias_multa")
    private Integer diasMulta;

    public ClienteEntity() {
    }

    public ClienteEntity(Long cedula, String nombre, String correo, Integer diasMulta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.diasMulta = diasMulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getDiasMulta() {
        return diasMulta;
    }

    public void setDiasMulta(Integer diasMulta) {
        this.diasMulta = diasMulta;
    }
}
