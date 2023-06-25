package com.lt.moneytransfer.service;

import com.lt.moneytransfer.model.entity.Pais;
import com.lt.moneytransfer.util.ICRUD;

import java.math.BigInteger;
import java.util.List;

public interface IPaisService extends ICRUD<Pais, BigInteger> {

    List<Pais> findAllByIds(List<BigInteger> ids);

    List<Pais> findAllByMoneda_MonedaIdIn(List<BigInteger> monedaIds);


}
