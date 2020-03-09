/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.ContratCollectif;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ContratCollectifFacadeLocal {

    void create(ContratCollectif contratCollectif);

    void edit(ContratCollectif contratCollectif);

    void remove(ContratCollectif contratCollectif);

    ContratCollectif find(Object id);

    List<ContratCollectif> findAll();

    List<ContratCollectif> findRange(int[] range);

    int count();
    
}
