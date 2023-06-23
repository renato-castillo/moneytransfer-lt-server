package com.lt.moneytransfer.controller;

import com.lt.moneytransfer.model.dto.Contacto;
import com.lt.moneytransfer.resource.ContactoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacto")
public class ContactoController {

    @Autowired
    private ContactoResource contactoResource;

    @PostMapping(value = "/send", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> sendEmailContacto(@RequestBody Contacto contacto) {
        return contactoResource.sendEmailContacto(contacto);
    }

}
