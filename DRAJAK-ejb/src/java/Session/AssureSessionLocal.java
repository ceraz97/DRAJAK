/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Entity.Particulier;
import Entity.PersonneMorale;
import Enum.Genre;
import Enum.StatutPersonne;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface AssureSessionLocal {

    CompteAssure RechercherCompteAssurePourConnexion (String login, String mdp);

    PersonneMorale RechercherCompteEntreprisePourConnexion(String login, String mdp);

    CompteAssure CreerCompteAssure(String email, String mdp, Particulier cleParticulier);
    
    Particulier CreerParticulier(String tel, String adr, String nom, String prenom, Genre genre, Date Dob, StatutPersonne statutPersonne);

    boolean RechercherExistenceAssurePourBDD();
    
}
