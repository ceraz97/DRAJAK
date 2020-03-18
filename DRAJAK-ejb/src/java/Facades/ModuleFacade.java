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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author clementratz
 */
@Stateless
public class ModuleFacade extends AbstractFacade<Modules> implements ModuleFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModuleFacade() {
        super(Modules.class);
    }

    @Override
    public Modules CreerModule(String libelle, TypeModule typeModule, List<Garantie> listeGarantie) {
        Modules moduleInstance = new Modules ();
        moduleInstance.setLibelleModule(libelle);
        moduleInstance.setCleTypeModule(typeModule);
        moduleInstance.setLesGaranties(listeGarantie);
        getEntityManager().persist(moduleInstance);
        return moduleInstance;
    }

    @Override
    public void SupprimerModule(Modules module) {
        getEntityManager().remove(module);
    }

    @Override
    public void ModifierModule(Modules module) {
        getEntityManager().merge(module);
    }

    @Override
    public List ListerAllModule() {
        List listeDesModules;
        String tx = "SELECT M FROM Modules AS M";
        Query req = getEntityManager().createQuery(tx);
        listeDesModules=req.getResultList();
        return listeDesModules;
    }
    
}
