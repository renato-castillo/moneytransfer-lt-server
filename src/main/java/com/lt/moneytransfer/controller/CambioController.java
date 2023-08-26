package com.lt.moneytransfer.controller;

import com.lt.moneytransfer.model.entity.TipoCambio;
import com.lt.moneytransfer.resource.CambioResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TipoCambio>> listarTiposCambio() {
        return cambioResource.listarTiposCambio();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<TipoCambio> registrarTipoCambio(@RequestBody TipoCambio tipoCambio) {
        return cambioResource.registrarTipoCambio(tipoCambio);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<TipoCambio> editarTipoCambio(@RequestBody TipoCambio tipoCambio) {
        return cambioResource.editarTipoCambio(tipoCambio);
    }

    @DeleteMapping(value = "/{tipoCambioId}")
    public ResponseEntity<?> eliminarTipoCambio(@PathVariable BigInteger tipoCambioId) {
        return cambioResource.eliminarTipoCambio(tipoCambioId);
    }

}
