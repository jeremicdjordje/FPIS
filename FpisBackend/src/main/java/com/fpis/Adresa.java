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
public class Adresa {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int adresaID;
    
    @ManyToOne
    @JoinColumn(name="mestoID")
    private Mesto mesto;
    
    @ManyToOne
    @JoinColumn(name="ulicaID")
    private Ulica ulica;
    private String broj;

    public Adresa() {
    }

    public Adresa(Mesto mesto, Ulica ulica, String broj) {
        this.mesto = mesto;
        this.ulica = ulica;
        this.broj = broj;
    }
    
    public int getAdresaID() {
        return adresaID;
    }

    public void setAdresaID(int adresaID) {
        this.adresaID = adresaID;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Ulica getUlica() {
        return ulica;
    }

    public void setUlica(Ulica ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.adresaID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresa other = (Adresa) obj;
        if (this.adresaID != other.adresaID) {
            return false;
        }
        return true;
    }


    
    @Override
    public String toString() {
        return ulica+" "+broj+", "+mesto;
                
    }

}
