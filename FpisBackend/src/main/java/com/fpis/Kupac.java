/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Djole
 */
@Entity
public class Kupac {

    @Id
    private int pib;
    private String naziv;
    private String telefon;
    private String email;
    @ManyToOne
    @JoinColumn(name = "adresaID")
    private Adresa adresa;

    public Kupac() {
    }

    public Kupac(int pib, String naziv, String telefon, String email, Adresa adresa) {
        this.pib = pib;
        this.naziv = naziv;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.pib;
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
        final Kupac other = (Kupac) obj;
        if (this.pib != other.pib) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
