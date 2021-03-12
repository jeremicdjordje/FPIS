/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class StavkaPonude {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rb_stavke;
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

    public int getRb_stavke() {
        return rb_stavke;
    }

    public void setRb_stavke(int rb_stavke) {
        this.rb_stavke = rb_stavke;
    }

}
