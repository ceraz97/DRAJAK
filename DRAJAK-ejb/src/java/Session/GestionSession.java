/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.AyantDroit;
import Entity.CompteAssure;
import Entity.CompteEmploye;
import Entity.Contrat;
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
import Entity.TypeAyantDroit;
import Entity.TypeFichier;
import Entity.TypeModule;
import Entity.TypeRemboursement;
import Entity.TypeTransaction;
import Enum.ChoixPaiement;
import Enum.Genre;
import Enum.Role;
import Enum.StatutContrat;
import Enum.StatutPersonne;
import Enum.StatutTransaction;
import Enum.TypeContrat;
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
import Facades.PersonnePubliqueFacadeLocal;
import Facades.AyantDroitFacadeLocal;
import Facades.ModuleFacade;
import Facades.TypeAyantDroitFacadeLocal;
import Facades.ProduitFacadeLocal;
import Facades.RegimeSocialFacadeLocal;
import Facades.TauxGarantieFacadeLocal;
import Facades.TrancheAgeFacadeLocal;
import Facades.TransactionFacadeLocal;
import Facades.TypeFichierFacadeLocal;
import Facades.TypeModuleFacadeLocal;
import Facades.TypeRemboursementFacadeLocal;
import Facades.TypeTransactionFacadeLocal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

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
    private TypeAyantDroitFacadeLocal typeAyantDroitFacade;

    @EJB
    private AyantDroitFacadeLocal ayantDroitFacade;

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
    private TypeTransactionFacadeLocal typeTransactionFacade;

    @EJB
    private TransactionFacadeLocal transactionFacade;

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

        Particulier pa, paa, pay, paay;
        PersonneMorale pm;
        RegimeSocial rs;
        CompteEmploye ce;
        TypeAyantDroit td;
        TypeFichier tf;
        TypeTransaction tt;
        CompteAssure ca, caa;
        PersonnePublique pp;
        Contrat c;
        ContratIndividuel devisA, devisB;
        ContratCollectif cc;
        TrancheAge ta, tv;
        DomaineProduit dm;
        Produit pr1, pr2;
        TypeModule tmb, tmf;
        TypeRemboursement fr, bd;

        Genre autre, femme, homme;
        autre = Genre.Autre;
        femme = Genre.Femme;
        homme = Genre.Homme;

        Date d20;
        Calendar c20 = Calendar.getInstance();
        c20.setTime(new Date());
        c20.add(Calendar.DATE, -8000);
        d20 = c20.getTime();

        Date d40;
        Calendar c40 = Calendar.getInstance();
        c40.setTime(new Date());
        c40.add(Calendar.DATE, -16000);
        d40 = c40.getTime();
        //PERSONNE PUBLIQUE
        pp = personnePubliqueFacade.CreerPersonnePublique("Alexandre", "Tristan", autre, d20, "Tristan.alexandre841200@yopmail.com", "0666666666", "39,avenue DeLaBas,69006,Lyon,France");
        personnePubliqueFacade.CreerPersonnePublique("Jean", "Eude", autre, d20, "Jean.Eude@yopmail.com", "0666667666", "40,avenue DeLaBas,69006,Lyon,France");


        //PERSONNE MORALE
        /*LogMoral*/ pm = personneMoraleFacade.CreerPersonneMorale("EntrepriseTest", "999999999", "14141414141414", "LogMorale", "MdpMorale", "EntrepriseTest@yopmail.com");

        //COMPTE EMPLOYÉ
        /*LogEmploye*/
        ce = compteEmployeFacade.CreerCompteEmploye("Drajak", "admin", "Ratz", "Clement", homme, d20, "Clement.ratz0@yopmail.com", "0707070707", "66,rue QuelquespartdansLyon,69005,Lyon,France", Role.Administrateur);
        compteEmployeFacade.CreerID(ce);

        //PARTICULIER
        pa = particulierFacade.CreerParticulier("Kutay", "Ilkay", femme, d20, "1999956841234", "Ilkay.kutay@yopmail.com", "0666778899", "21,rue ParLàBas, 69004,Lyon,France");
        pay = particulierFacade.CreerParticulier("Mohamed", "Dja", homme, d20, "19999456841234", "Mohamed.Dja@yopmail.com", "0666668899", "20,lotissement ParIci, 69003,Lyon,France");
        paa = particulierFacade.CreerParticulier("Andreï", "Journet", homme, d40, "1889956841234", "Andreï.Journet@yopmail.com", "0666998899", "19,route PrèsDeParIci,Lyon,France");
        paay = particulierFacade.CreerParticulier("Xin", "Li", homme, d40, "1889445684234", "Xin.Li@yopmail.com", "0666998899", "13,route Loindici,Lyon,France");
        particulierFacade.CreerID(pa);
        particulierFacade.CreerID(pay);
        particulierFacade.CreerID(paa);
        particulierFacade.CreerID(paay);

        //COMPTE ASSURÉ
        rs = regimeSocialFacade.CreerRegimeSocial("Régime Général", 1000.00, 100.00);
        regimeSocialFacade.CreerRegimeSocial("Alsace Moselle", 1500.00, 150.00);
        /*LogCompteAssure*/
        ca = compteAssureFacade.CreerCompteAssure("MdpAssure", pa, rs);
        /*LogCompteAssure*/
        caa = compteAssureFacade.CreerCompteAssure("MdpAssure", paa, rs);

        //TRANSACTION
        tt = typeTransactionFacade.CreerTypeTransaction("Acte");
        transactionFacade.CreerTransactions("Remboursement 1", 100.00, StatutTransaction.EnAttente, "En attente de validation", tt, ca);

        //GARANTIE
        Garantie ga1, gb1, gc1, gd1, ga2, gb2, ga3, gb3, ga4, gb4;
        fr = typeRemboursementFacade.CreerTypeRemboursement("Frais Réel");
        bd = typeRemboursementFacade.CreerTypeRemboursement("Base de remboursement");
        ga1 = garantieFacade.CreerGarantie("Lunettes verres simples", bd);
        gb1 = garantieFacade.CreerGarantie("Lunettes verres complexes", bd);
        gc1 = garantieFacade.CreerGarantie("Soins dentaires remboursés par la sécurité sociale", bd);
        gd1 = garantieFacade.CreerGarantie("Orthodontie remboursée par la Sécurité Sociale", bd);
        ga2 = garantieFacade.CreerGarantie("Honoraires hospitaliers", bd);
        gb2 = garantieFacade.CreerGarantie("Forfait journalier", bd);
        ga3 = garantieFacade.CreerGarantie("Honoraires médicaux", bd);
        gb3 = garantieFacade.CreerGarantie("Honoraires paramédicaux", bd);
        ga4 = garantieFacade.CreerGarantie("Appareillage et prothèses", fr);
        gb4 = garantieFacade.CreerGarantie("Acupuncture, Ostépathie, Chiropractie", fr);

        List<Garantie> listGOptiqueDentaire = new ArrayList<>();
        listGOptiqueDentaire.add(ga1);
        listGOptiqueDentaire.add(gb1);
        listGOptiqueDentaire.add(gc1);
        listGOptiqueDentaire.add(gd1);

        List<Garantie> listHospi = new ArrayList<>();
        listHospi.add(ga2);
        listHospi.add(gb2);

        List<Garantie> listSoin = new ArrayList<>();
        listSoin.add(ga3);
        listSoin.add(gb3);

        List<Garantie> listDiver = new ArrayList<>();
        listDiver.add(ga4);
        listDiver.add(gb4);

        //MODULE
        Modules m1, m2, m3, m4;
        tmb = typeModuleFacade.CreerTypeModule("Base");
        tmf = typeModuleFacade.CreerTypeModule("Facultatif");
        m1 = moduleFacade.CreerModule("Santé OptiqueDentaire Individuel", tmf, listGOptiqueDentaire);
        m2 = moduleFacade.CreerModule("Santé Hospitalisation", tmb, listHospi);
        m3 = moduleFacade.CreerModule("Santé Soins Courants", tmb, listSoin);
        m4 = moduleFacade.CreerModule("Santé Divers", tmf, listDiver);

        List<Modules> listSante1 = new ArrayList<>(); //Module base + Optique/dentaire 
        listSante1.add(m1);
        listSante1.add(m2);
        listSante1.add(m3);
        List<Modules> listSante2 = new ArrayList<>(); //Module base + Divers
        listSante2.add(m4);
        listSante2.add(m2);
        listSante2.add(m3);

        //PRODUIT
        dm = domaineProduitFacade.CreerDomaineProduit("Santé");
        pr1 = produitFacade.CreerProduit(TypeProduit.Individuel, "Cristal - 3 modules", 0.1327, dm, listSante1);
        pr2 = produitFacade.CreerProduit(TypeProduit.Collectif, "Produit Santé Basique Collectif", 0.1327, dm, listSante2);

        //PRIX&TAUX GARANTIE
        ObjetGarantie cadre, tns, Na, Nb, Nc;
        cadre = objetGarantieFacade.CreerObjetGarantie("Cadre");
        objetGarantieFacade.CreerObjetGarantie("Non Cadre");
        objetGarantieFacade.CreerObjetGarantie("Etudiant");
        tns = objetGarantieFacade.CreerObjetGarantie("TNS");
        objetGarantieFacade.CreerObjetGarantie("Retraité");
        Na = objetGarantieFacade.CreerObjetGarantie("N1");
        Nb = objetGarantieFacade.CreerObjetGarantie("N2");
        Nc = objetGarantieFacade.CreerObjetGarantie("N3");
        trancheAgeFacade.CreerTrancheAge("0-17 ans", 0, 17);
        ta = trancheAgeFacade.CreerTrancheAge("18-34 ans", 18, 34);
        tv = trancheAgeFacade.CreerTrancheAge("35-54 ans", 35, 54);
        trancheAgeFacade.CreerTrancheAge("55-70 ans", 55, 70);
        trancheAgeFacade.CreerTrancheAge("71-80 ans", 71, 80);
        //OptiqueDentaire
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, ga1);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, ga1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, ga1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, ga1);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, gb1);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, gb1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, gb1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, gb1);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, gc1);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, gc1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, gc1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, gc1);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, gd1);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, gd1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, gd1);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, gd1);
        //Hospi
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, ga2);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, ga2);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, ga2);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, ga2);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 10.0, ta, Nc, ga2);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 12.0, tv, Nc, ga2);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, gb2);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, gb2);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, gb2);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, gb2);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 10.0, ta, Nc, gb2);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 12.0, tv, Nc, gb2);
        //SoinsCourant
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, ga3);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, ga3);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, ga3);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, ga3);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 10.0, ta, Nc, ga3);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 12.0, tv, Nc, ga3);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, Na, gb3);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 5.0, tv, Na, gb3);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 7.0, ta, Nb, gb3);
        tauxGarantieFacade.CreerTauxDeGarantie(200.0, 8.0, tv, Nb, gb3);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 10.0, ta, Nc, gb3);
        tauxGarantieFacade.CreerTauxDeGarantie(300.0, 12.0, tv, Nc, gb3);
        //Divers
        tauxGarantieFacade.CreerTauxDeGarantie(50.0, 4.0, ta, Na, ga4);
        tauxGarantieFacade.CreerTauxDeGarantie(50.0, 5.0, tv, Na, ga4);
        tauxGarantieFacade.CreerTauxDeGarantie(65.0, 7.0, ta, Nb, ga4);
        tauxGarantieFacade.CreerTauxDeGarantie(65.0, 8.0, tv, Nb, ga4);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 10.0, ta, Nc, ga4);
        tauxGarantieFacade.CreerTauxDeGarantie(100.0, 12.0, tv, Nc, ga4);
        tauxGarantieFacade.CreerTauxDeGarantie(250.0, 4.0, ta, Na, gb4);
        tauxGarantieFacade.CreerTauxDeGarantie(250.0, 5.0, tv, Na, gb4);
        tauxGarantieFacade.CreerTauxDeGarantie(600.0, 7.0, ta, Nb, gb4);
        tauxGarantieFacade.CreerTauxDeGarantie(600.0, 8.0, tv, Nb, gb4);
        tauxGarantieFacade.CreerTauxDeGarantie(1000.0, 10.0, ta, Nc, gb4);
        tauxGarantieFacade.CreerTauxDeGarantie(1000.0, 12.0, tv, Nc, gb4);

        //CONTRAT
        devisA = contratIndividuelFacade.CreerDevis("DevisDeTestAssure 1", ca, null, ce, tns, pr1);
        devisB = contratIndividuelFacade.CreerDevis("DevisDeTestAssure 2", ca, null, ce, tns, pr1);
        contratIndividuelFacade.CreerDevis("DevisDeTestPublique", null, pp, ce, cadre, pr1);
        contratIndividuelFacade.CreerContratIndividuel("ContratIndivTest", ChoixPaiement.Annuel, ce, devisA);
        cc = contratCollectifFacade.CreerContratCollectif("ContratCollectif", ca, ce, pr2, pm);
        contratIndividuelFacade.CreerContratAdhesion("ContratAdhesion", ChoixPaiement.Annuel, ce, ca, cadre, cc);

        //EVENEMENT
        evenementFacade.CreerEvenement("Test", new Date(), devisA);//test

        //FICHIER
        tf = typeFichierFacade.CreerTypeFichier("jpg");
        typeFichierFacade.CreerTypeFichier("png");
        typeFichierFacade.CreerTypeFichier("pdf");
        fichierFacade.CreerFichier("FichierDeTest", /*blob*/ null, tf, devisA);

        //AYANT DROIT
        td = typeAyantDroitFacade.CreerTypeAyantDroit("Conjoint");
        typeAyantDroitFacade.CreerTypeAyantDroit("Enfant");
        typeAyantDroitFacade.CreerTypeAyantDroit("Conjointe");
        ayantDroitFacade.CreerAyantDroit(td, paay, devisA);
        ayantDroitFacade.CreerAyantDroit(td, pay, devisB);
    }

    @Override
    public Boolean VerificationDonne() {
        Boolean b;
        b = compteEmployeFacade.ListerAllCompteEmploye().isEmpty();
        return b;
    }

    @Override
    public List ListerAllCompteEmploye() {
        return compteEmployeFacade.ListerAllCompteEmploye();
    }

    @Override
    public List ListerAllParticulier() {
        return particulierFacade.ListerAllParticulier();
    }

    @Override
    public List ListerAllPersonneMorale() {
        return personneMoraleFacade.ListerAllPersonneMorale();
    }

    @Override
    public CompteEmploye CreerCompteEmploye(String login, String mdp, String nom, String prenom, Genre genre, Date Dob, String email, String tel, String adr, Role role, StatutPersonne statutPersonne) {
        return compteEmployeFacade.CreerCompteEmploye(login, mdp, nom, prenom, genre, Dob, email, tel, adr, role);
    }
    
        @Override
    public List<Produit> afficherLesProduits(){
 
        List<Produit> listp = new ArrayList<Produit>(); 
        listp =  produitFacade.ListerAllProduit();
        
        return listp;
    }
    
            @Override
    public List<Modules> afficherLesModules(){
 
        List<Modules> listm = moduleFacade.ListerAllModule();
        
        return listm;
    }
    
            @Override
    public List<Garantie> afficherLesGaranties(){
 
        List<Garantie> listg = new ArrayList<Garantie>(); 
        listg =  garantieFacade.ListerAllGarantie();
        
        return listg;
    }
    
    public List<TypeRemboursement> afficherLesTypesRemboursement() {
            List<TypeRemboursement> listp = typeRemboursementFacade.ListerAllTypeRemboursement();
            return listp;
                    
                    }
    
    
    
    
    

    @Override
    public Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr) {
        return particulierFacade.CreerParticulier(nom, prenom, genre, Dob, Nsecu, email, tel, adr);
    }

   @Override
    public PersonneMorale CreerPersonneMorale(String raisonSociale, String nSiret, String nSiren, String login, String mdp, String email) {
        return personneMoraleFacade.CreerPersonneMorale(raisonSociale, nSiret, nSiren, login, mdp, email);
    }

    @Override
    public Produit CreerProduit(TypeProduit typeProduit, String libelle, double fiscalite, DomaineProduit cleDomaineProduit, List<Modules> lesModules) {
        Produit p;
         p = produitFacade.CreerProduit(typeProduit, libelle, fiscalite, cleDomaineProduit, lesModules);
         return p;  
    }

    @Override
    public DomaineProduit AffecterDomaineAProduit(String libelle)  {
        DomaineProduit p = domaineProduitFacade.RechercherDomaineParLibelle(libelle);
        return p;
    }
    
    @Override
    public Modules RechercherModuleParId (Long Id){
        Modules m;
        m = moduleFacade.RechercherModuleId(Id);
        return m;
    }

    @Override
    public ContratIndividuel RechercherContratIndivParId(long idContrat) {
        return contratIndividuelFacade.RechercherContratIndivParId(idContrat);
    }

    @Override
    public List<Particulier>  RechercherListeParticulier(String nSecu) {
        return particulierFacade.RechercherListeParticulier(nSecu);
    }

    
     @Override
    public Garantie RechercherGarantieParId (Long Id){
        Garantie m;
        m = garantieFacade.RechercherGarantieId(Id);
        return m;
    }

    
    @Override
    public TypeModule AffecterTypeAModule(String libelle)  {
        TypeModule p;
        p = typeModuleFacade.RechercherTypeModuleParLibelle(libelle);
        return p;
    }

    
    @Override
    public Modules CreerModule( String libelle,TypeModule typemodule, List<Garantie> listeGarantie) {
        Modules p;
         p = moduleFacade.CreerModule(libelle, typemodule, listeGarantie);
         return p;  
    }

    @Override
    public List ListerAllTypeAyantDroit() {      
        return typeAyantDroitFacade.ListerAllTypeAyantDroit();
    }

    @Override
    public Particulier RechercherParticulierParId(long idParticulier) {
        return particulierFacade.RechercherParticulierParID(idParticulier);
    }

    @Override
    public AyantDroit CreerAyantDroit(TypeAyantDroit typeAD, Particulier particulier, ContratIndividuel contrat) {
        return ayantDroitFacade.CreerAyantDroit(typeAD, particulier, contrat);
    }

    @Override
    public TypeAyantDroit RechercherTypeAyantDroitParId(long idType) {
        return typeAyantDroitFacade.RechercherTypeAyantDroitParId(idType);
    }

    @Override
    public void SupprimerAyantDroit(AyantDroit AD) {
        ayantDroitFacade.SupprimerAyantDroit(AD);
    }

    @Override
    public AyantDroit RechercherAyantDroitParID(long idAD) {
        return ayantDroitFacade.RechercherAyantDroitParId(idAD);
    }
    
     @Override
    public TypeRemboursement AffecterTypeAGarantie(String libelle)  {
        TypeRemboursement p;
        p = typeRemboursementFacade.RechercherTypeModuleParLibelle(libelle);
        return p;
    }
    
    public Garantie CreerGarantie (String libelle, TypeRemboursement typeRemboursement) {
        Garantie g;
        g = garantieFacade.CreerGarantie(libelle, typeRemboursement);
        return g;
    }
    
    
     @Override
    public ContratCollectif RechercherContratCollectifParId(long idContrat) {
        return contratCollectifFacade.RechercherContratCollectifParId(idContrat);
    }
    
    @Override
     public List<ContratIndividuel> RechercherContratIndividuel(){
     return contratIndividuelFacade.ListerAllContratIndividuel();
     }
    
    @Override
    public void ModifierCompteEmploye (CompteEmploye ce){
        compteEmployeFacade.ModifierCompteEmploye(ce);
    }
    
    
      @Override
    public List<ContratIndividuel>  RechercherContratIndividuelAttente(StatutContrat type) {
        return contratIndividuelFacade.ListerAllContratIndividuelAttente(type);
    }

     @Override
    public List RechercherRIBAttente() {
        return fichierFacade.ListerAllFichier();
    }
    
    
}
