/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteEmploye;
import Enum.Genre;
import Enum.Role;
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
    
    CompteEmploye CreerCompteEmploye(String login, String mdp, String nom, String prenom, Genre genre, Date Dob, String email, String tel, String adr, Role role);
    
    CompteEmploye AuthentifierCompteEmploye(String login, String mdp);
    
   
            
    void SupprimerCompteEmploye(CompteEmploye ce);
    
    void CreerID(CompteEmploye ce);
    
    List ListerAllCompteEmploye();
    
    CompteEmploye RechercherEmploye(String login);
    
    void ModifierCompteEmployeTel(CompteEmploye ce, String adresse);
    
    void ModifierCompteEmployeAdresse(CompteEmploye ce, String adresse);
    
    CompteEmploye RechercherEmployeId(Long login);
}
