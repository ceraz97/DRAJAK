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
import Entity.PersonnePublique;
import Entity.Produit;
import Enum.ChoixPaiement;
import Enum.StatutContrat;
import Enum.TypeContrat;
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
    
    public ContratIndividuel CreerDevis(String libelle, CompteAssure cleCompteAssure, PersonnePublique clePersonnePublique, CompteEmploye cleCompteEmploye, ObjetGarantie cleObjetGarantie, Produit cleProduit);
    
    public ContratIndividuel CreerContratCollectif(String libelle, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, ObjetGarantie cleObjetGarantie, Produit cleProduit);
    
    ContratIndividuel CreerContratIndividuel(String libelle, ChoixPaiement paiement, CompteEmploye cleCompteEmploye, ContratIndividuel recupDevis);
    
    void ModifierContratIndividuel(ContratIndividuel contratIndividuel);
        
    void SupprimerContratIndividuel(ContratIndividuel contratIndividuel);
    
   List<ContratIndividuel> ListerAllContratIndividuel();
}
