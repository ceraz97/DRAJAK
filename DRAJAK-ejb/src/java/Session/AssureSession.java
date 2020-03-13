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
