package com.lt.moneytransfer.service.impl;

import com.lt.moneytransfer.model.entity.Agencia;
import com.lt.moneytransfer.repository.IAgenciaRepository;
import com.lt.moneytransfer.service.IAgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class AgenciaServiceImpl implements IAgenciaService {

    @Autowired
    private IAgenciaRepository agenciaRepository;

    @Override
    public Agencia save(Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    @Override
    public void delete(BigInteger id) {
        agenciaRepository.deleteById(id);
    }

    @Override
    public Optional<Agencia> findById(BigInteger id) {
        return agenciaRepository.findById(id);
    }

    @Override
    public List<Agencia> saveAll(List<Agencia> t) {
        return agenciaRepository.saveAll(t);
    }

    @Override
    public List<Agencia> findAll() {
        return agenciaRepository.findAll();
    }
}
