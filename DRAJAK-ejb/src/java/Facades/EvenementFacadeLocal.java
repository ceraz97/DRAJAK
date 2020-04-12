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
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface EvenementFacadeLocal {

    void create(Evenement evenement);

    void edit(Evenement evenement);

    void remove(Evenement evenement);

    Evenement find(Object id);

    List<Evenement> findAll();

    List<Evenement> findRange(int[] range);

    int count();

    Evenement CreerEvenement(String libelle, Date dateEvenement, Contrat cleContrat);
    
    void ModifierProduit(Evenement evenement);

    void SupprimerProduit(Evenement evenement);

    List<Evenement> ListerAllEvenement();
    
    Evenement RechercherEvenementSupprimer(ContratIndividuel ci, String libelle);
    
}
