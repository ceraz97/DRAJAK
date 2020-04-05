/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.*;
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

}
