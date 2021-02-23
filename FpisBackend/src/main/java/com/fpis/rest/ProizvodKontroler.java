/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.rest;

import com.fpis.Proizvod;
import com.fpis.broker.ProizvodBroker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Djole
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/proizvod")
public class ProizvodKontroler {
    
    @Autowired
    ProizvodBroker broker;
    
    @GetMapping("/svi")
    public List<Proizvod> sviProizvodi(){
        return broker.vratiProizvode();
    }
    
    @GetMapping("/pronadji-po-id")
    public Proizvod pronadjiProizvodPoID(@RequestParam Integer proizvodID) {
        return broker.pronadjiProizvodPoID(proizvodID);
    }
   
    
    
}
