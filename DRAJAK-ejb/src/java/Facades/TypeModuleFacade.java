/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

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
public class TypeModuleFacade extends AbstractFacade<TypeModule> implements TypeModuleFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeModuleFacade() {
        super(TypeModule.class);
    }

    @Override
    public TypeModule CreerTypeModule(String libelle) {
        TypeModule typeModuleInstance= new TypeModule ();
        typeModuleInstance.setLibelleTypeModule(libelle);
        getEntityManager().persist(typeModuleInstance);
        return typeModuleInstance;
    }

    @Override
    public List ListerAllTypeModule() {
        List listeDesTypeModule;
        String tx = "SELECT T FROM TypeModule AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypeModule=req.getResultList();
        return listeDesTypeModule;
    }

    @Override
    public TypeModule RechercherTypeModule(String libelle) {
        TypeModule typeModuleInstance;
        String tx = "SELECT t FROM TypeModule AS t WHERE t.libelleTypeModule=:LibelleTypeModule";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("LibelleTypeModule", libelle);
        typeModuleInstance = (TypeModule) req.getSingleResult();
        return typeModuleInstance;
    }
    
    @Override
    public TypeModule RechercherTypeModuleParLibelle (String libelle) {
      TypeModule p = null;
      String tx = "SELECT DP FROM TypeModule AS DP WHERE DP.libelleTypeModule=:domaine";
      Query req = getEntityManager().createQuery(tx);
      req.setParameter("domaine",libelle);
      List<TypeModule> result = req.getResultList();
      if (result.size() == 1) {
            p = (TypeModule) result.get(0);
        }
        return p;
    }
    
    
    
}
