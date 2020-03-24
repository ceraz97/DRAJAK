/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Garantie;
import Entity.ObjetGarantie;
import Entity.TauxGarantie;
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
public class TauxGarantieFacade extends AbstractFacade<TauxGarantie> implements TauxGarantieFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TauxGarantieFacade() {
        super(TauxGarantie.class);
    }

    @Override
    public TauxGarantie CreerTauxDeGarantie(double maxRemboursement, double tarifCotisation, TrancheAge trancheAge, ObjetGarantie cleObjetGarantie, Garantie cleGarantie) {
        TauxGarantie tauxGarantieInstance= new TauxGarantie ();
        tauxGarantieInstance.setMaxRemboursement(maxRemboursement);
        tauxGarantieInstance.setTarifCotisation(tarifCotisation);
        tauxGarantieInstance.setCleTrancheAge(trancheAge);
        tauxGarantieInstance.setCleObjetGarantie(cleObjetGarantie);
        tauxGarantieInstance.setCleGarantie(cleGarantie);
        
        getEntityManager().persist(tauxGarantieInstance);
        return tauxGarantieInstance;
    }

    @Override
    public List ListerAllTauxGarantie() {
        List listeDesTauxGarantie;
        String tx = "SELECT T FROM TauxGarantie AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTauxGarantie=req.getResultList();
        return listeDesTauxGarantie;
    }

    @Override
    public TauxGarantie RechercherTauxGarantie(TrancheAge age, ObjetGarantie objet, Garantie garantie) {
        TauxGarantie tauxGarantieInstance;
        String tx = "SELECT t FROM TauxGarantie AS t WHERE t.cleTrancheAge=:ageTG and t.cleObjetGarantie=:objTG and t.cleGarantie=:gTG";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("ageTG", age);
        req.setParameter("objTG", objet);
        req.setParameter("gTG", garantie);
        tauxGarantieInstance = (TauxGarantie) req.getSingleResult();
        return tauxGarantieInstance;
    }
    
    
}
