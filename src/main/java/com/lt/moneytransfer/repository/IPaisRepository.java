package com.lt.moneytransfer.repository;

import com.lt.moneytransfer.model.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface IPaisRepository extends JpaRepository<Pais, BigInteger> {

    @Query(value = "SELECT p FROM Pais p WHERE p.moneda.monedaId IN (?1)")
    List<Pais> findAllByMoneda_MonedaIdIn(List<BigInteger> monedaIds);

}
