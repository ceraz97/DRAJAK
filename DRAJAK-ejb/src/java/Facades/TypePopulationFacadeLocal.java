/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TauxGarantie;
import Entity.TypePopulation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TypePopulationFacadeLocal {

    void create(TypePopulation typePopulation);

    void edit(TypePopulation typePopulation);

    void remove(TypePopulation typePopulation);

    TypePopulation find(Object id);

    List<TypePopulation> findAll();

    List<TypePopulation> findRange(int[] range);

    int count();

    void CreerTypePopulation(String libelle, TauxGarantie txGarantie);

    List ListTypePopulation();
    
}
