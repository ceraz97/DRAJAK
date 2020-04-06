/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;


import Entity.*;
import Enum.Genre;
import Facades.*;
import Facades.ProduitFacadeLocal;
import Facades.TauxGarantieFacadeLocal;
import Facades.TrancheAgeFacadeLocal;
import Facades.TypeAyantDroitFacadeLocal;
import Facades.TypeModuleFacadeLocal;
import static java.lang.Long.toString;
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
    public void AttribuerNomDevis(ContratIndividuel devis) {
        long idDevis = devis.getId();
        String idDevisString = Long.toString(idDevis);
        String nomDevis ="Devis_"+idDevisString;
        devis.setLibelleContrat(nomDevis);
        contratIndividuelFacade.ModifierContratIndividuel(devis);
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
}
