/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteEmploye;
import Entity.DomaineProduit;
import Entity.Garantie;
import Entity.Modules;
import Entity.Produit;
import Entity.TypeModule;
import Entity.TypeRemboursement;
import Enum.Genre;
import Enum.Role;
import Enum.StatutPersonne;
import Enum.TypeModules;
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
    Garantie CreerGarantie(String libelle, TypeRemboursement typeRemboursement);
    List<TypeRemboursement> afficherLesTypesRemboursement();
    TypeModule CreerTypeModule(String libelle);
    Garantie RechercheGparID(long id);
    Modules CreerModules(String libelle, TypeModules typeModules, List<Garantie> listeGarantie);
    Modules  RechercherModuleParId(long id);
    DomaineProduit AffecterDomaineAProduit(String libelle);
    Produit CreerProduit(TypeProduit typeProduit, String libelle, double fiscalite, DomaineProduit cleDomaineProduit, List<Modules> lesModules);
}
