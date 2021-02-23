/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.rest;

import com.fpis.StavkaPonude;
import com.fpis.broker.StavkaPonudeBroker;
import com.fpis.dto.StavkaZahtevDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Djole
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/stavka-ponude")
public class StavkaPonudeKontroler {

    @Autowired
    StavkaPonudeBroker broker;

    @GetMapping("/vrati-stavke-za-ponudaID")
    public Optional<StavkaPonude> vratiStavkeZaPonudu(Integer ponudaID) {
        return broker.vratiStavkeZaPonudu(ponudaID);
    }

    @PostMapping("/dodaj")
    public String unesiStavku(
            @RequestBody StavkaZahtevDTO stavkaZahtevDTO) {
        return broker.unesiStavku(stavkaZahtevDTO.getProizvod(), stavkaZahtevDTO.getKolicina());
    }

    @PostMapping("/dodaj-stavke")
    public String unesiStavke(
            @RequestBody List<StavkaZahtevDTO> stavke) {
        //ovo nam ne treba, dodato radi testiranja
        return broker.unesiSveStavke(stavke, null) == null ? "Stavke neuspesno azurirane" : "Stavke uspesno dodate";
    }

    @PutMapping("/azuriraj")
    public String azurirajStavku(
            @RequestBody StavkaZahtevDTO stavkaZahtevDTO) {
        return broker.unesiStavku(stavkaZahtevDTO.getProizvod(), stavkaZahtevDTO.getKolicina());
    }

    @PutMapping("/azuriraj-stavke")
    public String azurirajStavke(
            @RequestBody List<StavkaZahtevDTO> stavke) {
        return broker.unesiSveStavke(stavke, null) == null ? "Stavke neuspesno azurirane" : "Stavke uspesno dodate";
    }

    @DeleteMapping("/izbrisi")
    public String obrisiStavku(@RequestParam String nazivProizvoda) {
        return broker.obrisiStavku(nazivProizvoda);
    }
}
