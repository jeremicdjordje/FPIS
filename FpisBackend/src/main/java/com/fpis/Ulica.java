/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Djole
 */
@Entity
public class Ulica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ulicaID;
    @ManyToOne
    @JoinColumn(name = "mestoID")
    private Mesto mesto;
    private String naziv;

    public Ulica() {
    }

    public Ulica(int ulicaID, Mesto mesto, String naziv) {
        this.ulicaID = ulicaID;
        this.mesto = mesto;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getUlicaID() {
        return ulicaID;
    }

    public void setUlicaID(int ulicaID) {
        this.ulicaID = ulicaID;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
