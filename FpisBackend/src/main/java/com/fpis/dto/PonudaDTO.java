/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Djole
 */
public class PonudaDTO {

    Integer ponudaID;
    Date datum;
    String kupac;
    String tip;
    Integer zahtev;
    List<StavkaZahtevDTO> listaStavki;

    public Integer getPonudaID() {
        return ponudaID;
    }

    public void setPonudaID(Integer ponudaID) {
        this.ponudaID = ponudaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac = kupac;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getZahtev() {
        return zahtev;
    }

    public void setZahtev(Integer zahtev) {
        this.zahtev = zahtev;
    }

    public List<StavkaZahtevDTO> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaZahtevDTO> listaStavki) {
        this.listaStavki = listaStavki;
    }

    
    
}
