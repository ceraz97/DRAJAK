/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.AyantDroit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface AyantDroitFacadeLocal {

    void create(AyantDroit ayantDroit);

    void edit(AyantDroit ayantDroit);

    void remove(AyantDroit ayantDroit);

    AyantDroit find(Object id);

    List<AyantDroit> findAll();

    List<AyantDroit> findRange(int[] range);

    int count();
    
}
