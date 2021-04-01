/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Djole
 */
public class StavkaZahtevDTO {

    
    
    @JsonProperty("rb_stavke")
    private int rb_stavke;
    private String proizvod;
    private Double kolicina;

    public int getRb_stavke() {
        return rb_stavke;
    }

    public void setRb_stavke(int rb_stavke) {
        this.rb_stavke = rb_stavke;
    }

    public String getProizvod() {
        return proizvod;
    }

    public void setProizvod(String proizvod) {
        this.proizvod = proizvod;
    }

    public Double getKolicina() {
        return kolicina;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }

    

    
}
