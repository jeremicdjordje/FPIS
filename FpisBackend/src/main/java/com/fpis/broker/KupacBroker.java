/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.broker;

import com.fpis.Kupac;
import com.fpis.Adresa;
import com.fpis.Mesto;
import com.fpis.Ulica;
import com.fpis.dto.KupacDTO;
import com.fpis.repository.AdresaRepozitorijum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fpis.repository.KupacRepozitorijum;
import com.fpis.repository.MestoRepozitorijum;
import com.fpis.repository.UlicaRepozitorijum;
import java.util.Optional;

/**
 *
 * @author Djole
 */
@Component
public class KupacBroker {

    @Autowired
    KupacRepozitorijum kupacRepozitorijum;

    @Autowired
    UlicaRepozitorijum ulicaRepozitorijum;

    @Autowired
    MestoRepozitorijum mestoRepozitorijum;

    @Autowired
    AdresaRepozitorijum adresaRepozitorijum;

    public List<Kupac> vratiKupce() {
        return (List<Kupac>) kupacRepozitorijum.findAll();
    }

    public Kupac pronadjiKupcaPoPibu(Integer pib) {
        Optional<Kupac> kupac = (Optional<Kupac>) kupacRepozitorijum.findById(pib);
        return kupac.isPresent() == true ? kupac.get() : null;
    }

    public String unesiKupca(Integer pib, String naziv, String nazivMesta, String nazivUlice, String brojUlice, String telefon, String email) {
        Optional<Kupac> pronadjeniKupac = kupacRepozitorijum.findById(pib);
        if (pronadjeniKupac.isPresent() == true) {
            return "Kupac sa pibom " + pib + " vec postoji!";
        }
        Ulica ulica = ulicaRepozitorijum.findByNaziv(nazivUlice);
        Mesto mesto = mestoRepozitorijum.findByNaziv(nazivMesta);
        Adresa pronadjenaAdresa = adresaRepozitorijum.findByBroj(brojUlice);
        if (pronadjenaAdresa == null) {
            Adresa adresa = new Adresa(mesto, ulica, brojUlice);
            pronadjenaAdresa = adresaRepozitorijum.save(adresa);
        }
        Kupac kupac = new Kupac(pib, naziv, telefon, email, pronadjenaAdresa);
        kupacRepozitorijum.save(kupac);
        return "Kupac uspesno unet";
    }

    public String dodajKupca(KupacDTO kupac) {
        Optional<Kupac> pronadjeniKupac = kupacRepozitorijum.findById(kupac.getPib());
        if (pronadjeniKupac.isPresent() == true) {
            return "Kupac sa pibom " + kupac.getPib() + " vec postoji!";
        }
        Ulica ulica = ulicaRepozitorijum.findByNaziv(kupac.getUlica());
        Mesto mesto = mestoRepozitorijum.findByNaziv(kupac.getMesto());
        Adresa pronadjenaAdresa = adresaRepozitorijum.findByBroj(kupac.getBroj());
        if (pronadjenaAdresa == null) {
            Adresa adresa = new Adresa(mesto, ulica, kupac.getBroj());
            pronadjenaAdresa = adresaRepozitorijum.save(adresa);
        }
        Kupac k = new Kupac(kupac.getPib(), kupac.getNaziv(), kupac.getTelefon(), kupac.getEmail(), pronadjenaAdresa);
        kupacRepozitorijum.save(k);
        return "Kupac uspesno unet";

    }

    public String azurirajKupca(KupacDTO k) {
        Ulica ulica = ulicaRepozitorijum.findByNaziv(k.getUlica());
        Mesto mesto = mestoRepozitorijum.findByNaziv(k.getMesto());
        Adresa pronadjenaAdresa = adresaRepozitorijum.findByBroj(k.getBroj());
        if (pronadjenaAdresa == null) {
            Adresa adresa = new Adresa(mesto, ulica, k.getBroj());
            pronadjenaAdresa = adresaRepozitorijum.save(adresa);
        }
        Kupac kupac = new Kupac(k.getPib(), k.getNaziv(), k.getTelefon(), k.getEmail(), pronadjenaAdresa);
        kupacRepozitorijum.save(kupac);
        return "Kupac uspesno izmenjen";
    }

    public String azurirajK(Kupac kupac) {
        Ulica ulica = ulicaRepozitorijum.findByNaziv(kupac.getAdresa().getUlica().getNaziv());
        Mesto mesto = mestoRepozitorijum.findByNaziv(kupac.getAdresa().getMesto().getNaziv());
        Adresa pronadjenaAdresa = adresaRepozitorijum.findByBroj(kupac.getAdresa().getBroj());
        if (pronadjenaAdresa == null) {
            Adresa adresa = new Adresa(mesto, ulica, kupac.getAdresa().getBroj());
            pronadjenaAdresa = adresaRepozitorijum.save(adresa);
        }
        Kupac k = new Kupac(kupac.getPib(), kupac.getNaziv(), kupac.getTelefon(), kupac.getEmail(), pronadjenaAdresa);
        kupacRepozitorijum.save(k);
        return "Kupac uspesno azuriran";
    }

    public String izbrisiKupca(Integer pib) {
        Kupac kupac = pronadjiKupcaPoPibu(pib);
        if (kupac == null) {
            return "Trazeni kupac sa pib-om " + pib + " ne postoji u bazi, unesite novi pib";
        }
        kupacRepozitorijum.deleteById(pib);
        return "Kupac sa pib-om " + pib + " uspesno obrisan";
    }

}
