/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Djole
 */
@Entity
public class Zahtev {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int zahtevID;
    private Date datum;

    public Zahtev() {
    }

    public Zahtev(int zahtevID, Date datum) {
        this.zahtevID = zahtevID;
        this.datum = datum;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getZahtevID() {
        return zahtevID;
    }

    public void setZahtevID(int zahtevID) {
        this.zahtevID = zahtevID;
    }

}
