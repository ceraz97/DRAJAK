/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.*;
import Enum.ChoixPaiement;
import Enum.StatutContrat;
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
public class ContratIndividuelFacade extends AbstractFacade<ContratIndividuel> implements ContratIndividuelFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratIndividuelFacade() {
        super(ContratIndividuel.class);
    }
    
    @Override
    public ContratIndividuel CreerContratIndividuel(Date datCreation, Date dateFin, String libelle, StatutContrat statut, ChoixPaiement paiement, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, Produit cleProduit, ObjetGarantie cleObjetGarantie) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        contratIndividuelInstance.setDateCreation(datCreation);
        contratIndividuelInstance.setDateFin(dateFin);
        contratIndividuelInstance.setLibelleContrat(libelle);
        contratIndividuelInstance.setStatut(statut);
        contratIndividuelInstance.setPaiement(paiement);
        contratIndividuelInstance.setCleCompteAssure(cleCompteAssure);
        contratIndividuelInstance.setCleCompteEmploye(cleCompteEmploye);
        contratIndividuelInstance.setCleProduit(cleProduit);
        contratIndividuelInstance.setCleObjetGarantie(cleObjetGarantie);
        getEntityManager().persist(contratIndividuelInstance);
        return contratIndividuelInstance;
    }
    @Override
    public ContratIndividuel CreerContratAdhesion(Date datCreation, Date dateFin, String libelle, StatutContrat statut, ChoixPaiement paiement, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, Produit cleProduit, ContratCollectif cleContratCollectif, ObjetGarantie cleObjetGarantie) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        contratIndividuelInstance.setDateCreation(datCreation);
        contratIndividuelInstance.setDateFin(dateFin);
        contratIndividuelInstance.setLibelleContrat(libelle);
        contratIndividuelInstance.setStatut(statut);
        contratIndividuelInstance.setPaiement(paiement);
        contratIndividuelInstance.setCleCompteAssure(cleCompteAssure);
        contratIndividuelInstance.setCleCompteEmploye(cleCompteEmploye);
        contratIndividuelInstance.setCleProduit(cleProduit);
        contratIndividuelInstance.setCleContratCollectif(cleContratCollectif);
        contratIndividuelInstance.setCleObjetGarantie(cleObjetGarantie);
        getEntityManager().persist(contratIndividuelInstance);
        return contratIndividuelInstance;
    }  
    
    @Override
    public ContratIndividuel CreerDevis(Date datCreation, String libelle, CompteAssure cleCompteAssure, PersonnePhysique clePersonnePhysique, Produit cleProduit, ObjetGarantie cleObjetGarantie) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        contratIndividuelInstance.setDateCreation(datCreation);
        contratIndividuelInstance.setLibelleContrat(libelle);
        StatutContrat statut = StatutContrat.Devis;
        contratIndividuelInstance.setStatut(statut);
        contratIndividuelInstance.setCleCompteAssure(cleCompteAssure);
        contratIndividuelInstance.setCleProduit(cleProduit);
        contratIndividuelInstance.setCleObjetGarantie(cleObjetGarantie);
        getEntityManager().persist(contratIndividuelInstance);
        return contratIndividuelInstance;
    }    
    
    
    @Override
    public void ModifierContratIndividuel(ContratIndividuel contratIndividuel) {
        getEntityManager().merge(contratIndividuel);
    }

    @Override
    public void SupprimerContratIndividuel(ContratIndividuel contratIndividuel) {
        getEntityManager().remove(contratIndividuel);
    }

    @Override
    public List<ContratIndividuel> ListerAllContratIndividuel() {
        List listeDesContratsIndivs;
        String tx = "SELECT CI FROM ContratIndividuel AS CI";
        Query req = getEntityManager().createQuery(tx);
        listeDesContratsIndivs=req.getResultList();
        return listeDesContratsIndivs;
    }
    
}
    

