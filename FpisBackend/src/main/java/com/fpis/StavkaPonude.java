/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Djole
 */
@Entity
public class StavkaPonude {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rbStavke;
    @ManyToOne
    @JoinColumn(name = "proizvodID")
    private Proizvod proizvod;
    private double kolicina;
    @ManyToOne()
    @JoinColumn(name = "ponudaID")
    private Ponuda ponudaID;

    public StavkaPonude() {
    }

    public StavkaPonude( Proizvod proizvod, double kolicina) {
        this.proizvod = proizvod;
        this.kolicina = kolicina;
        
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @JsonIgnore
    public Ponuda getPonuda() {
        return ponudaID;
    }

    public void setPonuda(Ponuda ponuda) {
        this.ponudaID = ponuda;
    }

}
