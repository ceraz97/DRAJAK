/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Contrat;
import Entity.ContratIndividuel;
import Entity.Evenement;
import java.util.Date;
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
public class EvenementFacade extends AbstractFacade<Evenement> implements EvenementFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvenementFacade() {
        super(Evenement.class);
    }

    @Override
    public Evenement CreerEvenement(String libelle, Date dateEvenement, Contrat cleContrat) {
        Evenement evenementInstance = new Evenement ();
        evenementInstance.setLibelleEvenement(libelle);
        evenementInstance.setDateEvenement(dateEvenement);
        evenementInstance.setCleContrat(cleContrat);
        getEntityManager().persist(evenementInstance);
        return evenementInstance;
    }
    
    @Override
    public void ModifierProduit(Evenement evenement) {
        getEntityManager().merge(evenement);
    }

    @Override
    public void SupprimerProduit(Evenement evenement) {
        getEntityManager().remove(evenement);
    }

    @Override
    public List<Evenement> ListerAllEvenement() {
        List listeDesEvenements;
        String tx = "SELECT E FROM Evenement AS E";
        Query req = getEntityManager().createQuery(tx);
        listeDesEvenements=req.getResultList();
        return listeDesEvenements;
    }
    
     @Override
    public Evenement RechercherEvenementSupprimer(ContratIndividuel ci, String libelle) {
       Evenement  e;
        String txt = "SELECT log FROM Evenement AS log WHERE log.cleContrat=:Login and log.libelleEvenement=:Libelle";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("Login", ci);
        req = req.setParameter("Libelle", libelle);
        e = null;
        List<Evenement> result = req.getResultList();
        if (result.size() == 1) {
            e = (Evenement) result.get(0);
        }
        return e;
    }
     
}
