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

/**
 *
 * @author Djole
 */
@Entity
public class TipPlacanja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tipPlacanjaID;
    private String naziv;

    public TipPlacanja() {
    }

    public TipPlacanja(int tipPlacanjaID, String naziv) {
        this.tipPlacanjaID = tipPlacanjaID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTipPlacanjaID() {
        return tipPlacanjaID;
    }

    public void setTipPlacanjaID(int tipPlacanjaID) {
        this.tipPlacanjaID = tipPlacanjaID;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
