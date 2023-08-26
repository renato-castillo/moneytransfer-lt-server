package com.lt.moneytransfer.resource;

import com.lt.moneytransfer.model.entity.Moneda;
import com.lt.moneytransfer.service.IMonedaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MonedaResource {

    @Autowired
    private IMonedaService monedaService;

    public ResponseEntity<Moneda> registrarMoneda(Moneda moneda) {

        Moneda monedaSave = monedaService.save(moneda);

        return new ResponseEntity<>(monedaSave, HttpStatus.OK);

    }

    public ResponseEntity<Moneda> editarMoneda(Moneda moneda) {

        Moneda monedaToSave = monedaService.findById(moneda.getMonedaId()).orElse(null);

        if(monedaToSave == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        monedaToSave = monedaService.save(moneda);

        return new ResponseEntity<>(monedaToSave, HttpStatus.OK);

    }

    public ResponseEntity<List<Moneda>> listarMonedas() {
        List<Moneda> monedas = monedaService.findAll();

        return new ResponseEntity<>(monedas, HttpStatus.OK);
    }

    public ResponseEntity<?> eliminarMoneda(BigInteger monedaId) {

        Moneda moneda = monedaService.findById(monedaId).orElse(null);

        if(moneda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        monedaService.delete(monedaId);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
