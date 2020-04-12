/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.AyantDroit;
import Entity.CompteEmploye;
import Entity.Contrat;
import Entity.ContratCollectif;
import Entity.ContratIndividuel;
import Entity.DomaineProduit;
import Entity.Evenement;
import Entity.Fichier;
import Entity.Garantie;
import Entity.Modules;
import Entity.Particulier;
import Entity.PersonneMorale;
import Entity.Produit;
import Entity.Transactions;
import Entity.TypeAyantDroit;
import Entity.TypeFichier;
import Entity.TypeModule;
import Entity.TypeRemboursement;
import Enum.Genre;
import Enum.Role;
import Enum.StatutContrat;
import Enum.StatutPersonne;
import Enum.StatutTransaction;
import Enum.TypeContrat;
import Enum.TypeProduit;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.transaction.Transaction;

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

    List ListerAllParticulier();

    List ListerAllPersonneMorale();

    CompteEmploye CreerCompteEmploye(String login, String mdp, String nom, String prenom, Genre genre, Date Dob, String email, String tel, String adr, Role role, StatutPersonne statutPersonne);

    List<Produit> afficherLesProduits();

    List<Modules> afficherLesModules();

    List<Garantie> afficherLesGaranties();

    Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr);

    PersonneMorale CreerPersonneMorale(String raisonSociale, String nSiret, String nSiren, String login, String mdp, String email);

    Produit CreerProduit(TypeProduit typeProduit, String libelle, double fiscalite, DomaineProduit cleDomaineProduit, List<Modules> lesModules);

    DomaineProduit AffecterDomaineAProduit(String libelle);

    Modules RechercherModuleParId(Long Id);

    Garantie RechercherGarantieParId(Long Id);

    TypeModule AffecterTypeAModule(String libelle);

    Modules CreerModule(String libelle, TypeModule typemodule, List<Garantie> listeGarantie);

    List<TypeRemboursement> afficherLesTypesRemboursement();

    TypeRemboursement AffecterTypeAGarantie(String libelle);

    Garantie CreerGarantie(String libelle, TypeRemboursement typeRemboursement);

    ContratIndividuel RechercherContratIndivParId(long idContrat);

    List<Particulier> RechercherListeParticulier(String nSecu);

    List ListerAllTypeAyantDroit();

    Particulier RechercherParticulierParId(long idParticulier);

    AyantDroit CreerAyantDroit(TypeAyantDroit typeAD, Particulier particulier, ContratIndividuel contrat);

    TypeAyantDroit RechercherTypeAyantDroitParId(long idType);

    void SupprimerAyantDroit(AyantDroit AD);

    AyantDroit RechercherAyantDroitParID(long idAD);

    ContratCollectif RechercherContratCollectifParId(long idContrat);

    List<ContratIndividuel> RechercherContratIndividuel();
   
    
    
    
   List<ContratIndividuel>  RechercherContratIndividuelAttente(StatutContrat type);
   
  List <Fichier> RechercherRIBouChargeAttente(TypeFichier Cle);
  
  TypeFichier RechercherTypeRIBouChargeAttente(String Cle);
  
 void ChangementStatutContrat(ContratIndividuel ci);
   
  

    AyantDroit RechercherAyantDroitParCleparticulier(Particulier part, ContratIndividuel contratInd);

    void CreerIdParticulier(Particulier part);
    
    void ChangementStatutRefuserContrat(ContratIndividuel ci);
    
    Fichier RechercherFichierParId(long idContrat);
    
   
    
    void ModifierFichierStatutValide(Long id , String Type);
    
    
    
    void ModifierContratStatutActifIndiv(Long id);
    
    void ModifierContratStatutRefuserIndiv(Long id);
    
    void ModifierContratStatutActifColl(Long id);
    
    void ModifierContratStatutRefuserColl(Long id);
    
    void ModifierGestionnaireAdresse(String num, String rue, String cp, String ville, String pays, CompteEmploye p);
    
    void ModifierGestionnaireTelephone(String num,CompteEmploye p);

    CompteEmploye RechercherGestionnaireParId(Long id);
    
    Evenement CreerEvenement(String libelle, Date dateEvenement, Contrat cleContrat);
    
    Evenement ModifierEvenementRIBValider (ContratIndividuel ci, String libelle, Date d);
    
    void SupprimerEvenement(Evenement AD);
    
    Evenement RechercherEvenementSupprimer(ContratIndividuel ci, String libelle);
    
    List<Fichier>  RechercherFichierRIB(String nom);
    
    
    ContratIndividuel RechercherContratIndivParIdContrat(Contrat Id);
    
    void ModifierFichierNom(String num,Fichier p);
    
    List <Transactions> ListeTransactionAttente(StatutTransaction Cle);
    
    Fichier RechercherFichierParIdTransaction(String idContrat);
    
    Transactions RechercherTransactionParID(long idContrat);
    
    void ModifierTransaction (Transactions s, StatutTransaction st, String l);
    
    
    TypeFichier RechercherFichierLibelle (String t);
    
  List<Fichier> RechercherFichierParIdTransactionRIB(TypeFichier idContrat);
    
   
}
