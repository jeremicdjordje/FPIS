/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.rest;

import com.fpis.Ponuda;
import com.fpis.broker.PonudaBroker;
import com.fpis.dto.PonudaDTO;
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
@RequestMapping(path = "/ponuda")
public class PonudaKontroler {

    @Autowired
    PonudaBroker broker;

    @GetMapping("/sve")
    public List<Ponuda> vratiPonude() {
        return broker.vratiPonude();
    }

    @GetMapping("/pronadji-po-id")
    public Ponuda pronadjiPonuduPoID(@RequestParam Integer id) {
        return broker.pronadjiPonuduPoID(id);
    }

    @PostMapping("/dodaj")
    public String unesiPonudu(@RequestBody PonudaDTO ponuda) {
        return broker.unesiPonudu(ponuda);
    }

    @PutMapping("/azuriraj")
    public String azurirajPonudu(@RequestBody PonudaDTO ponuda) {
        return broker.azurirajPonudu(ponuda);
    }

    @DeleteMapping("/obrisi")
    public String obrisiPonudu(@RequestParam Integer ponudaID) {
        return broker.obrisiPonudu(ponudaID);
    }

    @GetMapping("/vrati-id")
    public Integer vratiID() {
        return broker.vratiID();
    }

}
