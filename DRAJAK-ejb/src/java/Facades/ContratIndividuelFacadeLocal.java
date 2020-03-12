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
import Entity.PersonnePhysique;
import Entity.Produit;
import Enum.ChoixPaiement;
import Enum.StatutContrat;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.Query;

/**
 *
 * @author clementratz
 */
@Local
public interface ContratIndividuelFacadeLocal {

    void create(ContratIndividuel contratIndividuel);

    void edit(ContratIndividuel contratIndividuel);

    void remove(ContratIndividuel contratIndividuel);

    ContratIndividuel find(Object id);

    List<ContratIndividuel> findAll();

    List<ContratIndividuel> findRange(int[] range);

    int count();
    
    ContratIndividuel CreerContratIndividuel(Date datCreation, Date dateFin, String libelle, StatutContrat statut, ChoixPaiement paiement, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, Produit cleProduit, ObjetGarantie cleObjetGarantie);
    
    ContratIndividuel CreerContratAdhesion(Date datCreation, Date dateFin, String libelle, StatutContrat statut, ChoixPaiement paiement, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, Produit cleProduit, ContratCollectif cleContratCollectif, ObjetGarantie cleObjetGarantie);
            
    ContratIndividuel CreerDevis(Date datCreation, String libelle, CompteAssure cleCompteAssure, PersonnePhysique clePersonnePhysique, Produit cleProduit, ObjetGarantie cleObjetGarantie);
    
    void ModifierContratIndividuel(ContratIndividuel contratIndividuel);
        
    void SupprimerContratIndividuel(ContratIndividuel contratIndividuel);
    
   List<ContratIndividuel> ListerAllContratIndividuel();
}
