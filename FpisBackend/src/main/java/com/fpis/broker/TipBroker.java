/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.broker;

import com.fpis.TipPlacanja;
import com.fpis.repository.TipRepozitorijum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Djole
 */
@Component
public class TipBroker {

    @Autowired
    TipRepozitorijum tipRepozitorijum;

    public List<TipPlacanja> sviTipovi() {
        return (List<TipPlacanja>) tipRepozitorijum.findAll();
    }

}
