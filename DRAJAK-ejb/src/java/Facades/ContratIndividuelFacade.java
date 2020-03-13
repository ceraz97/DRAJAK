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
    public ContratIndividuel CreerContrat(Date datCreation, Date datFin, String libelle, StatutContrat statut, TypeContrat type, ChoixPaiement paiement, CompteAssure cleCompteAssure, PersonnePublique clePersonnePublique, CompteEmploye cleCompteEmploye, ContratIndividuel recupDevis) {
        ContratIndividuel contratIndividuelInstance = new ContratIndividuel ();
        contratIndividuelInstance = recupDevis;
        contratIndividuelInstance.setDateCreation(datCreation);
        contratIndividuelInstance.setDateFin(datFin);
        contratIndividuelInstance.setLibelleContrat(libelle);
        contratIndividuelInstance.setStatut(statut);
        contratIndividuelInstance.setPaiement(paiement);
        contratIndividuelInstance.setCleCompteAssure(cleCompteAssure);
        contratIndividuelInstance.setCleCompteEmploye(cleCompteEmploye);
        contratIndividuelInstance.setType(type);
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
    

