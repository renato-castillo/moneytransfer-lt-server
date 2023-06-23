package com.lt.moneytransfer.controller;

import com.lt.moneytransfer.model.dto.Reclamacion;
import com.lt.moneytransfer.resource.ReclamacionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reclamacion")
public class ReclamacionController {

    @Autowired
    private ReclamacionResource reclamacionResource;

    @PostMapping(value = "/send", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> sendEmail(@RequestBody Reclamacion reclamacion) {
        return reclamacionResource.sendEmailContacto(reclamacion);
    }


}
