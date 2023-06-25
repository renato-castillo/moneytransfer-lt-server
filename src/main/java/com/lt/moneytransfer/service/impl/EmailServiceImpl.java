package com.lt.moneytransfer.service.impl;

import com.lt.moneytransfer.model.dto.Contacto;
import com.lt.moneytransfer.model.dto.Documentacion;
import com.lt.moneytransfer.model.dto.Reclamacion;
import com.lt.moneytransfer.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private JavaMailSender emailSender;

    private static final String CLOSE_ET_P = "</p>";
    @Override
    @Async
    public ResponseEntity<?> sendEmail(String para, String de, Contacto contacto) {
        MimeMessageHelper helper = null;
        MimeMessage message = null;
        StringBuilder sbAsunto = null;
        try {

            message = emailSender.createMimeMessage();
            helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(para);
            helper.setFrom(de);
            sbAsunto = new StringBuilder();
            sbAsunto.append("INFORMACIÒN DE CONTACTO " + contacto.getNombre().toUpperCase());

            helper.setSubject(sbAsunto.toString());

            helper.setText(generateTemplate("CONTACTO", contacto, null), true);

            emailSender.send(message);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> sendEmailWithAttachments(String para, String de, Reclamacion reclamacion) {
        MimeMessageHelper helper = null;
        MimeMessage message = null;
        StringBuilder sbAsunto = null;
        try {

            message = emailSender.createMimeMessage();
            helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(para);
            helper.setFrom(de);
            sbAsunto = new StringBuilder();
            sbAsunto.append("RELAMACIÓN " + reclamacion.getNombresCliente().toUpperCase());


            helper.setSubject(sbAsunto.toString());

            helper.setText(generateTemplate("RECLAMO", null, reclamacion), true);

            int i = 0;
            for(Documentacion documentacion : reclamacion.getDocumentos()) {
                byte[] archivoBytes = Base64Utils.decodeFromString(documentacion.getDocumentoB64());
                helper.addAttachment("Documento " + i+1 + ".pdf", new ByteArrayResource(archivoBytes));
                i++;
            }

            emailSender.send(message);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private String generateTemplate(String template, Contacto contacto,
                                    Reclamacion reclamacion) {

        StringBuilder sb = new StringBuilder();

        switch (template.toUpperCase()) {
            case "CONTACTO":
                sb.append("<html><body>");
                sb.append("<p><strong>INFORMACIÓN DE CONTACTO</strong></p><br>");
                sb.append("<p>Nombre : </strong>");
                sb.append(contacto.getNombre());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Correo : </strong>");
                sb.append(contacto.getCorreo());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Mensaje : </strong>");
                sb.append(contacto.getMensaje());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Este correo es informativo, No responder</strong></p><br>");
                sb.append("<p>Atentamente,</p>");
                sb.append("<p>PAGINA DE LATIN TRAVEL</p>");
                sb.append("</body></html>");
                break;
            case "RECLAMO":
                sb.append("<html><body>");
                sb.append("<p><strong>RECLAMACIÓN</strong></p><br>");
                sb.append("<p>Nombres y Apellidos Cliente: </strong>");
                sb.append(reclamacion.getNombresCliente());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Número de Documento de Identidad Cliente: </strong>");
                sb.append(reclamacion.getDocumentoCliente());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Teléfono Cliente : </strong>");
                sb.append(reclamacion.getTelefonoCliente());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Correo Cliente : </strong>");
                sb.append(reclamacion.getCorreoCliente());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Dirección Cliente : </strong>");
                sb.append(reclamacion.getDireccionCliente());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Provincia Cliente : </strong>");
                sb.append(reclamacion.getProvinciaCliente());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Ciudad Cliente : </strong>");
                sb.append(reclamacion.getCiudadCliente());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Datos Reperesentante Legal : </strong>");
                sb.append(reclamacion.getDatosRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Nombre Representante Legal : </strong>");
                sb.append(reclamacion.getNombresRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Documento Representante Legal : </strong>");
                sb.append(reclamacion.getDocumentoRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Teléfono Representante Legal : </strong>");
                sb.append(reclamacion.getTelefonoRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Correo Representante Legal : </strong>");
                sb.append(reclamacion.getCorreoRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Dirección Representante Legal : </strong>");
                sb.append(reclamacion.getDireccionRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Provincia Representante Legal : </strong>");
                sb.append(reclamacion.getProvinciaRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Ciudad Representante Legal : </strong>");
                sb.append(reclamacion.getCiudadRl());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Datos Queja o Reclamación : </strong>");
                sb.append(reclamacion.getDatosQueja());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Nombre del establecimiento/Agente Autorizado : </strong>");
                sb.append(reclamacion.getNombreEstablecimiento());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Origen de los hechos (Oficina/Departamento/Servicio) : </strong>");
                sb.append(reclamacion.getOrigenHechos());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Escriba el motivo : </strong>");
                sb.append(reclamacion.getMotivo());
                sb.append(CLOSE_ET_P);
                sb.append("<p>Este correo es informativo, No responder</strong></p><br>");
                sb.append("<p>Atentamente,</p>");
                sb.append("<p>PAGINA DE LATIN TRAVEL</p>");
                sb.append("</body></html>");
                break;
            default:
                break;
        }

        return sb.toString();
    }
}
