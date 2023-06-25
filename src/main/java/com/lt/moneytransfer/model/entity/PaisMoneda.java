package com.lt.moneytransfer.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "pais_monedas")
public class PaisMoneda {

    @Id
    @Column(name = "paismoneda_id", columnDefinition = "integer")
    private BigInteger paisMonedaId;

    @ManyToOne
    @JoinColumn(name = "paismoneda_pais_id", referencedColumnName = "paisId")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "paismoneda_moneda_id", referencedColumnName = "monedaId")
    private Moneda moneda;

}
