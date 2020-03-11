/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TauxGarantie;
import Entity.ObjetGarantie;
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
public class ObjetGarantieFacade extends AbstractFacade<ObjetGarantie> implements ObjetGarantieFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetGarantieFacade() {
        super(ObjetGarantie.class);
    }

    @Override
    public ObjetGarantie CreerObjetGarantie(String libelle, TauxGarantie txGarantie) {
        ObjetGarantie objetGarantieInstance= new ObjetGarantie ();
        objetGarantieInstance.setLibelleTypePopulation(libelle);
        objetGarantieInstance.setCleTauxGarantie(txGarantie);
        getEntityManager().persist(objetGarantieInstance); 
        return objetGarantieInstance;
    }

    @Override
    public List ListerAllObjetGarantie() {
        List listeDesObjetGarantie;
        String tx = "SELECT O FROM ObjetGarantie AS O";
        Query req = getEntityManager().createQuery(tx);
        listeDesObjetGarantie=req.getResultList();
        return listeDesObjetGarantie;
    }

    @Override
    public void ModifierObjetGarantie(ObjetGarantie objetGarantie) {
        getEntityManager().merge(objetGarantie);
    }
    
    
    
}
