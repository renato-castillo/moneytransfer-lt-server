package com.lt.moneytransfer.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "tipo_cambios")
public class TipoCambio {

    @Id
    @Column(name = "tipocambio_id", columnDefinition = "integer")
    private BigInteger tipoCambioId;

    @ManyToOne
    @JoinColumn(name = "tipocambio_moneda_id", referencedColumnName = "monedaId")
    private Moneda monedaOrigen;

    @ManyToOne
    @JoinColumn(name = "tipocambio_moneda_destino_id", referencedColumnName = "monedaId")
    private Moneda monedaDestino;

    @Column(name = "tipocambio_cambio", columnDefinition = "decimal(65,30)")
    private Double tipoCambioCambio;

}
