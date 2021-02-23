/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import org.springframework.stereotype.Service;

/**
 *
 * @author Djole
 */
@Service
public class StavkaZahtevDTO {
    private String proizvod;
    private Double kolicina;

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
