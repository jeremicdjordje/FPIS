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
public class Proizvod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int proizvodID;
    private String naziv;
    @ManyToOne
    @JoinColumn(name = "jmID")
    private JedinicaMere jedinicaMere;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, String naziv, JedinicaMere jedinicaMere) {
        this.proizvodID = proizvodID;
        this.naziv = naziv;
        this.jedinicaMere = jedinicaMere;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
