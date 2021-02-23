/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.broker;

import com.fpis.Ponuda;
import com.fpis.Proizvod;
import com.fpis.StavkaPonude;
import com.fpis.dto.StavkaZahtevDTO;
import com.fpis.repository.ProizvodRepozitorijum;
import com.fpis.repository.StavkaPonudeRepozitorijum;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Djole
 */
@Component
public class StavkaPonudeBroker {

    @Autowired
    StavkaPonudeRepozitorijum stavkaPonudeRepozitorijum;

    @Autowired
    ProizvodRepozitorijum proizvodRepozitorijum;

    public Optional<StavkaPonude> vratiStavkeZaPonudu(int ponudaID) {
        return stavkaPonudeRepozitorijum.findById(ponudaID);
    }

    public String unesiStavku(String nazivProizvoda, Double kolicina) {

        Proizvod proizvod = proizvodRepozitorijum.findByNaziv(nazivProizvoda);
        if (proizvod == null) {
            return "Stavka nije uspesno uneta";
        }
        StavkaPonude stavka = new StavkaPonude(proizvod, kolicina);
        stavkaPonudeRepozitorijum.save(stavka);
        return "Stavka uspesno uneta";
    }

    public Iterable<StavkaPonude> unesiSveStavke(List<StavkaZahtevDTO> stavke, Ponuda ponuda) {
        List<StavkaPonude> stavkePonude = vratiStavkePonude(stavke, ponuda);
        
        return stavkaPonudeRepozitorijum.saveAll(stavkePonude);
    }

    private List<StavkaPonude> vratiStavkePonude(List<StavkaZahtevDTO> stavke, Ponuda ponuda) {
        List<StavkaPonude> stavkePonude = new ArrayList();
        for (int i = 0; i < stavke.size(); i++) {
            StavkaZahtevDTO stavkaZahtev = stavke.get(i);
            StavkaPonude stavka = new StavkaPonude();
            Proizvod pr = proizvodRepozitorijum.findByNaziv(stavkaZahtev.getProizvod());
            stavka.setProizvod(pr);
            stavka.setKolicina(stavkaZahtev.getKolicina());
            stavka.setPonuda(ponuda);
            stavkePonude.add(stavka);
        }
        return stavkePonude;
    }

    public String azurirajStavku(String nazivProizvoda, Double kolicina) {
        Proizvod proizvod = proizvodRepozitorijum.findByNaziv(nazivProizvoda);
        if (proizvod == null) {
            return "Stavka nije uspesno uneta";
        }
        StavkaPonude stavka = new StavkaPonude(proizvod, kolicina);
        stavkaPonudeRepozitorijum.save(stavka);
        return "Stavka uspesno uneta";
    }

    public String obrisiStavku(String nazivProizvoda) {
        Proizvod pr = proizvodRepozitorijum.findByNaziv(nazivProizvoda);
        StavkaPonude stavka = stavkaPonudeRepozitorijum.findByProizvod(nazivProizvoda);

        if (stavka == null) {
            return "Stavka se ne nalazi u listi";
        }
        stavkaPonudeRepozitorijum.delete(stavka);
        return "Stavka uspesno obrisana";
    }

    public String azurirajStavke(List<StavkaZahtevDTO> stavke) {
             for(int i = 0;i<stavke.size();i++){
              StavkaZahtevDTO stavkaZahtev = stavke.get(i);
              //dodajStavku(stavkaZahtev.getNazivProizvoda(), stavkaZahtev.getKolicina());
              StavkaPonude stavka = new StavkaPonude();
              Proizvod pr = proizvodRepozitorijum.findByNaziv(stavkaZahtev.getProizvod());
              stavka.setProizvod(pr);
              stavka.setKolicina(stavkaZahtev.getKolicina());
              
              stavkaPonudeRepozitorijum.save(stavka);
            }
        return "Stavke uspesno azurirane";
    }

    private String dodajStavku(String nazivProizvoda, Double kolicina) {
        Proizvod proizvod = proizvodRepozitorijum.findByNaziv(nazivProizvoda);
        if (proizvod == null) {
            return "Stavka nije uspesno uneta";
        }
        StavkaPonude stavka = new StavkaPonude(proizvod, kolicina);
        stavkaPonudeRepozitorijum.save(stavka);
        return "Stavka uspesno uneta";
    }

}
