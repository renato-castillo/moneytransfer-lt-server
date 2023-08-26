package com.lt.moneytransfer.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private BigInteger paisId;

    private String paisNombre;

    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "pais_moneda_id", referencedColumnName = "monedaId")
    private Moneda moneda;

    @Column(name = "pais_imagen")
    private String paisImagen;

    @Transient
    private TipoCambio tipoCambio;

}
