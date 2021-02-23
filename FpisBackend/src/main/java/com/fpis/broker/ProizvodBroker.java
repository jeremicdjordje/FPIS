/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.broker;

import com.fpis.Proizvod;
import com.fpis.repository.ProizvodRepozitorijum;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Djole
 */
@Component
public class ProizvodBroker {

    @Autowired
    ProizvodRepozitorijum proizvodRepozitorijum;

    public List<Proizvod> vratiProizvode() {
        return (List<Proizvod>) proizvodRepozitorijum.findAll();
    }

    public Proizvod pronadjiProizvodPoID(Integer proizvodID) {
        Optional<Proizvod> proizvod = (Optional<Proizvod>) proizvodRepozitorijum.findById(proizvodID);
        return proizvod.isPresent() == true ? proizvod.get() : null;
    }

    /*public String unesiProizvod(String naziv, int jmID) {
        
    }*/

}
