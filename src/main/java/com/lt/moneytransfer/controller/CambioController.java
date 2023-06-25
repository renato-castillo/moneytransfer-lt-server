package com.lt.moneytransfer.controller;

import com.lt.moneytransfer.resource.CambioResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/cambio")
public class CambioController {

    @Autowired
    private CambioResource cambioResource;

    @GetMapping("/paises")
    public ResponseEntity<?> obtenerPaisesCambio() {
        return cambioResource.obtenerPaises();
    }

    @GetMapping("/paises-cambio/{paisId}")
    public ResponseEntity<?> obtenerPaisesParaCambio(@PathVariable BigInteger paisId) {
        return cambioResource.obtenerPaisesCambio(paisId);
    }

}
