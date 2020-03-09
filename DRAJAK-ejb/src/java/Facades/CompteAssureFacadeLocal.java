/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface CompteAssureFacadeLocal {

    void create(CompteAssure compteAssure);

    void edit(CompteAssure compteAssure);

    void remove(CompteAssure compteAssure);

    CompteAssure find(Object id);

    List<CompteAssure> findAll();

    List<CompteAssure> findRange(int[] range);

    int count();
    
}
