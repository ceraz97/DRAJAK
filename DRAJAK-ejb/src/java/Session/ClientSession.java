/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Facades.CompteAssureFacade;
import Facades.ContratFacade;
import Facades.ParticulierFacade;
import Facades.TransactionFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author clementratz
 */
@Stateless
public class ClientSession implements ClientSessionLocal {
    @EJB
    private ParticulierFacade particulierFacade;

    @EJB
    private CompteAssureFacade compteAssureFacade;

    @EJB
    private ContratFacade contratFacade;

    @EJB
    private TransactionFacade transactionFacade;
     
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     public CompteAssure AuthentificationAssure(String login, String mdp) {
        CompteAssure SessConnexion;
        
        SessConnexion=compteAssureFacade.AuthentifierCompteAssure(login, mdp);
        
        return SessConnexion;
    }
     
     public String ChangementMdp(String login, String newMdp, CompteAssure SessConnexion) {
        CompteAssure ca;
        String message = null;
        ca = compteAssureFacade.RechercherCompteAssure(login);
        
        if(SessConnexion == ca){
            if(newMdp.length()>6){
                compteAssureFacade.ModifierCompteAssure(ca);
                message = "Le mot de passe a été modifié avec succès.";
            }
            else message = "Mot de passe trop court, merci d'entrer un mot de passe de plus de 6 caractères.";
        }
        else message = "Le login est incorrect. Le mot de passe n'a pas été modifié.";
        return message;
    }
    
}
