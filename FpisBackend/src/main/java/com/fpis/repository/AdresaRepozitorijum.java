/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.repository;

import com.fpis.Adresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Djole
 */
@Repository
public interface AdresaRepozitorijum extends CrudRepository<Adresa, Integer>{
    public Adresa findByBroj(String brojAdrese);
}
