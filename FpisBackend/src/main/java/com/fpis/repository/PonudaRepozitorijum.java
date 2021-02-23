/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.repository;

import com.fpis.Ponuda;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Djole
 */
@Repository
public interface PonudaRepozitorijum extends CrudRepository<Ponuda, Integer>{
    
    @Query("SELECT coalesce(max(ponuda.ponudaID), 0) FROM Ponuda ponuda")
    Integer getMaxId();

    public void save(Optional<Ponuda> ponuda);
}
