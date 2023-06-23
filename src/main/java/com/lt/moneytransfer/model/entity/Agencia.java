package com.lt.moneytransfer.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "agencias")
public class Agencia {

    @Id
    @Column(name = "agencia_id", columnDefinition = "integer")
    private BigInteger agenciaId;

    @Column(name = "agencia_latitud")
    private Double agenciaLatitud;

    @Column(name = "agencia_longitud")
    private Double agenciaLongitud;

    @Column(name = "agencia_titulo")
    private String agenciaTitulo;

    @Column(name = "agencia_telefono")
    private String telefono;

    @Column(name = "agencia_direccion")
    private String agenciaDireccion;

}
