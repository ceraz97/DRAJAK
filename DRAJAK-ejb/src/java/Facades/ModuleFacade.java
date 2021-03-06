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
    public List<Modules> ListerAllModule() {
        List <Modules>listeDesModules;
        String tx = "SELECT M FROM Modules AS M";
        Query req = getEntityManager().createQuery(tx);
        listeDesModules=req.getResultList();
        return listeDesModules;}
    
    
    
    @Override
    public Modules RechercherModule(String libelle, TypeModule type) {
        Modules modulesInstance;
        String tx = "SELECT m FROM Modules AS m WHERE m.libelleModule=:LibelleModule and m.cleTypeModule=:typeDuModule";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("LibelleModule", libelle);
        req.setParameter("typeDuModule", type);
        modulesInstance = (Modules) req.getSingleResult();
        return modulesInstance;
    }
    
    @Override
    public Modules RechercherModuleId(Long Id) {
        Modules modulesInstance;
        String tx = "SELECT m FROM Modules AS m WHERE m.id=:idmodule";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("idmodule", Id);
        modulesInstance = (Modules) req.getSingleResult();
        return modulesInstance;
    }
    
            @Override
    public Modules CreerModules(String libelle, TypeModule typeModules, List<Garantie> listeGarantie) {
        Modules moduleInstance = new Modules ();
        moduleInstance.setLibelleModule(libelle);
        moduleInstance.setCleTypeModule(typeModules);
        moduleInstance.setLesGaranties(listeGarantie);
        getEntityManager().persist(moduleInstance);
        return moduleInstance;
    }

    
 
}
