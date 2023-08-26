package com.lt.moneytransfer.repository;

import com.lt.moneytransfer.model.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ITipoCambioRepository extends JpaRepository<TipoCambio, BigInteger> {

    Optional<TipoCambio> findByMonedaOrigen_MonedaIdIsAndMonedaDestino_MonedaIdIs(BigInteger monedaId, BigInteger monedaDestinoId);

    @Query(value = "SELECT tc FROM TipoCambio tc WHERE tc.monedaOrigen.monedaId IN (?1)")
    List<TipoCambio> findAllByMonedaOrigenIn(List<BigInteger> monedaIds);

    @Query(value = "SELECT tc FROM TipoCambio tc WHERE tc.monedaOrigen.monedaId = ?1")
    List<TipoCambio> findAllByMonedaOrigenIs(BigInteger monedaId);

    @Query(value = "SELECT tc FROM TipoCambio tc WHERE tc.monedaOrigen.monedaId = ?1 AND tc.monedaDestino.monedaId = ?2")
    Optional<TipoCambio> findByMonedaOrigenIdIsAndMonedaDestinoIdIs(BigInteger monedaOrigenId, BigInteger monedaDestinoId);

}
