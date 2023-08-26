package com.lt.moneytransfer.controller;

import com.lt.moneytransfer.model.entity.Moneda;
import com.lt.moneytransfer.model.entity.Pais;
import com.lt.moneytransfer.resource.MonedaResource;
import com.lt.moneytransfer.resource.PaisResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisResource paisResource;

    @GetMapping
    public ResponseEntity<List<Pais>> listarPaises() {
        return paisResource.listarPaises();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Pais> registrarPais(@RequestBody Pais pais) {
        return paisResource.registrarPais(pais);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Pais> editarPais(@RequestBody Pais pais) {
        return paisResource.editarPais(pais);
    }

    @DeleteMapping(value = "/{paisId}")
    public ResponseEntity<?> eliminarPais(@PathVariable BigInteger paisId) {
        return paisResource.eliminarPais(paisId);
    }

}
