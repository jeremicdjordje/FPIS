
package com.fpis.broker;


import com.fpis.Kupac;
import com.fpis.Ponuda;
import com.fpis.TipPlacanja;
import com.fpis.Zahtev;
import com.fpis.dto.PonudaDTO;
import com.fpis.repository.KupacRepozitorijum;
import com.fpis.repository.PonudaRepozitorijum;
import com.fpis.repository.StavkaPonudeRepozitorijum;
import com.fpis.repository.TipRepozitorijum;
import com.fpis.repository.ZahtevRepozitorijum;
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
public class PonudaBroker {
    
    @Autowired
    PonudaRepozitorijum ponudaRepozitorijum;
    
    @Autowired
    KupacRepozitorijum kupacRepozitorijum;
    
    @Autowired
    TipRepozitorijum tipRepozitorijum;
    
    @Autowired
    ZahtevRepozitorijum zahtevRepozitorijum;
    
    @Autowired 
    StavkaPonudeRepozitorijum stavkaPonudeRepozitorijum;
    
    @Autowired
    StavkaPonudeBroker stavkaPonudeBroker;

    public List<Ponuda> vratiPonude() {
        return (List<Ponuda>) ponudaRepozitorijum.findAll();
    }

    public Ponuda pronadjiPonuduPoID(Integer id) {
       Optional<Ponuda> ponuda = ponudaRepozitorijum.findById(id);
       return ponuda.isPresent() == true ? ponuda.get() : null;
    }

    public String unesiPonudu(PonudaDTO ponudaDTO) {
        if (ponudaDTO.getListaStavki().isEmpty()) {
            return "Broj stavki mora biti veci od 0";
        }
        Ponuda ponuda = dajPonudu(ponudaDTO);
        Ponuda vracenaPonuda = ponudaRepozitorijum.save(ponuda);
        if (vracenaPonuda == null) {
            return "Ponuda nije sacuvana";
        }
        try {
            stavkaPonudeBroker.unesiSveStavke(ponudaDTO.getListaStavki(), vracenaPonuda);
        } catch (Exception e) {
            ponudaRepozitorijum.delete(vracenaPonuda);
            return "Greska u stavkama ponude";
        }
        return "Ponuda uspesno dodata";
    }

    private Ponuda dajPonudu(PonudaDTO ponudaDTO) {
        Kupac kupac = kupacRepozitorijum.findByNaziv(ponudaDTO.getKupac());
        Zahtev zahtev = zahtevRepozitorijum.findByZahtevID(ponudaDTO.getZahtev());
        TipPlacanja tipPlacanja = tipRepozitorijum.findByNaziv(ponudaDTO.getTip());
        return new Ponuda(ponudaDTO.getPonudaID(),ponudaDTO.getDatum(),tipPlacanja,kupac,zahtev);
    }

    public String obrisiPonudu(Integer ponudaID) {
        Ponuda ponuda = pronadjiPonuduPoID(ponudaID);
        if(ponuda == null){
            return "Ponuda sa brojem ponude: "+ponudaID+" nije pronadjena u bazi";
        }
        ponudaRepozitorijum.deleteById(ponudaID);
        return "Ponuda sa brojem ponude: "+ponudaID+" uspesno obrisana";
    }

    public Integer vratiID() {
        return ponudaRepozitorijum.getMaxId() + 1;
    }

    public String azurirajPonudu(PonudaDTO ponudaDTO, Ponuda p) {
        //azuriraj stavke
        Optional<Ponuda> ponuda = ponudaRepozitorijum.findById(ponudaDTO.getPonudaID());
        stavkaPonudeBroker.azurirajStavke(ponudaDTO.getListaStavki());
        //azuriraj ponudu
        
//        Ponuda p = ponuda1.get().setListaStavki(ponudaDTO.getListaStavki());        
//        Ponuda vracenaPonuda = ponudaRepozitorijum.save(ponuda1.get());

          return "sve ok";
    }

    public String azurirajPonudu(PonudaDTO ponudaDTO) {
        //azuriranje stavki
        Optional<Ponuda> ponuda = ponudaRepozitorijum.findById(ponudaDTO.getPonudaID());
        stavkaPonudeBroker.azurirajStavke(ponudaDTO.getListaStavki());
        //azuriranje ponude
        Ponuda p = dajPonudu(ponudaDTO);
        Ponuda vracenaPonuda = ponudaRepozitorijum.save(p);
      
        return "Ponuda uspesno azurirana";
    }
    
}
