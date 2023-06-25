package com.lt.moneytransfer.service.impl;

import com.lt.moneytransfer.model.entity.PaisMoneda;
import com.lt.moneytransfer.repository.IPaisMonedaRepository;
import com.lt.moneytransfer.service.IPaisMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PaisMonedaServiceImpl implements IPaisMonedaService {

    @Autowired
    private IPaisMonedaRepository paisMonedaRepository;

    @Override
    public PaisMoneda save(PaisMoneda paisMoneda) {
        return paisMonedaRepository.save(paisMoneda);
    }

    @Override
    public void delete(BigInteger id) {
        paisMonedaRepository.deleteById(id);
    }

    @Override
    public Optional<PaisMoneda> findById(BigInteger id) {
        return paisMonedaRepository.findById(id);
    }

    @Override
    public List<PaisMoneda> saveAll(List<PaisMoneda> t) {
        return paisMonedaRepository.saveAll(t);
    }

    @Override
    public List<PaisMoneda> findAll() {
        return paisMonedaRepository.findAll();
    }
}
