/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.rest;

import com.fpis.Ulica;
import com.fpis.broker.UlicaBroker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Djole
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/ulica")
public class UlicaKontroler {

    @Autowired
    UlicaBroker broker;

    @GetMapping("/sve")
    public List<Ulica> vratiUlice() {
        return broker.vratiUlice();
    }
    @GetMapping("/pronadji-za-mesto")
    public List<Ulica> vratiUliceZaMesto(String naziv) {
        return broker.vratiUliceZaMesto(naziv);
    }

}
