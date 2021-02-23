/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.broker;

import com.fpis.Mesto;
import com.fpis.Ulica;
import com.fpis.repository.MestoRepozitorijum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fpis.repository.UlicaRepozitorijum;

/**
 *
 * @author Djole
 */
@Component
public class UlicaBroker {

    @Autowired
    UlicaRepozitorijum ulicaRepozitorijum;
    
    @Autowired
    MestoRepozitorijum mestoRepozitorijum;

    public List<Ulica> vratiUlice() {
        return (List<Ulica>) ulicaRepozitorijum.findAll();
    }

    public List<Ulica> vratiUliceZaMesto(String nazivMesta) {
        Mesto mesto = mestoRepozitorijum.findByNaziv(nazivMesta);
        return ulicaRepozitorijum.findAllByMesto(mesto);
    }
}
