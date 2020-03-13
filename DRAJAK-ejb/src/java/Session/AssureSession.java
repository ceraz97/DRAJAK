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
import Facades.CompteAssureFacadeLocal;
import Facades.ParticulierFacadeLocal;
import Facades.PersonneMoraleFacadeLocal;
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
    private ParticulierFacadeLocal particulierFacade;

    @EJB
    private PersonneMoraleFacadeLocal personneMoraleFacade;

    @EJB
    private CompteAssureFacadeLocal compteAssureFacade;
    
    @Override
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
    
    @Override
     public CompteAssure AuthentificationAssure(String login, String mdp) {
        CompteAssure SessConnexion;
        
        SessConnexion=compteAssureFacade.AuthentifierCompteAssure(login, mdp);
        
        return SessConnexion;
    }
    
    @Override
    public CompteAssure RechercherCompteAssurePourConnexion (String login, String mdp) {
        return compteAssureFacade.AuthentifierCompteAssure(login, mdp);
    }

    @Override
    public PersonneMorale RechercherCompteEntreprisePourConnexion(String login, String mdp) {
        return personneMoraleFacade.AuthentifierCompteEntreprise(login, mdp);
    }

    @Override
    public CompteAssure CreerCompteAssure(String email, String mdp, Particulier cleParticulier) {
        return compteAssureFacade.CreerCompteAssure(email, mdp, cleParticulier);
    }
    @Override
    public Particulier CreerParticulier(String tel, String adr, String nom, String prenom, Genre genre, Date Dob, StatutPersonne statutPersonne) {
        return  particulierFacade.CreerParticulier(tel, adr, nom, prenom, genre, Dob, statutPersonne);
    }

    @Override
    public boolean RechercherExistenceAssurePourBDD() {
        boolean vide = true;
        if (particulierFacade.ListerAllParticulier().size() != 0){
            vide = false;
        }
        return vide;
    }
}
