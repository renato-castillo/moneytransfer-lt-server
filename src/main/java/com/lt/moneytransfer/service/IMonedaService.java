package com.lt.moneytransfer.service;

import com.lt.moneytransfer.model.entity.Moneda;
import com.lt.moneytransfer.util.ICRUD;

import java.math.BigInteger;

public interface IMonedaService extends ICRUD<Moneda, BigInteger> {
}
