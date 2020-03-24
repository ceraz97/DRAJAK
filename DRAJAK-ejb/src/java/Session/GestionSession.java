/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Entity.CompteEmploye;
import Entity.ContratCollectif;
import Entity.ContratIndividuel;
import Entity.DomaineProduit;
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
import Entity.TypeFichier;
import Entity.TypeModule;
import Entity.TypeRemboursement;
import Enum.Genre;
import Enum.Role;
import Enum.StatutPersonne;
import Enum.TypeProduit;
import Facades.CompteAssureFacadeLocal;
import Facades.CompteEmployeFacadeLocal;
import Facades.ContratCollectifFacadeLocal;
import Facades.ContratIndividuelFacadeLocal;
import Facades.DomaineProduitFacadeLocal;
import Facades.EvenementFacadeLocal;
import Facades.FichierFacadeLocal;
import Facades.GarantieFacadeLocal;
import Facades.ModuleFacadeLocal;
import Facades.ObjetGarantieFacadeLocal;
import Facades.ParticulierFacadeLocal;
import Facades.PersonneMoraleFacadeLocal;
import Facades.PersonnePubliqueFacade;
import Facades.PersonnePubliqueFacadeLocal;
import Facades.ProduitFacadeLocal;
import Facades.RegimeSocialFacadeLocal;
import Facades.TauxGarantieFacadeLocal;
import Facades.TrancheAgeFacadeLocal;
import Facades.TypeFichierFacadeLocal;
import Facades.TypeModuleFacadeLocal;
import Facades.TypeRemboursementFacadeLocal;
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
public class GestionSession implements GestionSessionLocal {

    @EJB
    private ParticulierFacadeLocal particulierFacade;

    @EJB
    private PersonnePubliqueFacadeLocal personnePubliqueFacade;

    @EJB
    private PersonneMoraleFacadeLocal personneMoraleFacade;

    @EJB
    private CompteEmployeFacadeLocal compteEmployeFacade;

    @EJB
    private CompteAssureFacadeLocal compteAssureFacade;

    @EJB
    private ContratIndividuelFacadeLocal contratIndividuelFacade;

    @EJB
    private ContratCollectifFacadeLocal contratCollectifFacade;

    @EJB
    private RegimeSocialFacadeLocal regimeSocialFacade;

    @EJB
    private FichierFacadeLocal fichierFacade;

    @EJB
    private TypeFichierFacadeLocal typeFichierFacade;

    @EJB
    private EvenementFacadeLocal evenementFacade;

    @EJB
    private DomaineProduitFacadeLocal domaineProduitFacade;

    @EJB
    private ProduitFacadeLocal produitFacade;

    @EJB
    private TypeModuleFacadeLocal typeModuleFacade;

    @EJB
    private ModuleFacadeLocal moduleFacade;

    @EJB
    private TypeRemboursementFacadeLocal typeRemboursementFacade;

    @EJB
    private GarantieFacadeLocal garantieFacade;

    @EJB
    private TrancheAgeFacadeLocal trancheAgeFacade;

    @EJB
    private TauxGarantieFacadeLocal tauxGarantieFacade;

    @EJB
    private ObjetGarantieFacadeLocal objetGarantieFacade;

    @Override
    public CompteEmploye RechercherCompteEmployePourConnexion(String login, String mdp) {
        return compteEmployeFacade.AuthentifierCompteEmploye(login, mdp);
    }

    @Override
    public void AjouterDonnee() {

        Particulier pa;
        PersonneMorale pm;
        RegimeSocial rs;
        CompteEmploye ce;
        TypeFichier tf;
        CompteAssure ca;
        PersonnePublique pp;
        ContratIndividuel ci;
        ContratCollectif cc;
        ObjetGarantie og;
        TrancheAge ta;
        TauxGarantie tg;
        TypeProduit tp;
        DomaineProduit dm;
        Produit pr;
        TypeModule tm;
        Modules md;
        TypeRemboursement tr;
        Garantie gr;
        List listG;
        List listM;

        StatutPersonne sp;
        sp = StatutPersonne.Actif;
        Role role;
        role = Role.Administrateur;
        TypeProduit typeP = TypeProduit.Individuel;
        Blob blob = null;
        Genre neutre, femme, homme;
        neutre = Genre.Autre;
        femme = Genre.Femme;
        homme = Genre.Homme;

        String mois = "1000", jour = "50";
        Double plafMois = Double.parseDouble(mois);
        Double plafJour = Double.parseDouble(jour);
        String maxR = "5000", tarif = "20", fisc = "0.137";
        Double maxRemb = Double.parseDouble(maxR);
        Double tarifCot = Double.parseDouble(tarif);
        Double fiscalite = Double.parseDouble(fisc);
        Date d = new Date();
        int min = 20, max = 35;

        pp = personnePubliqueFacade.CreerPersonnePublique("Alexandre", "Tristan", neutre, d, "1964569123458", "Tristan.alexandre841200@yopmail.com", "0666666666", "128 Avenue Espariat", sp);

        ce = compteEmployeFacade.CreerCompteEmploye("Drajak", "admin", "Ratz", "Clement", homme, d, "Clement.ratz0@yopmail.com", "0707070707", "QuelquespartdansLyon", role, sp);
        compteEmployeFacade.CreerID(ce);

        pa = particulierFacade.CreerParticulier("Kutay", "Ilkay", femme, d, "1999956841234", "Ilkay.kutay@yopmail.com", "0666778899", "AuStade", sp);
        particulierFacade.CreerID(pa);

        rs = regimeSocialFacade.CreerRegimeSocial("Régime Général", plafMois, plafJour);
        ca = compteAssureFacade.CreerCompteAssure("assure", pa, rs);

        tf = typeFichierFacade.CreerTypeFichier("jpg");
        fichierFacade.CreerFichier("FichierDeTest", d, blob, tf);

        tr = typeRemboursementFacade.CreerTypeRemboursement("Frais Réel");
        gr = garantieFacade.CreerGarantie("Lunettes", tr);
        listG = garantieFacade.ListerAllGarantie();

        tm = typeModuleFacade.CreerTypeModule("Base");
        md = moduleFacade.CreerModule("Santé base", tm, listG);
        listM = moduleFacade.ListerAllModule();

        dm = domaineProduitFacade.CreerDomaineProduit("Santé");
        pr = produitFacade.CreerProduit(typeP, "Produit Santé Basique", fiscalite, dm, listM);

        og = objetGarantieFacade.CreerObjetGarantie("Vieux");
        ta = trancheAgeFacade.CreerTrancheAge("20-35 ans", min, max);
        tg = tauxGarantieFacade.CreerTauxDeGarantie(maxRemb, tarifCot, ta, og, gr);

        ci = contratIndividuelFacade.CreerDevis("DevisDeTestAssure", ca, null, ce, og, pr);
        contratIndividuelFacade.CreerDevis("DevisDeTestPublique", null, pp, ce, og, pr);
        evenementFacade.CreerEvenement("Test", d, ci);
    }

    @Override
    public List ListerAllCompteEmploye() {
        return compteEmployeFacade.ListerAllCompteEmploye();
    }

    @Override
    public CompteEmploye CreerCompteEmploye(String login, String mdp, String nom, String prenom, Genre genre, Date Dob, String email, String tel, String adr, Role role, StatutPersonne statutPersonne) {
        return compteEmployeFacade.CreerCompteEmploye(login, mdp, nom, prenom, genre, Dob, email, tel, adr, role, statutPersonne);
    }

}
