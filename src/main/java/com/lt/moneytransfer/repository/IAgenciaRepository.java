package com.lt.moneytransfer.repository;

import com.lt.moneytransfer.model.entity.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IAgenciaRepository extends JpaRepository<Agencia, BigInteger> {
}
