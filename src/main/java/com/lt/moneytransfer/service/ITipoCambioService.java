package com.lt.moneytransfer.service;

import com.lt.moneytransfer.model.entity.TipoCambio;
import com.lt.moneytransfer.util.ICRUD;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ITipoCambioService extends ICRUD<TipoCambio, BigInteger> {

    Optional<TipoCambio> findByMonedaOrigen_MonedaIdIsAndMonedaDestino_MonedaIdIs(BigInteger monedaId, BigInteger monedaDestinoId);

    List<TipoCambio> findAllByMonedaOrigenIn(List<BigInteger> monedaIds);

    List<TipoCambio> findAllByMonedaOrigenIs(BigInteger monedaId);

    Optional<TipoCambio> findByMonedaOrigenIdIsAndMonedaDestinoIdIs(BigInteger monedaOrigenId, BigInteger monedaDestinoId);

}
