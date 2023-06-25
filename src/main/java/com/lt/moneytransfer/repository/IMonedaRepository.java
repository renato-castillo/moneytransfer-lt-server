package com.lt.moneytransfer.repository;

import com.lt.moneytransfer.model.entity.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IMonedaRepository extends JpaRepository<Moneda, BigInteger> {
}
