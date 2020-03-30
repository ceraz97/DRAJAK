/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.AyantDroit;
import Entity.CompteEmploye;
import Entity.ContratIndividuel;
import Entity.DomaineProduit;
import Entity.Garantie;
import Entity.Modules;
import Entity.Particulier;
import Entity.PersonneMorale;
import Entity.Produit;
import Entity.TypeAyantDroit;
import Entity.TypeModule;
import Entity.TypeRemboursement;
import Enum.Genre;
import Enum.Role;
import Enum.StatutPersonne;
import Enum.TypeProduit;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface GestionSessionLocal {

    CompteEmploye RechercherCompteEmployePourConnexion(String login, String mdp);

    void AjouterDonnee();

    Boolean VerificationDonne();

    List ListerAllCompteEmploye();
    
    CompteEmploye CreerCompteEmploye(String login, String mdp, String nom, String prenom, Genre genre, Date Dob, String email, String tel, String adr, Role role, StatutPersonne statutPersonne);
    List<Produit> afficherLesProduits();
    List<Modules> afficherLesModules();
    List<Garantie> afficherLesGaranties();
    
    List ListerAllParticulier();
    
    List ListerAllPersonneMorale();
    
    Particulier CreerParticulier (String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr);
    
    PersonneMorale CreerPersonneMorale(String raisonSociale, String nSiret, String nSiren, String login, String mdp, String email);

    Produit CreerProduit(TypeProduit typeProduit, String libelle, double fiscalite, DomaineProduit cleDomaineProduit, List<Modules> lesModules);

    DomaineProduit AffecterDomaineAProduit (String libelle) ;
    
    Modules RechercherModuleParId (Long Id);

     Garantie RechercherGarantieParId (Long Id);
     
     TypeModule AffecterTypeAModule(String libelle);
     
     Modules CreerModule( String libelle,TypeModule typemodule, List<Garantie> listeGarantie);

     
     List<TypeRemboursement> afficherLesTypesRemboursement();
     
    TypeRemboursement AffecterTypeAGarantie(String libelle);
    
    Garantie CreerGarantie (String libelle, TypeRemboursement typeRemboursement);
     
    

    ContratIndividuel RechercherContratIndivParId(long idContrat);




    
    

    List<Particulier> RechercherListeParticulier(String nSecu);

    List ListerAllTypeAyantDroit();

    Particulier RechercherParticulierParId(long idParticulier);

    AyantDroit CreerAyantDroit(TypeAyantDroit typeAD, Particulier particulier, ContratIndividuel contrat);

    TypeAyantDroit RechercherTypeAyantDroitParId(long idType);

    void SupprimerAyantDroit(AyantDroit AD);

    AyantDroit RechercherAyantDroitParID(long idAD);

   
   
}
