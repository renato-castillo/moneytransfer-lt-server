package com.lt.moneytransfer.controller;

import com.lt.moneytransfer.model.entity.Agencia;
import com.lt.moneytransfer.resource.AgenciaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaResource agenciaResource;

    @GetMapping
    public ResponseEntity<List<Agencia>> findAll() {
        return agenciaResource.findAll();
    }

}
