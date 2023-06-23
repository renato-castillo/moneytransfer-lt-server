package com.lt.moneytransfer.service;

import com.lt.moneytransfer.model.dto.Contacto;
import com.lt.moneytransfer.model.dto.Documentacion;
import com.lt.moneytransfer.model.dto.Reclamacion;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmailService {

    ResponseEntity<?> sendEmail(String para, String de, Contacto reclamacion);

    ResponseEntity<?> sendEmailWithAttachments(String para, String de, Reclamacion reclamacion);

}
