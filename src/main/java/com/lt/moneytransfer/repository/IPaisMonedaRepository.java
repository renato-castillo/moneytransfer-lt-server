package com.lt.moneytransfer.repository;

import com.lt.moneytransfer.model.entity.PaisMoneda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IPaisMonedaRepository extends JpaRepository<PaisMoneda, BigInteger> {
}
