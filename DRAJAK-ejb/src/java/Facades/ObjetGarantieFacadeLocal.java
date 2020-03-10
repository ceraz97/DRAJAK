/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TauxGarantie;
import Entity.ObjetGarantie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ObjetGarantieFacadeLocal {

    void create(ObjetGarantie typePopulation);

    void edit(ObjetGarantie typePopulation);

    void remove(ObjetGarantie typePopulation);

    ObjetGarantie find(Object id);

    List<ObjetGarantie> findAll();

    List<ObjetGarantie> findRange(int[] range);

    int count();

    ObjetGarantie CreerObjetGarantie(String libelle, TauxGarantie txGarantie);

    List<ObjetGarantie> ListerAllObjetGarantie();
    
}
