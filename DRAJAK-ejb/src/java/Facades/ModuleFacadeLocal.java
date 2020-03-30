/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Garantie;
import Entity.Modules;
import Entity.Produit;
import Entity.TypeModule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ModuleFacadeLocal {

    void create(Modules module);

    void edit(Modules module);

    void remove(Modules module);

    Modules find(Object id);

    List<Modules> findAll();

    List<Modules> findRange(int[] range);

    int count();

    Modules CreerModule(String libelle, TypeModule typeModule, List<Garantie> listeGarantie);

    void SupprimerModule(Modules module);

    void ModifierModule(Modules module);

    List<Modules> ListerAllModule();

    Modules RechercherModule(String libelle, TypeModule type);
    
    Modules RechercherModuleId(Long Id);
    
    Modules CreerModules(String libelle, TypeModule typeModules, List<Garantie> listeGarantie);
    

    
}
