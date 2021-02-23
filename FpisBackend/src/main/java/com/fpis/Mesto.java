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
public class Mesto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mestoID;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int mestoID, String naziv) {
        this.mestoID = mestoID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
