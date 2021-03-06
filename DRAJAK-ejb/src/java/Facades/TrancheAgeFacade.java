/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TrancheAge;
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
public class TrancheAgeFacade extends AbstractFacade<TrancheAge> implements TrancheAgeFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrancheAgeFacade() {
        super(TrancheAge.class);
    }

    @Override
    public TrancheAge CreerTrancheAge(String libelle, int minAge, int maxAge) {
        TrancheAge trancheAgeInstance= new TrancheAge ();
        trancheAgeInstance.setLibelletrancheAge(libelle);
        trancheAgeInstance.setMinAge(minAge);
        trancheAgeInstance.setMaxAge(maxAge);
        getEntityManager().persist(trancheAgeInstance);
        return trancheAgeInstance;
    }

    @Override
    public List ListerAllTrancheAge() {
        List listeDesTrancheAge;
        String tx = "SELECT T FROM TrancheAge AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTrancheAge=req.getResultList();
        return listeDesTrancheAge;
    }

    @Override
    public TrancheAge RechercherTrancheAgeParLibelle(String libelle) {
        TrancheAge trancheAgeInstance;
        String tx = "SELECT t FROM TrancheAge AS t WHERE t.libelletrancheAge=:LibelleTranche";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("LibelleTranche", libelle);
        trancheAgeInstance = (TrancheAge) req.getSingleResult();
        return trancheAgeInstance;
    }
    
    
    
}
