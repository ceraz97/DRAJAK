/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
import Entity.CompteEmploye;
import Entity.ContratCollectif;
import Entity.ContratIndividuel;
import Entity.ObjetGarantie;
import Entity.PersonneMorale;
import Entity.Produit;
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
public class ContratCollectifFacade extends AbstractFacade<ContratCollectif> implements ContratCollectifFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratCollectifFacade() {
        super(ContratCollectif.class);
    }
    
    @Override
    public ContratCollectif CreerContratCollectif(String libelle, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, Produit cleProduit, PersonneMorale clePersonneMorale) {
        ContratCollectif contratCollectifInstance = new ContratCollectif ();
        //La date de fin de contrat est égal à la date de création + 365 jours
        Date datFin; 
        Calendar c = Calendar.getInstance(); 
        c.setTime(new Date()); 
        c.add(Calendar.DATE, 365);
        datFin = c.getTime();
        ChoixPaiement choix = null;
        contratCollectifInstance.setDateCreation(new Date());
        contratCollectifInstance.setDateFin(datFin);
        contratCollectifInstance.setLibelleContrat(libelle);
        contratCollectifInstance.setStatut(StatutContrat.Actif);
        contratCollectifInstance.setPaiement(choix);
        contratCollectifInstance.setType(TypeContrat.Collectif);
        contratCollectifInstance.setCleCompteAssure(cleCompteAssure);
        contratCollectifInstance.setCleCompteEmploye(cleCompteEmploye);
        contratCollectifInstance.setCleProduit(cleProduit);
        contratCollectifInstance.setClePersonneMorale(clePersonneMorale);
        getEntityManager().persist(contratCollectifInstance);
        return contratCollectifInstance;
    }
    
    @Override
    public void ModifierContratCollectif(ContratCollectif contratCollectif) {
        getEntityManager().merge(contratCollectif);
    }

    @Override
    public void SupprimerContratCollectif(ContratCollectif contratCollectif) {
        getEntityManager().remove(contratCollectif);
    }

    @Override
    public List<ContratCollectif> ListerAllContratCollectif() {
        List listeDesContratsCollectifs;
        String tx = "SELECT CC FROM ContratCollectif AS CC";
        Query req = getEntityManager().createQuery(tx);
        listeDesContratsCollectifs=req.getResultList();
        return listeDesContratsCollectifs;
    }
    
}
