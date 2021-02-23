/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.repository;


import com.fpis.Proizvod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Djole
 */

@Repository
public interface ProizvodRepozitorijum extends CrudRepository<Proizvod, Integer>{
    public Proizvod findByNaziv(String nazivProizvoda);
    public Proizvod deleteByNaziv(String nazivProizvoda);
}
