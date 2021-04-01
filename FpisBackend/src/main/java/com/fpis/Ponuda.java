/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Djole
 */
@Entity
public class Ponuda {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int ponudaID;
    @Temporal(TemporalType.DATE)
    private Date datum;
    @ManyToOne
    @JoinColumn(name = "tipPlacanjaID")
    private TipPlacanja tip;
    @ManyToOne
    @JoinColumn(name = "pib")
    private Kupac kupac;
    @OneToOne
    @JoinColumn(name = "zahtevID")
    private Zahtev zahtev;
    @OneToMany(mappedBy= "ponudaID",cascade=CascadeType.ALL)
    private List<StavkaPonude> listaStavki;

    public Ponuda() {
        listaStavki = new ArrayList<>();
    }

    public Ponuda(int ponudaID, Date datum, TipPlacanja tip, Kupac kupac, Zahtev zahtev) {
        this.ponudaID = ponudaID;
        this.datum = datum;
        this.tip = tip;
        this.kupac = kupac;
        this.zahtev = zahtev;
    }

    public List<StavkaPonude> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaPonude> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public int getPonudaID() {
        return ponudaID;
    }

    public void setPonudaID(int ponudaID) {
        this.ponudaID = ponudaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public TipPlacanja getTip() {
        return tip;
    }

    public void setTip(TipPlacanja tip) {
        this.tip = tip;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Zahtev getZahtev() {
        return zahtev;
    }

    public void setZahtev(Zahtev zahtev) {
        this.zahtev = zahtev;
    }

}
