package com.lt.moneytransfer.resource;

import com.lt.moneytransfer.model.entity.Pais;
import com.lt.moneytransfer.model.entity.TipoCambio;
import com.lt.moneytransfer.service.IMonedaService;
import com.lt.moneytransfer.service.IPaisMonedaService;
import com.lt.moneytransfer.service.IPaisService;
import com.lt.moneytransfer.service.ITipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CambioResource {

    @Autowired
    private ITipoCambioService tipoCambioService;

    @Autowired
    private IPaisService paisService;

    public ResponseEntity<List<Pais>> obtenerPaises() {
        List<Pais> paises = paisService.findAll();

        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    public ResponseEntity<List<Pais>> obtenerPaisesCambio(BigInteger paisId) {

        Pais pais = paisService.findById(paisId).orElse(null);

        if(pais == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<TipoCambio> tipoCambios = tipoCambioService.findAllByMonedaOrigenIs(pais.getMoneda().getMonedaId());

        if(tipoCambios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Pais> paises = paisService.findAllByMoneda_MonedaIdIn(tipoCambios.stream().map(x -> x.getMonedaDestino().getMonedaId()).collect(Collectors.toList()));

        paises.forEach(x -> tipoCambios.stream().filter(tc -> Objects.equals(tc.getMonedaDestino().getMonedaId(),
                x.getMoneda().getMonedaId())).findFirst().ifPresent(x::setTipoCambio));

        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    public ResponseEntity<TipoCambio> registrarTipoCambio(TipoCambio tipoCambio) {

        Optional<TipoCambio> tipoCambioExiste = tipoCambioService.findByMonedaOrigenIdIsAndMonedaDestinoIdIs(tipoCambio.getMonedaOrigen().getMonedaId(), tipoCambio.getMonedaDestino().getMonedaId());

        if(tipoCambioExiste.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        tipoCambio = tipoCambioService.save(tipoCambio);

        return new ResponseEntity<>(tipoCambio, HttpStatus.OK);

    }

    public ResponseEntity<TipoCambio> editarTipoCambio(TipoCambio tipoCambio) {

        Optional<TipoCambio> tipoCambioExiste = tipoCambioService.findById(tipoCambio.getTipoCambioId());

        if(!tipoCambioExiste.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tipoCambio = tipoCambioService.save(tipoCambio);

        return new ResponseEntity<>(tipoCambio, HttpStatus.OK);

    }

    public ResponseEntity<List<TipoCambio>> listarTiposCambio() {
        List<TipoCambio> tipoCambios = tipoCambioService.findAll();

        return new ResponseEntity<>(tipoCambios, HttpStatus.OK);

    }

    public ResponseEntity<?> eliminarTipoCambio(BigInteger tipoCambioId) {
        TipoCambio tipoCambio = tipoCambioService.findById(tipoCambioId).orElse(null);

        if(tipoCambio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tipoCambioService.delete(tipoCambioId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
