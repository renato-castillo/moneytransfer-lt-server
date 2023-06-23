package com.lt.moneytransfer.resource;

import com.lt.moneytransfer.model.entity.Agencia;
import com.lt.moneytransfer.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaResource {

    @Autowired
    private AgenciaService agenciaService;

    public ResponseEntity<List<Agencia>> findAll() {

        List<Agencia> agencias = agenciaService.findAll();

        return new ResponseEntity<>(agencias, HttpStatus.OK);

    }

}
