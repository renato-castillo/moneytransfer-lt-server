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

        List<BigInteger> monedaIds = paisService.findAll().stream().filter(pais -> Objects.equals(pais.getPaisId(), paisId)).map(x -> x.getMoneda().getMonedaId()).collect(Collectors.toList());

        List<TipoCambio> tipoCambios = tipoCambioService.findAllByMonedaOrigenIn(monedaIds);

        if(tipoCambios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Pais> paises = paisService.findAllByMoneda_MonedaIdIn(tipoCambios.stream().map(x -> x.getMonedaDestino().getMonedaId()).collect(Collectors.toList()));

        paises.forEach(x -> tipoCambios.stream().filter(tc -> Objects.equals(tc.getMonedaDestino().getMonedaId(),
                x.getMoneda().getMonedaId())).findFirst().ifPresent(x::setTipoCambio));

        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    /*
    public ResponseEntity<TipoCambio> obtenerTipoCambio(BigInteger monedaId, BigInteger monedaDestinoId) {

        Optional<TipoCambio> tipoCambio = tipoCambioService.findByMonedaOrigen_MonedaIdIsAndMonedaDestino_MonedaIdIs(monedaId, monedaDestinoId);;

        if(!tipoCambio.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tipoCambio.get(), HttpStatus.OK);
    }*/


}
