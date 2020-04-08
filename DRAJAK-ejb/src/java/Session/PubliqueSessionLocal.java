/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.*;
import Enum.ChoixPaiement;
import Enum.Genre;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface PubliqueSessionLocal {

    ContratIndividuel CreerDevis(String libelle, CompteAssure compteA, PersonnePublique persoPublique, CompteEmploye compteE, ObjetGarantie objetGar, Produit prod);

    List<Produit> ListerAllProduits();

    List<Modules> ListerAllModules();

    PersonnePublique CreerPersonnePublique(String nom, String prenom, Genre genre, Date dob, String email, String tel, String adr);

    void AttribuerNomDevis(ContratIndividuel devis);

    Particulier RechercherParticulier(String nSecu);

    TypeModule RechercherTypeModule(String libelle);

    Modules RechercherModules(String libelle, TypeModule typeM);

    TrancheAge RechercherTrancheAgeParLibelle(String libelle);

    ObjetGarantie RechercherObjetGarantieParLibelle(String libelle);

    Garantie RechercherGarantieParLibelle(String libelle);

    TauxGarantie RechercherTauxGarantie(TrancheAge tranche, ObjetGarantie objet, Garantie garantie);
    
    ContratIndividuel RechercherContratIndivParId(long idContrat);

    MemoireTamponPersonne CreerPersonneTampon(String nature, Genre genre, Date date);

    Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr);

    ContratIndividuel CreerContratIndividuelPersonnePublique(String libelle, ChoixPaiement paiement, CompteEmploye cptEmploye, ContratIndividuel recupDevis, CompteAssure cptAssure);

    CompteAssure CreerCompteAssure(String mdp, Particulier particulier, RegimeSocial Regime);

    RegimeSocial RechercherRegimeSocial(String libelle);
    
    AyantDroit CreerAyantDroit(TypeAyantDroit typeAD, Particulier particulier, ContratIndividuel Contrat);

    TypeAyantDroit RechercherTypeAyantDroitParLibelle(String libelle);
}
