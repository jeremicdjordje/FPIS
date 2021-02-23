/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.rest;

import com.fpis.Kupac;
import com.fpis.broker.KupacBroker;
import com.fpis.dto.KupacDTO;
import java.util.List;
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
@RequestMapping(path = "/kupac")
public class KupacKontroler {

    @Autowired
    KupacBroker broker;

    @GetMapping("/svi")
    public List<Kupac> vratiKupce() {
        return broker.vratiKupce();
    }

    @GetMapping("/pronadji-po-pibu")
    public Kupac pronadjiKupcaPoPibu(@RequestParam Integer pib) {
        return broker.pronadjiKupcaPoPibu(pib);
    }

    @PostMapping("/dodaj")
    public String unesiKupca(@RequestBody KupacDTO kupac) {
        return broker.dodajKupca(kupac);
    }
    
    @PostMapping("/unesi")
    public String dodajKupca(@RequestBody KupacDTO kupac){
        return broker.dodajKupca(kupac);
    }

    @PutMapping("/azuriraj")
    public String azurirajKupca(@RequestBody KupacDTO kupac) {
        return broker.azurirajKupca(kupac);
    }
    
    @PutMapping("/izmeni")
     public String azurirajK(@RequestBody KupacDTO kupac){
            return broker.dodajKupca(kupac);
    }

    @DeleteMapping("/obrisi")
    public String izbrisiKupca(@RequestParam Integer pib) {
        return broker.izbrisiKupca(pib);
    }
}
