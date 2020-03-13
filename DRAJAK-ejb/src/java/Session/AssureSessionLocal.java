/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Entity.ObjetGarantie;
import Entity.Particulier;
import Entity.PersonneMorale;
import Entity.PersonnePhysique;
import Entity.PersonnePublique;
import Entity.Produit;
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

    CompteAssure RechercherCompteAssurePourConnexion(String login, String mdp);

    PersonneMorale RechercherCompteEntreprisePourConnexion(String login, String mdp);

    
    CompteAssure AuthentificationAssure(String login, String mdp);

    String ChangementMdp(String login, String newMdp, CompteAssure SessConnexion);

    CompteAssure CreerCompteAssure(String mdp, Particulier cleParticulier);

    Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr, StatutPersonne statutPersonne);

    boolean RechercherExistenceAssurePourBDD();

}
