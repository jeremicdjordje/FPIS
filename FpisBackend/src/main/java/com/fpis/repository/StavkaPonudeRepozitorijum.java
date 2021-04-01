/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.repository;

import com.fpis.Ponuda;
import com.fpis.Proizvod;
import com.fpis.StavkaPonude;
import com.fpis.dto.StavkaZahtevDTO;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Djole
 */
@Repository
public interface StavkaPonudeRepozitorijum extends CrudRepository<StavkaPonude, Integer>{
   
    
    public StavkaPonude findByProizvod(String nazivProizvoda);
    public StavkaPonude deleteByProizvod(String nazivProizvoda);
    @Transactional
    @Modifying
    @Query(value = "delete from StavkaPonude where ponudaid = :ponudaId")
    public void deleteAllByPonudaId(@Param("ponudaId") int ponudaId);
    
    
}
