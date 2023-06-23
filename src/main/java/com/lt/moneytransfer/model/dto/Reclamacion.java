package com.lt.moneytransfer.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Reclamacion {

    private String nombresCliente;

    private String documentoCliente;

    private String telefonoCliente;

    private String correoCliente;

    private String direccionCliente;

    private String provinciaCliente;

    private String ciudadCliente;

    private String datosRl;

    private String nombresRl;

    private String documentoRl;

    private String telefonoRl;

    private String correoRl;

    private String direccionRl;

    private String provinciaRl;

    private String ciudadRl;

    private String datosQueja;

    private String nombreEstablecimiento;

    private String origenHechos;

    private String motivo;

    private List<Documentacion> documentos;

}
