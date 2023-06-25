package com.lt.moneytransfer.service.impl;

import com.lt.moneytransfer.model.entity.Pais;
import com.lt.moneytransfer.model.entity.PaisMoneda;
import com.lt.moneytransfer.repository.IPaisRepository;
import com.lt.moneytransfer.service.IPaisMonedaService;
import com.lt.moneytransfer.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements IPaisService {

    @Autowired
    private IPaisRepository paisRepository;

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void delete(BigInteger id) {
        paisRepository.deleteById(id);
    }

    @Override
    public Optional<Pais> findById(BigInteger id) {
        return paisRepository.findById(id);
    }

    @Override
    public List<Pais> saveAll(List<Pais> t) {
        return paisRepository.saveAll(t);
    }

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public List<Pais> findAllByIds(List<BigInteger> ids) {
        return paisRepository.findAllById(ids);
    }

    @Override
    public List<Pais> findAllByMoneda_MonedaIdIn(List<BigInteger> monedaIds) {
        return paisRepository.findAllByMoneda_MonedaIdIn(monedaIds);
    }
}
