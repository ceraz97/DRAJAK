/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Entity.CompteEmploye;
import Entity.ContratIndividuel;
import Entity.ObjetGarantie;
import Entity.PersonneMorale;
import Entity.PersonnePhysique;
import Entity.PersonnePublique;
import Entity.Produit;
import Enum.ChoixPaiement;
import Enum.Genre;
import Enum.StatutContrat;
import Enum.StatutPersonne;
import Enum.TypeContrat;
import Facades.CompteAssureFacade;
import Facades.CompteAssureFacadeLocal;
import Facades.ContratFacade;
import Facades.ContratIndividuelFacade;
import Facades.ParticulierFacade;
import Facades.PersonneMoraleFacadeLocal;
import Facades.TransactionFacade;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author clementratz
 */
@Stateless
public class AssureSession implements AssureSessionLocal {

    @EJB
    private PersonneMoraleFacadeLocal personneMoraleFacade;

    @EJB
    private CompteAssureFacadeLocal compteAssureFacade;
    
    @EJB
    private ParticulierFacade particulierFacade;

    @EJB
    private ContratFacade contratFacade;

    @EJB
    private TransactionFacade transactionFacade;
    
    @EJB
    private ContratIndividuelFacade contratIndividuel;


    
    @Override
    public CompteAssure RechercherCompteAssurePourConnexion (String login, String mdp) {
        return compteAssureFacade.AuthentifierCompteAssure(login, mdp);
    }

    @Override
    public PersonneMorale RechercherCompteEntreprisePourConnexion(String login, String mdp) {
        return personneMoraleFacade.AuthentifierCompteEntreprise(login, mdp);
    }
    
    
    public String CreationDevis(){
       String message = null;
        return message; 
    }    
    
    public String CreationContratIndividuel(){
       String message = null;
        return message;         
    }
    
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
                ca.setMdp(newMdp);
                compteAssureFacade.ModifierCompteAssure(ca);
                message = "Le mot de passe a été modifié avec succès.";
            }
            else message = "Erreur : Mot de passe trop court, merci d'entrer un mot de passe de plus de 6 caractères.";
        }
        else message = "Erreur : Le login est incorrect. Le mot de passe n'a pas été modifié.";
        return message;      
    }
    
}
