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
import Entity.PersonnePublique;
import Entity.Produit;
import Entity.RegimeSocial;
import Entity.TauxGarantie;
import Entity.TrancheAge;
import Entity.TypeModule;
import Enum.Genre;
import Enum.StatutPersonne;
import Facades.CompteAssureFacadeLocal;
import Facades.ContratIndividuelFacadeLocal;
import Facades.GarantieFacadeLocal;
import Facades.ModuleFacadeLocal;
import Facades.ObjetGarantieFacadeLocal;
import Facades.ParticulierFacadeLocal;
import Facades.PersonneMoraleFacadeLocal;
import Facades.PersonnePubliqueFacadeLocal;
import Facades.TauxGarantieFacadeLocal;
import Facades.TrancheAgeFacadeLocal;
import Facades.TypeModuleFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author clementratz
 */
@Stateless
public class AssureSession implements AssureSessionLocal {

    @EJB
    private PersonnePubliqueFacadeLocal personnePubliqueFacade;

    @EJB
    private ContratIndividuelFacadeLocal contratIndividuelFacade;

    @EJB
    private TauxGarantieFacadeLocal tauxGarantieFacade;

    @EJB
    private GarantieFacadeLocal garantieFacade;

    @EJB
    private ObjetGarantieFacadeLocal objetGarantieFacade;

    @EJB
    private TrancheAgeFacadeLocal trancheAgeFacade;

    @EJB
    private ModuleFacadeLocal moduleFacade;

    @EJB
    private TypeModuleFacadeLocal typeModuleFacade;

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
    public CompteAssure CreerCompteAssure(String mdp, Particulier cleParticulier, RegimeSocial cleRegimeSocial) {
        return compteAssureFacade.CreerCompteAssure(mdp, cleParticulier, cleRegimeSocial);
    }
    @Override
    public Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr, StatutPersonne statutPersonne) {
        return particulierFacade.CreerParticulier(nom, prenom, genre, Dob, Nsecu, email, tel, adr);
    }

    @Override
    public boolean RechercherExistenceAssurePourBDD() {
        boolean vide = true;
        if (particulierFacade.ListerAllParticulier().size() != 0){
            vide = false;
        }
        return vide;
    }

    @Override
    public Particulier RechercherParticulier(String nSecu) {
        Particulier p = particulierFacade.RechercherParticulier(nSecu);
        return p;
    }

    @Override
    public TypeModule RechercherTypeModule(String libelle) {
        TypeModule typeModuleInstance = typeModuleFacade.RechercherTypeModule(libelle);
        return typeModuleInstance;
    }

    @Override
    public Modules RechercherModules(String libelle, TypeModule typeM) {
        Modules moduleInstance = moduleFacade.RechercherModule(libelle, typeM);
        return moduleInstance;
    }

    @Override
    public TrancheAge RechercherTrancheAgeParLibelle(String libelle) {
        TrancheAge trancheAgeInstance = trancheAgeFacade.RechercherTrancheAgeParLibelle(libelle);
        return trancheAgeInstance;
    }

    @Override
    public ObjetGarantie RechercherObjetGarantieParLibelle(String libelle) {
        ObjetGarantie objetInstance = objetGarantieFacade.RechercherObjetGarantieParLibelle(libelle);
        return objetInstance;
    }

    @Override
    public Garantie RechercherGarantieParLibelle(String libelle) {
        Garantie GarantieInstance = garantieFacade.RechercherGarantie(libelle);
        return GarantieInstance;
    }

    @Override
    public TauxGarantie RechercherTauxGarantie(TrancheAge tranche, ObjetGarantie objet, Garantie garantie) {
        TauxGarantie tauxGarantieInstance = tauxGarantieFacade.RechercherTauxGarantie(tranche, objet, garantie);
        return tauxGarantieInstance;
    }

    @Override
    public ContratIndividuel CreerDevis(String libelle, CompteAssure compteA, PersonnePublique persoPublique, CompteEmploye compteE, ObjetGarantie objetGar, Produit prod) {
        ContratIndividuel contratIndivDevis = new ContratIndividuel();
        contratIndivDevis = contratIndividuelFacade.CreerDevis(libelle, compteA, persoPublique, compteE, objetGar, prod);
        return contratIndivDevis;
    }

    @Override
    public PersonnePublique CreerPersonnePublique(String nom, String prenom, Genre genre, Date dateNais, String email, String tel, String adr) {
        PersonnePublique persoPublique = personnePubliqueFacade.CreerPersonnePublique(nom, prenom, genre, dateNais, email, tel, adr);
        return persoPublique;
    }

    @Override
    public PersonnePublique RechercherPersonnePublique(String Email) {
        PersonnePublique persoPublique = personnePubliqueFacade.RechercherPersonnePublique(Email);
        return persoPublique;
    }

    @Override
    public List<ContratIndividuel> RechercherListeContratAssure(CompteAssure cptAssure) {
        List<ContratIndividuel> listecontrat = contratIndividuelFacade.RechercherContratIndividuelParAssure(cptAssure);
        return listecontrat;
    }

    @Override
    public ContratIndividuel RechercherContratIndivParId(long idContrat) {
        return contratIndividuelFacade.RechercherContratIndivParId(idContrat);
    }
    
    
}
