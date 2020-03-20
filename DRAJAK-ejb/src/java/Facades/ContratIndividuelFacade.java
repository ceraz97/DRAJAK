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
        ContratIndividuel contratDevisInstance = new ContratIndividuel ();
        contratDevisInstance.setDateCreation(new Date());
        contratDevisInstance.setDateFin(null);
        contratDevisInstance.setLibelleContrat(libelle);
        contratDevisInstance.setStatut(StatutContrat.Devis);
        contratDevisInstance.setPaiement(null);
        contratDevisInstance.setCleCompteAssure(cleCompteAssure);
        contratDevisInstance.setClePersonnePublique(clePersonnePublique);
        contratDevisInstance.setCleCompteEmploye(cleCompteEmploye);
        contratDevisInstance.setCleObjetGarantie(cleObjetGarantie);
        contratDevisInstance.setCleProduit(cleProduit);
        contratDevisInstance.setType(TypeContrat.Individuel);
        
        getEntityManager().persist(contratDevisInstance);
        return contratDevisInstance;
    } 
    
    
    @Override
    public ContratIndividuel CreerContratCollectif(String libelle, CompteEmploye cleCompteEmploye, ObjetGarantie cleObjetGarantie, Produit cleProduit) {
        ContratIndividuel contratCollectifInstance = new ContratIndividuel ();
        //La date de fin de contrat est égal à la date de création + 365 jours
        Date datFin; 
        Calendar c = Calendar.getInstance(); 
        c.setTime(new Date()); 
        c.add(Calendar.DATE, 365);
        datFin = c.getTime();
        contratCollectifInstance.setDateCreation(new Date());
        contratCollectifInstance.setDateFin(datFin);
        contratCollectifInstance.setLibelleContrat(libelle);
        contratCollectifInstance.setStatut(StatutContrat.Actif);
        contratCollectifInstance.setCleCompteEmploye(cleCompteEmploye);
        contratCollectifInstance.setType(TypeContrat.Collectif);      
        getEntityManager().persist(StatutContrat.Actif);
        return contratCollectifInstance;
    } 
    
    
    @Override
    public ContratIndividuel CreerContratIndividuel( String libelle, ChoixPaiement paiement, CompteEmploye cleCompteEmploye, ContratIndividuel recupDevis) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        contratIndividuelInstance = recupDevis; //récupération des données du devis
        //La date de fin de contrat est égal à la date de création + 365 jours
        Date datFin; 
        Calendar c = Calendar.getInstance(); 
        c.setTime(new Date()); 
        c.add(Calendar.DATE, 365);
        datFin = c.getTime();
        
        contratIndividuelInstance.setDateCreation(new Date());
        contratIndividuelInstance.setDateFin(datFin);
        contratIndividuelInstance.setLibelleContrat(libelle);
        contratIndividuelInstance.setStatut(StatutContrat.Actif);
        contratIndividuelInstance.setPaiement(paiement);
        contratIndividuelInstance.setCleCompteEmploye(cleCompteEmploye);
        
        getEntityManager().persist(contratIndividuelInstance);
        return contratIndividuelInstance;
    }  
    
        @Override
    public ContratIndividuel CreerContratAdhesion( String libelle, ChoixPaiement paiement, CompteEmploye cleCompteEmploye, CompteAssure cleCompteAssure, ObjetGarantie cleObjetGarantie, ContratCollectif cleContratCollectif) {
        ContratIndividuel contratAdhesionInstance = new ContratIndividuel ();

        //La date de fin de contrat est égal à la date de création + 365 jours
        Date datFin; 
        Calendar c = Calendar.getInstance(); 
        c.setTime(new Date()); 
        c.add(Calendar.DATE, 365);
        datFin = c.getTime();
        Produit cleProduit = cleContratCollectif.getCleProduit();
        
        contratAdhesionInstance.setDateCreation(new Date());
        contratAdhesionInstance.setDateFin(datFin);
        contratAdhesionInstance.setLibelleContrat(libelle);
        contratAdhesionInstance.setStatut(StatutContrat.Actif);
        contratAdhesionInstance.setPaiement(paiement);
        contratAdhesionInstance.setCleCompteEmploye(cleCompteEmploye);
        contratAdhesionInstance.setCleCompteAssure(cleCompteAssure);
        contratAdhesionInstance.setCleProduit(cleProduit);
        contratAdhesionInstance.setCleContratCollectif(cleContratCollectif);
        contratAdhesionInstance.setCleObjetGarantie(cleObjetGarantie);
        contratAdhesionInstance.setType(TypeContrat.Individuel);
        getEntityManager().persist(contratAdhesionInstance);
        return contratAdhesionInstance;
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
    

