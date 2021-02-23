/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpis.repository;

import com.fpis.Mesto;
import com.fpis.Ulica;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Djole
 */
@Repository
public interface UlicaRepozitorijum extends CrudRepository<Ulica, Integer>{
    public Ulica findByNaziv(String nazivUlice);
    public List<Ulica> findAllByMesto(Mesto mesto);
}
