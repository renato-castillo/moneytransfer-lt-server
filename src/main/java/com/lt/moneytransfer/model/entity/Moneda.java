package com.lt.moneytransfer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "monedas")
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private BigInteger monedaId;

    private String monedaNombre;

    private String monedaSimbolo;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "moneda", orphanRemoval = true)
    private List<Pais> paises;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "monedaOrigen", orphanRemoval = true)
    private List<TipoCambio> tipoCambiosOrigen;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "monedaDestino", orphanRemoval = true)
    private List<TipoCambio> tipoCambiosDestino;

}
