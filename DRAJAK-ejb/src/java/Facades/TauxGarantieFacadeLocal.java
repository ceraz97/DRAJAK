/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Garantie;
import Entity.ObjetGarantie;
import Entity.TauxGarantie;
import Entity.TrancheAge;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TauxGarantieFacadeLocal {

    void create(TauxGarantie tauxGarantie);

    void edit(TauxGarantie tauxGarantie);

    void remove(TauxGarantie tauxGarantie);

    TauxGarantie find(Object id);

    List<TauxGarantie> findAll();

    List<TauxGarantie> findRange(int[] range);

    int count();

    TauxGarantie CreerTauxDeGarantie(double maxRemboursement, double tarifCotisation, TrancheAge trancheAge, ObjetGarantie cleObjetGrantie, Garantie cleGarantie);

    List<TauxGarantie> ListerAllTauxGarantie();
    
}
