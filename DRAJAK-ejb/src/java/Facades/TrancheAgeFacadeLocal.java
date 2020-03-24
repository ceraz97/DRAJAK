/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TrancheAge;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TrancheAgeFacadeLocal {

    void create(TrancheAge trancheAge);

    void edit(TrancheAge trancheAge);

    void remove(TrancheAge trancheAge);

    TrancheAge find(Object id);

    List<TrancheAge> findAll();

    List<TrancheAge> findRange(int[] range);

    int count();

    TrancheAge CreerTrancheAge(String libelle, int minAge, int maxAge);

    List<TrancheAge> ListerAllTrancheAge();

    TrancheAge RechercherTrancheAgeParLibelle(String libelle);
    
}
