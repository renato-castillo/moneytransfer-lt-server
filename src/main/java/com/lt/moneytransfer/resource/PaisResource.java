package com.lt.moneytransfer.resource;

import com.lt.moneytransfer.model.entity.Moneda;
import com.lt.moneytransfer.model.entity.Pais;
import com.lt.moneytransfer.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PaisResource {

    @Autowired
    private IPaisService paisService;

    public ResponseEntity<Pais> registrarPais(Pais pais) {

        Pais paisToSave = paisService.save(pais);

        return new ResponseEntity<>(paisToSave, HttpStatus.OK);

    }

    public ResponseEntity<Pais> editarPais(Pais pais) {

        Pais paisToSave = paisService.findById(pais.getPaisId()).orElse(null);

        if(paisToSave == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        paisToSave = paisService.save(pais);

        return new ResponseEntity<>(paisToSave, HttpStatus.OK);

    }

    public ResponseEntity<List<Pais>> listarPaises() {
        List<Pais> paises = paisService.findAll();

        return new ResponseEntity<>(paises, HttpStatus.OK);

    }

    public ResponseEntity<?> eliminarPais(BigInteger paisId) {

        Pais pais = paisService.findById(paisId).orElse(null);

        if(pais == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        paisService.delete(paisId);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
