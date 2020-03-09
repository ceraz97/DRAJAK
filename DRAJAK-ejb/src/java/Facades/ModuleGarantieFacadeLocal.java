/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.ModuleGarantie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ModuleGarantieFacadeLocal {

    void create(ModuleGarantie moduleGarantie);

    void edit(ModuleGarantie moduleGarantie);

    void remove(ModuleGarantie moduleGarantie);

    ModuleGarantie find(Object id);

    List<ModuleGarantie> findAll();

    List<ModuleGarantie> findRange(int[] range);

    int count();
    
}
