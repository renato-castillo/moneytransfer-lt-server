package com.lt.moneytransfer.service.impl;

import com.lt.moneytransfer.model.entity.TipoCambio;
import com.lt.moneytransfer.repository.ITipoCambioRepository;
import com.lt.moneytransfer.service.ITipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements ITipoCambioService {

    @Autowired
    private ITipoCambioRepository tipoCambioRepository;

    @Override
    public TipoCambio save(TipoCambio tipoCambio) {
        return tipoCambioRepository.save(tipoCambio);
    }

    @Override
    public void delete(BigInteger id) {
        tipoCambioRepository.deleteById(id);
    }

    @Override
    public Optional<TipoCambio> findById(BigInteger id) {
        return tipoCambioRepository.findById(id);
    }

    @Override
    public List<TipoCambio> saveAll(List<TipoCambio> t) {
        return tipoCambioRepository.saveAll(t);
    }

    @Override
    public List<TipoCambio> findAll() {
        return tipoCambioRepository.findAll();
    }

    @Override
    public Optional<TipoCambio> findByMonedaOrigen_MonedaIdIsAndMonedaDestino_MonedaIdIs(BigInteger monedaId, BigInteger monedaDestinoId) {
        return tipoCambioRepository.findByMonedaOrigen_MonedaIdIsAndMonedaDestino_MonedaIdIs(monedaId, monedaDestinoId);
    }

    @Override
    public List<TipoCambio> findAllByMonedaOrigenIn(List<BigInteger> monedaIds) {
        return tipoCambioRepository.findAllByMonedaOrigenIn(monedaIds);
    }
}
