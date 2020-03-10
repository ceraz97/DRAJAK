/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Module;
import Entity.ModuleGarantie;
import Entity.ProduitModule;
import Entity.TypeModule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ModuleFacadeLocal {

    void create(Module module);

    void edit(Module module);

    void remove(Module module);

    Module find(Object id);

    List<Module> findAll();

    List<Module> findRange(int[] range);

    int count();

    Module CreerModule(String libelle, ProduitModule produitModule, TypeModule typeModule, ModuleGarantie moduleGarantie);

    void SupprimerModule(Module module);

    void ModifierModule(Module module);

    List<Module> ListerAllModule();
    
}
