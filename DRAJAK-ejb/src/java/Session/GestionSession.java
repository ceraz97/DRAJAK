/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.CompteAssure;
import Entity.CompteEmploye;
import Entity.Contrat;
import Entity.ContratCollectif;
import Entity.ContratIndividuel;
import Entity.DomaineProduit;
import Entity.Garantie;
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
import Enum.StatutPersonne;
import Enum.StatutTransaction;
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
       ObjetGarantie og;
       TrancheAge ta, tv;
       DomaineProduit dm;
       Produit pri, prc;
       TypeModule tmb, tmf;
       TypeRemboursement fr, bd;
       List listG;
       List listM;
              
       Genre autre, femme, homme;
       autre= Genre.Autre; femme= Genre.Femme; homme= Genre.Homme;
       

       Date d = new Date();
      
       //PERSONNE PUBLIQUE
      pp = personnePubliqueFacade.CreerPersonnePublique("Alexandre", "Tristan", autre,d , "1964569123458", "Tristan.alexandre841200@yopmail.com", "0666666666", "39 avenue DeLaBas, 69006, Lyon, France");
      personnePubliqueFacade.CreerPersonnePublique("Jean", "Eude", autre,d , "1964569423458", "Jean.Eude@yopmail.com", "0666667666", "40 avenue DeLaBas, 69006, Lyon, France");
      
      //PERSONNE MORALE
      /*LogMoral*/ pm = personneMoraleFacade.CreerPersonneMorale("EntrepriseTest", "999999999", "14141414141414", "LogMorale", "MdpMorale", "EntrepriseTest@yopmail.com");
      
      //COMPTE EMPLOYÉ
      /*LogEmploye*/ce = compteEmployeFacade.CreerCompteEmploye("Drajak", "admin","Ratz","Clement",homme,d,"Clement.ratz0@yopmail.com","0707070707","66 rue QuelquespartdansLyon, 69005, Lyon, France",Role.Administrateur);
      compteEmployeFacade.CreerID(ce);
       
      //PARTICULIER
      pa = particulierFacade.CreerParticulier("Kutay", "Ilkay", femme, d, "1999956841234", "Ilkay.kutay@yopmail.com", "0666778899", "21 rue ParLàBas, 69004, Lyon, France");
      pay = particulierFacade.CreerParticulier("Mohamed", "Dja", homme, d, "19999456841234", "Mohamed.Dja@yopmail.com", "0666668899", "20 lotissement ParIci, 69003, Lyon, France");
      paa = particulierFacade.CreerParticulier("Andreï", "Journet", homme, d, "1889956841234", "Andreï.Journet@yopmail.com", "0666998899", "19 route PrèsDeParIci, Lyon, France");
      paay = particulierFacade.CreerParticulier("Xin", "Li", homme, d, "1889445684234", "Xin.Li@yopmail.com", "0666998899", "13 route Loindici, Lyon, France");
      particulierFacade.CreerID(pa);
      particulierFacade.CreerID(pay);
      particulierFacade.CreerID(paa);
      particulierFacade.CreerID(paay);
      
      //COMPTE ASSURÉ
       rs = regimeSocialFacade.CreerRegimeSocial("Régime Général", 1000.00, 100.00);
       regimeSocialFacade.CreerRegimeSocial("Alsace Moselle", 1500.00, 150.00);
       /*LogCompteAssure*/ca = compteAssureFacade.CreerCompteAssure("MdpAssure", pa, rs);
       /*LogCompteAssure*/caa = compteAssureFacade.CreerCompteAssure("MdpAssure", paa, rs);
       
       //TRANSACTION
       tt = typeTransactionFacade.CreerTypeTransaction("Acte");
       transactionFacade.CreerTransactions("Remboursement 1", 100.00, StatutTransaction.EnAttente, "En attente de validation", tt, ca);
       
       //GARANTIE
       Garantie ga, gb, gc, gd, ge;
       fr = typeRemboursementFacade.CreerTypeRemboursement("Frais Réel");
       bd = typeRemboursementFacade.CreerTypeRemboursement("Base de remboursement");
       ga = garantieFacade.CreerGarantie("Adherent CAS", bd);
       gb = garantieFacade.CreerGarantie("Non Adherent CAS", bd);
       gc = garantieFacade.CreerGarantie("Chambre particuliere", fr);
       gd = garantieFacade.CreerGarantie("Lit d'accompagnement", fr);
       ge = garantieFacade.CreerGarantie("Forfait naissance ou adoption", fr);
       listG = garantieFacade.ListerAllGarantie();
       
       //MODULE
       tmb = typeModuleFacade.CreerTypeModule("Base");
       tmf = typeModuleFacade.CreerTypeModule("Facultatif");
       moduleFacade.CreerModule("Santé Hospitalisation", tmb, listG);
       moduleFacade.CreerModule("Santé Dentaire", tmb, listG);
       moduleFacade.CreerModule("Santé Optique", tmb, listG);
       listM = moduleFacade.ListerAllModule();
       
       //PRODUIT
       dm = domaineProduitFacade.CreerDomaineProduit("Santé");
       pri = produitFacade.CreerProduit(TypeProduit.Individuel, "Cristal - 3 modules", 0.1327, dm, listM);
       prc = produitFacade.CreerProduit(TypeProduit.Collectif, "Produit Santé Basique Collectif", 0.1327, dm, listM);
       
       //PRIX&TAUX GARANTIE
       og =  objetGarantieFacade.CreerObjetGarantie("Cadre");
       objetGarantieFacade.CreerObjetGarantie("Non Cadre");
       objetGarantieFacade.CreerObjetGarantie("Profession Liberale");
       objetGarantieFacade.CreerObjetGarantie("TNS");
       objetGarantieFacade.CreerObjetGarantie("Etudiant");
       trancheAgeFacade.CreerTrancheAge("0-17 ans", 0 ,17, 0.33 );
       ta = trancheAgeFacade.CreerTrancheAge("18-34 ans", 18 ,34, 1.0 );
       tv = trancheAgeFacade.CreerTrancheAge("35-54 ans", 35 ,54, 1.5 );
       trancheAgeFacade.CreerTrancheAge("55-70 ans", 55 ,70, 1.8 );
       trancheAgeFacade.CreerTrancheAge("71-80 ans", 71 ,80, 2.1 );
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, null, ga); //Pas d'influence sur ces garanties en particulier
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 7.0, tv, null, ga);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, null, gb);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 7.0, tv, null, gb);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, null, gc);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 7.0, tv, null, gc);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, null, gd);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 7.0, tv, null, gd);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 4.0, ta, null, ge);
       tauxGarantieFacade.CreerTauxDeGarantie(100.0, 7.0, tv, null, ge);
       
       //CONTRAT
       devisA = contratIndividuelFacade.CreerDevis("DevisDeTestAssure 1", ca, null, ce, og, pri);
       devisB = contratIndividuelFacade.CreerDevis("DevisDeTestAssure 2", ca, null, ce, og, pri);
       contratIndividuelFacade.CreerDevis("DevisDeTestPublique", null, pp, ce, og, pri);
       contratIndividuelFacade.CreerContratIndividuel("ContratIndivTest", ChoixPaiement.Annuel, ce, devisA);
       cc =contratCollectifFacade.CreerContratCollectif("ContratCollectif", ca, ce, prc, pm);
       contratIndividuelFacade.CreerContratAdhesion("ContratAdhesion", ChoixPaiement.Annuel, ce, ca, og, cc);
       
       //EVENEMENT
       evenementFacade.CreerEvenement("Test", d, devisA);//test

       
       //FICHIER
       tf = typeFichierFacade.CreerTypeFichier("jpg");
       typeFichierFacade.CreerTypeFichier("png");
       typeFichierFacade.CreerTypeFichier("pdf");
       fichierFacade.CreerFichier("FichierDeTest", /*blob*/null, tf, devisA);
       
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
    

    
}
