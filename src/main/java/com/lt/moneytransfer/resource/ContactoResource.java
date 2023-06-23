package com.lt.moneytransfer.resource;

import com.lt.moneytransfer.config.ConfigProperties;
import com.lt.moneytransfer.model.dto.Contacto;
import com.lt.moneytransfer.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContactoResource {

    @Autowired
    private IEmailService emailService;

    @Autowired
    private ConfigProperties configProperties;

    public ResponseEntity<?> sendEmailContacto(Contacto contacto) {
        emailService.sendEmail(configProperties.getApplicationEmail(), configProperties.getApplicationFromEmail(), contacto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
