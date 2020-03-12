/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Entity.PersonneMorale;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface AssureSessionLocal {

    CompteAssure RechercherCompteAssurePourConnexion (String login, String mdp);

    PersonneMorale RechercherCompteEntreprisePourConnexion(String login, String mdp);
    
}
