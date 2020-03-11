/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteEmploye;
import Enum.Genre;
import Enum.StatutPersonne;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface CompteEmployeFacadeLocal {

    void create(CompteEmploye compteEmploye);

    void edit(CompteEmploye compteEmploye);

    void remove(CompteEmploye compteEmploye);

    CompteEmploye find(Object id);

    List<CompteEmploye> findAll();

    List<CompteEmploye> findRange(int[] range);

    int count();
    
    CompteEmploye CreerCompteEmploye(String tel, String adr, String nom, String prenom, Genre genre, Date Dob, StatutPersonne statutPersonne);
    
    CompteEmploye AuthentifierCompteEmploye(String login, String mdp);
    
    void ModifierCompteEmploye(CompteEmploye ce);
            
    void SupprimerCompteEmploye(CompteEmploye ce);
    
    List ListerAllCompteEmploye();
    
    CompteEmploye RechercherEmploye(String login);
    
}
