/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteEmploye;
import Entity.Particulier;
import Entity.PersonnePublique;
import Entity.RegimeSocial;
import Enum.Genre;
import Enum.Role;
import Enum.StatutPersonne;
import Facades.CompteAssureFacadeLocal;
import Facades.CompteEmployeFacadeLocal;
import Facades.ParticulierFacadeLocal;
import Facades.PersonnePubliqueFacade;
import Facades.RegimeSocialFacadeLocal;
import java.util.Date;
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

    @EJB
    private CompteAssureFacadeLocal compteAssureFacade;
    
    @EJB
    private RegimeSocialFacadeLocal regimeSocialFacade;
    
    @Override
    public CompteEmploye RechercherCompteEmployePourConnexion(String login, String mdp) {
        return compteEmployeFacade.AuthentifierCompteEmploye(login, mdp);
    }

    @Override
    public void AjouterDonnee() {
       Genre neutre, femme, homme = null;
       neutre= Genre.Neutre; femme= Genre.Femme; homme= Genre.Homme;
       String mois = "1000"; String jour = "50";
       Double plafMois = Double.parseDouble(mois);
       Double plafJour = Double.parseDouble(jour);
       StatutPersonne sp = null;
       sp = StatutPersonne.Actif;
       Role role = null;
       role = Role.Administrateur;
       Date d = new Date();
       personnePubliqueFacade.CreerPersonnePublique("Alexandre", "Tristan", neutre,d , "1964569123458", "Tristan.alexandre@yopmail.com", "0666666666", "128 Avenue Espariat", sp);
       compteEmployeFacade.CreerCompteEmploye("Drajak", "admin","Clement","Ratz",homme,d,"Clement.ratz@yopmail.com","0707070707","QuelquespartdansLyon",role,sp);
       particulierFacade.CreerParticulier("Ilkay", "Kutay", femme, d, "1999956841234", "Ilkay.kutay@yopmail.com", "0666778899", "AuStade", sp);
       Particulier p;
       RegimeSocial rs;
       p = particulierFacade.RechercherParticulier("1999956841234");
       regimeSocialFacade.CreerRegimeSocial("Régime Général", plafMois, plafJour);
       rs = regimeSocialFacade.RechercherRegimeSocial("Régime Général");
       compteAssureFacade.CreerCompteAssure("assure", p, rs);
    }
    
    
}
