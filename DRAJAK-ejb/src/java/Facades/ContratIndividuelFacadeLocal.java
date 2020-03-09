/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.ContratIndividuel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ContratIndividuelFacadeLocal {

    void create(ContratIndividuel contratIndividuel);

    void edit(ContratIndividuel contratIndividuel);

    void remove(ContratIndividuel contratIndividuel);

    ContratIndividuel find(Object id);

    List<ContratIndividuel> findAll();

    List<ContratIndividuel> findRange(int[] range);

    int count();
    
}
