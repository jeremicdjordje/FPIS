/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.broker;

import com.fpis.Mesto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fpis.repository.MestoRepozitorijum;

/**
 *
 * @author Djole
 */
@Component
public class MestoBroker {

    @Autowired
    MestoRepozitorijum mestoRepozitorijum;

    public List<Mesto> vratiMesta() {
        return (List<Mesto>) mestoRepozitorijum.findAll();
    }

}
