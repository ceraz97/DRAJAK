/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.*;
import Enum.ChoixPaiement;
import Enum.StatutContrat;
import Enum.TypeContrat;
import java.util.Calendar;
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
    public ContratIndividuel CreerDevis(String libelle, CompteAssure cleCompteAssure, PersonnePublique clePersonnePublique, CompteEmploye cleCompteEmploye, ObjetGarantie cleObjetGarantie, Produit cleProduit) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        Date datCreation = null;
        datCreation = new Date();
        Date datFin = null;
        StatutContrat statut;
        statut = StatutContrat.Devis;
        TypeContrat type;
        type = TypeContrat.Individuel;
        ChoixPaiement paiement = null;
        
        contratIndividuelInstance.setDateCreation(datCreation);
        contratIndividuelInstance.setDateFin(datFin);
        contratIndividuelInstance.setLibelleContrat(libelle);
        contratIndividuelInstance.setStatut(statut);
        contratIndividuelInstance.setPaiement(paiement);
        contratIndividuelInstance.setCleCompteAssure(cleCompteAssure);
        contratIndividuelInstance.setClePersonnePublique(clePersonnePublique);
        contratIndividuelInstance.setCleCompteEmploye(cleCompteEmploye);
        contratIndividuelInstance.setCleObjetGarantie(cleObjetGarantie);
        contratIndividuelInstance.setCleProduit(cleProduit);
        contratIndividuelInstance.setType(type);
        
        getEntityManager().persist(contratIndividuelInstance);
        return contratIndividuelInstance;
    } 
    
    
    @Override
    public ContratIndividuel CreerContratCollectif(String libelle, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, ObjetGarantie cleObjetGarantie, Produit cleProduit) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        PersonnePublique clePersonnePublique = null;
        Date datCreation = null;
        datCreation = new Date();
        //La date de fin de contrat est égal à la date de création + 365 jours
        Date datFin; 
        Calendar c = Calendar.getInstance(); 
        c.setTime(datCreation); 
        c.add(Calendar.DATE, 365);
        datFin = c.getTime();
        
        StatutContrat statut;
        statut = StatutContrat.Actif;
        TypeContrat type;
        type = TypeContrat.Collectif;
        ChoixPaiement paiement =null;
        
        contratIndividuelInstance.setDateCreation(datCreation);
        contratIndividuelInstance.setDateFin(datFin);
        contratIndividuelInstance.setLibelleContrat(libelle);
        contratIndividuelInstance.setStatut(statut);
        contratIndividuelInstance.setPaiement(paiement);
        contratIndividuelInstance.setCleCompteAssure(cleCompteAssure);
        contratIndividuelInstance.setClePersonnePublique(clePersonnePublique);
        contratIndividuelInstance.setCleCompteEmploye(cleCompteEmploye);
        contratIndividuelInstance.setType(type);
        
        getEntityManager().persist(contratIndividuelInstance);
        return contratIndividuelInstance;
    } 
    
    
    @Override
    public ContratIndividuel CreerContratIndividuel( String libelle, ChoixPaiement paiement, CompteEmploye cleCompteEmploye, ContratIndividuel recupDevis) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        contratIndividuelInstance = recupDevis; //récupération des données du devis
        
        Date datCreation = null;
        datCreation = new Date();
        //La date de fin de contrat est égal à la date de création + 365 jours
        Date datFin; 
        Calendar c = Calendar.getInstance(); 
        c.setTime(datCreation); 
        c.add(Calendar.DATE, 365);
        datFin = c.getTime();
        
        StatutContrat statut;
        statut = StatutContrat.Actif;
        
        contratIndividuelInstance.setDateCreation(datCreation);
        contratIndividuelInstance.setDateFin(datFin);
        contratIndividuelInstance.setLibelleContrat(libelle);
        contratIndividuelInstance.setStatut(statut);
        contratIndividuelInstance.setPaiement(paiement);
        contratIndividuelInstance.setCleCompteEmploye(cleCompteEmploye);
        
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
    

