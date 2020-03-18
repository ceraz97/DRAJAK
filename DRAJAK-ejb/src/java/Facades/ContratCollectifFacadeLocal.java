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
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ContratCollectifFacadeLocal {

    void create(ContratCollectif contratCollectif);

    void edit(ContratCollectif contratCollectif);

    void remove(ContratCollectif contratCollectif);

    ContratCollectif find(Object id);

    List<ContratCollectif> findAll();

    List<ContratCollectif> findRange(int[] range);

    int count();
    
    ContratCollectif CreerContratCollectif(String libelle, CompteAssure cleCompteAssure, CompteEmploye cleCompteEmploye, Produit cleProduit, PersonneMorale clePersonneMorale);
    
    void ModifierContratCollectif(ContratCollectif contratCollectif);
    
    void SupprimerContratCollectif(ContratCollectif contratCollectif);
    
    List<ContratCollectif> ListerAllContratCollectif();
}
