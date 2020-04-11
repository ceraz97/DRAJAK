/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;


import Entity.*;
import Enum.ChoixPaiement;
import Enum.Genre;
import Facades.*;
import Facades.ProduitFacadeLocal;
import Facades.TauxGarantieFacadeLocal;
import Facades.TrancheAgeFacadeLocal;
import Facades.TypeAyantDroitFacadeLocal;
import Facades.TypeModuleFacadeLocal;
import static java.lang.Long.toString;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author clementratz
 */
@Stateless
public class PubliqueSession implements PubliqueSessionLocal {

    @EJB
    private EvenementFacadeLocal evenementFacade;

    @EJB
    private FichierFacadeLocal fichierFacade;

    @EJB
    private TypeFichierFacadeLocal typeFichierFacade;

    @EJB
    private TypeAyantDroitFacadeLocal typeAyantDroitFacade;

    @EJB
    private AyantDroitFacadeLocal ayantDroitFacade;

    @EJB
    private RegimeSocialFacadeLocal regimeSocialFacade;

    @EJB
    private CompteAssureFacadeLocal compteAssureFacade;

    @EJB
    private MemoireTamponPersonneFacadeLocal memoireTamponPersonneFacade;

    @EJB
    private ProduitFacadeLocal produitFacade;

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
    
    
    
    @Override
    public ContratIndividuel RechercherContratIndivParId(long idContrat) {
        return contratIndividuelFacade.RechercherContratIndivParId(idContrat);
    }

    
    

    

    @Override
    public ContratIndividuel CreerDevis(String libelle, CompteAssure compteA, PersonnePublique persoPublique, CompteEmploye compteE, ObjetGarantie objetGar, Produit prod) {
        ContratIndividuel contratIndivDevis = new ContratIndividuel();
        contratIndivDevis = contratIndividuelFacade.CreerDevis(libelle, compteA, persoPublique, compteE, objetGar, prod);
        contratIndividuelFacade.AttribuerNomDevis(contratIndivDevis);
        return contratIndivDevis;
    }

    @Override
    public List<Produit> ListerAllProduits() {
        List<Produit> listeProduits = produitFacade.ListerAllProduit();
        return listeProduits;
    }

    @Override
    public List<Modules> ListerAllModules() {
        List<Modules> listeProduits = moduleFacade.ListerAllModule();
        return listeProduits;
    }

    @Override
    public PersonnePublique CreerPersonnePublique(String nom, String prenom, Genre genre, Date dob, String email, String tel, String adr) {
        PersonnePublique p = personnePubliqueFacade.CreerPersonnePublique(nom, prenom, genre, dob, email, tel, adr);
        return p;
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
    public MemoireTamponPersonne CreerPersonneTampon(String nature, Genre genre, Date date) {
        return memoireTamponPersonneFacade.CreerPersonneTampon(nature, genre, date);
    }
    
    @Override
    public Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr) {
        Particulier p = new Particulier ();
        p= particulierFacade.CreerParticulier(nom, prenom, genre, Dob, Nsecu, email, tel, adr);
        particulierFacade.ModifierNumeroAdherent(p);
        return p;
    }

    @Override
    public ContratIndividuel CreerContratIndividuelPersonnePublique(String libelle, ChoixPaiement paiement, CompteEmploye cptEmploye, ContratIndividuel recupDevis,CompteAssure cptAssure) {
        ContratIndividuel contrat = contratIndividuelFacade.CreerContratIndividuelPourPersonnePublique(libelle, paiement, cptEmploye, recupDevis,cptAssure);
        contratIndividuelFacade.AttribuerNomContratIndividuel(contrat);
        return contrat;
    }

    @Override
    public CompteAssure CreerCompteAssure(String mdp, Particulier particulier, RegimeSocial Regime) {
        return compteAssureFacade.CreerCompteAssure(mdp, particulier, Regime);
    }

    @Override
    public RegimeSocial RechercherRegimeSocial(String libelle) {
        return regimeSocialFacade.RechercherRegimeSocial(libelle);
    }
    
    @Override
    public AyantDroit CreerAyantDroit(TypeAyantDroit typeAD, Particulier particulier, ContratIndividuel Contrat) {
        return ayantDroitFacade.CreerAyantDroit(typeAD, particulier, Contrat);
    }

    @Override
    public TypeAyantDroit RechercherTypeAyantDroitParLibelle(String libelle) {
        return typeAyantDroitFacade.RechercherTypeAyantDroitParLibelle(libelle);
    }

    @Override
    public PersonnePublique RechercherPersonnePublique(String email) {
        return personnePubliqueFacade.RechercherPersonnePublique(email);
    }

    @Override
    public TypeFichier RechercherTypeFichierParLibelle(String libelle) {
        return typeFichierFacade.RechercherTypeFichierParLibelle(libelle);
    }

    @Override
    public Fichier CreerFichier(String nom, TypeFichier cleTypeFichier, String chemin, Contrat cleContrat) {
        return fichierFacade.CreerFichier(nom, null, cleTypeFichier, chemin, cleContrat);
    }

    @Override
    public Evenement CreerEvenement(String libelle, ContratIndividuel contrat) {
        Date d = new Date();
        return evenementFacade.CreerEvenement(libelle, d, contrat);
    }
    
    
    
}
