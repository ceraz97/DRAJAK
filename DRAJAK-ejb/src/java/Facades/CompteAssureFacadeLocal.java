/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.AyantDroit;
import Entity.CompteAssure;
import Entity.Particulier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface CompteAssureFacadeLocal {

    void create(CompteAssure compteAssure);

    void edit(CompteAssure compteAssure);

    void remove(CompteAssure compteAssure);

    CompteAssure find(Object id);

    List<CompteAssure> findAll();

    List<CompteAssure> findRange(int[] range);

    int count();
    
    CompteAssure AuthentifierCompteAssure(String login, String mdp);
    
    CompteAssure CreerCompteAssure(String mdp, Particulier cleParticulier);
            
    void ModifierCompteAssure(CompteAssure ca);
    
    void SupprimerCompteAssure(CompteAssure ca); 
    
    List ListerAllCompteAssure();

    CompteAssure RechercherCompteAssure(String login);
}
