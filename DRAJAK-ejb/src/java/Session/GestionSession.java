/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteEmploye;
import Facades.CompteEmployeFacadeLocal;
import Facades.ParticulierFacadeLocal;
import Facades.PersonnePubliqueFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author clementratz
 */
@Stateless
public class GestionSession implements GestionSessionLocal {

    @EJB
    private ParticulierFacadeLocal particulierFacade;
    
    @EJB
    private PersonnePubliqueFacade personnePubliqueFacade;
    
    @EJB
    private CompteEmployeFacadeLocal compteEmployeFacade;

    
    @Override
    public CompteEmploye RechercherCompteEmployePourConnexion(String login, String mdp) {
        return compteEmployeFacade.AuthentifierCompteEmploye(login, mdp);
    }

    @Override
    public void AjouterDonnée() {
       
    }
    
    
}
