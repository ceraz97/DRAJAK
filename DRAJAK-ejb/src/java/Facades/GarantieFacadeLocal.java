/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Garantie;
import Entity.ModuleGarantie;
import Entity.TauxGarantie;
import Entity.TypeRemboursement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface GarantieFacadeLocal {

    void create(Garantie garantie);

    void edit(Garantie garantie);

    void remove(Garantie garantie);

    Garantie find(Object id);

    List<Garantie> findAll();

    List<Garantie> findRange(int[] range);

    int count();

    Garantie CreerGarantie(String libelle, ModuleGarantie moduleGarantie, TypeRemboursement typeRemboursement, TauxGarantie tauxGarantie);

    List<Garantie> ListerAllGarantie();
    
}
