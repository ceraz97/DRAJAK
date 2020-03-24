/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Entity.CompteEmploye;
import Entity.ContratIndividuel;
import Entity.Garantie;
import Entity.Modules;
import Entity.ObjetGarantie;
import Entity.Particulier;
import Entity.PersonneMorale;
import Entity.PersonnePhysique;
import Entity.PersonnePublique;
import Entity.Produit;
import Entity.RegimeSocial;
import Entity.TauxGarantie;
import Entity.TrancheAge;
import Entity.TypeModule;
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

    CompteAssure CreerCompteAssure(String mdp, Particulier cleParticulier, RegimeSocial cleRegimeSocial);

    Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr, StatutPersonne statutPersonne);

    boolean RechercherExistenceAssurePourBDD();

    Particulier RechercherParticulier(String nSecu);

    TypeModule RechercherTypeModule(String libelle);

    Modules RechercherModules(String libelle, TypeModule typeM);

    TrancheAge RechercherTrancheAgeParLibelle(String libelle);

    ObjetGarantie RechercherObjetGarantieParLibelle(String libelle);

    Garantie RechercherGarantieParLibelle(String libelle);

    TauxGarantie RechercherTauxGarantie(TrancheAge tranche, ObjetGarantie objet, Garantie garantie);

    ContratIndividuel CreerDevis(String libelle, CompteAssure compteA, PersonnePublique persoPublique, CompteEmploye compteE, ObjetGarantie objetGar, Produit prod);

}
