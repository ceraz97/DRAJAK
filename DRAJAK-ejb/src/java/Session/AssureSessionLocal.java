/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.AyantDroit;
import Entity.CompteAssure;
import Entity.CompteEmploye;
import Entity.ContratCollectif;
import Entity.ContratIndividuel;
import Entity.Garantie;
import Entity.MemoireTamponPersonne;
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
import Entity.TypeAyantDroit;
import Entity.TypeModule;
import Enum.ChoixPaiement;
import Enum.Genre;
import Enum.StatutPersonne;
import java.util.Date;
import java.util.List;
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

    Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr);

    boolean RechercherExistenceAssurePourBDD();

    Particulier RechercherParticulier(String nSecu);

    TypeModule RechercherTypeModule(String libelle);

    Modules RechercherModules(String libelle, TypeModule typeM);

    TrancheAge RechercherTrancheAgeParLibelle(String libelle);

    ObjetGarantie RechercherObjetGarantieParLibelle(String libelle);

    Garantie RechercherGarantieParLibelle(String libelle);

    TauxGarantie RechercherTauxGarantie(TrancheAge tranche, ObjetGarantie objet, Garantie garantie);

    ContratIndividuel CreerDevis(String libelle, CompteAssure compteA, PersonnePublique persoPublique, CompteEmploye compteE, ObjetGarantie objetGar, Produit prod);

    PersonnePublique CreerPersonnePublique(String nom, String prenom, Genre genre, Date dateNais, String email, String tel, String adr);

    PersonnePublique RechercherPersonnePublique(String Email);

    List<ContratIndividuel> RechercherListeContratAssure(CompteAssure cptAssure);

    ContratIndividuel RechercherContratIndivParId(long idContrat);

    void ModifierMotDePasse(String mdp, CompteAssure CompteA);

    void ModifierAdresse(String num, String rue, String cp, String ville, String pays, CompteAssure cptA);

    List<Particulier>  RechercherListeParticulier(String nSecu);

    List ListerAllTypeAyantDroit();

    Particulier RechercherParticulierParId(long idParticulier);

    AyantDroit CreerAyantDroit(TypeAyantDroit typeAD, Particulier particulier, ContratIndividuel Contrat);

    TypeAyantDroit RechercherTypeAyantDroitParId(long idType);

    void SupprimerAyantDroit(AyantDroit AD);

    AyantDroit RechercherAyantDroitParId(long idAD);
    
    List<ContratCollectif> RechercherListeContratMorale(PersonneMorale persMorale);
    
    ContratCollectif RechercherContratCollectifParId(long idContrat);

    AyantDroit RechercherAyantDroitParCleparticulier(Particulier part, ContratIndividuel contratInd);

    void CreerIdParticulier(Particulier part);

    List<Modules> ListerAllModules();
    
    void AttribuerNomDevis(ContratIndividuel devis);
    
    MemoireTamponPersonne CreerPersonneTampon(String nature, Genre genre, Date date);
    
    ContratIndividuel CreerContratIndividuel(String libelle, ChoixPaiement paiement, CompteEmploye cptEmploye, ContratIndividuel recupDevis);
}
