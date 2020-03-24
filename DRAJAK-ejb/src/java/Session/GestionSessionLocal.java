/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

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
public interface GestionSessionLocal {

    CompteEmploye RechercherCompteEmployePourConnexion(String login, String mdp);

    void AjouterDonnee();
    
    List ListerAllCompteEmploye(); 
    
    CompteEmploye CreerCompteEmploye(String login, String mdp, String nom, String prenom, Genre genre, Date Dob, String email, String tel, String adr, Role role, StatutPersonne statutPersonne);
    

}
