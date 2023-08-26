package com.lt.moneytransfer.controller;

import com.lt.moneytransfer.model.entity.Moneda;
import com.lt.moneytransfer.resource.MonedaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/moneda")
public class MonedaController {

    @Autowired
    private MonedaResource monedaResource;

    @GetMapping
    public ResponseEntity<List<Moneda>> listarMonedas() {
        return monedaResource.listarMonedas();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Moneda> registrarMoneda(@RequestBody Moneda moneda) {
        return monedaResource.registrarMoneda(moneda);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Moneda> editarMoneda(@RequestBody Moneda moneda) {
        return monedaResource.editarMoneda(moneda);
    }

    @DeleteMapping(value = "/{monedaId}")
    public ResponseEntity<?> eliminarMoneda(@PathVariable BigInteger monedaId) {
        return monedaResource.eliminarMoneda(monedaId);
    }


}
