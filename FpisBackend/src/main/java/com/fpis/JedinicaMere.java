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
public class JedinicaMere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int jmID;
    private String oznaka;
    private String naziv;

    public JedinicaMere() {
    }

    public JedinicaMere(int jmID, String oznaka, String naziv) {
        this.jmID = jmID;
        this.oznaka = oznaka;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getjmID() {
        return jmID;
    }

    public void setjmID(int jmID) {
        this.jmID = jmID;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    @Override
    public String toString() {
        return oznaka; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
