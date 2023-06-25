package com.lt.moneytransfer.service.impl;

import com.lt.moneytransfer.model.entity.Moneda;
import com.lt.moneytransfer.repository.IMonedaRepository;
import com.lt.moneytransfer.service.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements IMonedaService {

    @Autowired
    private IMonedaRepository monedaRepository;

    @Override
    public Moneda save(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    @Override
    public void delete(BigInteger id) {
        monedaRepository.deleteById(id);
    }

    @Override
    public Optional<Moneda> findById(BigInteger id) {
        return monedaRepository.findById(id);
    }

    @Override
    public List<Moneda> saveAll(List<Moneda> t) {
        return monedaRepository.saveAll(t);
    }

    @Override
    public List<Moneda> findAll() {
        return monedaRepository.findAll();
    }
}
