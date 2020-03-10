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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author clementratz
 */
@Stateless
public class ModuleFacade extends AbstractFacade<Module> implements ModuleFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModuleFacade() {
        super(Module.class);
    }

    @Override
    public Module CreerModule(String libelle, ProduitModule produitModule, TypeModule typeModule, ModuleGarantie moduleGarantie) {
        Module moduleInstance = new Module ();
        moduleInstance.setLibelleModule(libelle);
        moduleInstance.setCleProduitModule(produitModule);
        moduleInstance.setCleTypeModule(typeModule);
        moduleInstance.setCleModuleGarantie(moduleGarantie);
        getEntityManager().persist(moduleInstance);
        return moduleInstance;
    }

    @Override
    public void SupprimerModule(Module module) {
        getEntityManager().remove(module);
    }

    @Override
    public void ModifierModule(Module module) {
        getEntityManager().merge(module);
    }

    @Override
    public List ListerAllModule() {
        List listeDesModules;
        String tx = "SELECT M FROM Module AS M";
        Query req = getEntityManager().createQuery(tx);
        listeDesModules=req.getResultList();
        return listeDesModules;
    }
    
    
    
    
}
