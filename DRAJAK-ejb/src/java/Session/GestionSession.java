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
       
       Particulier pa, paa, paaa;
       PersonneMorale pm;
       RegimeSocial rs;
       CompteEmploye ce;
       TypeAyantDroit td;
       TypeFichier tf;
       TypeTransaction tt;
       CompteAssure ca;
       PersonnePublique pp;
       Contrat c;
       ContratIndividuel devis;
       ContratIndividuel adhesion;
       ContratIndividuel individuel;
       ContratCollectif cc;
       ObjetGarantie og;
       TrancheAge ta;
       TauxGarantie tg;
       TypeProduit tp;
       DomaineProduit dm;
       Produit pri, prc;
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
       TypeProduit typePi = TypeProduit.Individuel;
       TypeProduit typePc = TypeProduit.Collectif;
       StatutTransaction statT = StatutTransaction.EnAttente;
       ChoixPaiement choixP = ChoixPaiement.Prélèvement;
       Blob blob = null;
       Genre neutre, femme, homme;
       neutre= Genre.Neutre; femme= Genre.Femme; homme= Genre.Homme;
       
       String mois = "1000", jour = "50";
       Double plafMois = Double.parseDouble(mois);
       Double plafJour = Double.parseDouble(jour);
       String maxR = "5000", tarif = "20", fisc ="0.137", mont = "100";
       Double maxRemb = Double.parseDouble(maxR);
       Double tarifCot = Double.parseDouble(tarif);
       Double fiscalite = Double.parseDouble(fisc);
       Double montant = Double.parseDouble(mont);
       Date d = new Date();
       int min = 20, max = 35, nSire = 123213123;
       
      pp = personnePubliqueFacade.CreerPersonnePublique("Alexandre", "Tristan", neutre,d , "1964569123458", "Tristan.alexandre841200@yopmail.com", "0666666666", "Num,Rue,CP,Ville,Pays", sp);
      /*LogMoral*/ pm = personneMoraleFacade.CreerPersonneMorale("EntrepriseTest", nSire, nSire, "LogMorale", "MdpMorale", "EntrepriseTest@yopmail.com");
      /*LogEmploye*/ce = compteEmployeFacade.CreerCompteEmploye("Drajak", "admin","Ratz","Clement",homme,d,"Clement.ratz0@yopmail.com","0707070707","QuelquespartdansLyon",role ,sp);
      compteEmployeFacade.CreerID(ce);
       

      pa = particulierFacade.CreerParticulier("Kutay", "Ilkay", femme, d, "1999956841234", "Ilkay.kutay@yopmail.com", "0666778899", "Num,Rue,CP,Ville,Pays", sp);
      paa = particulierFacade.CreerParticulier("Mohamed", "Dja", homme, d, "19999456841234", "Mohamed.Dja@yopmail.com", "0666668899", "Num,Rue,CP,Ville,Pays", sp);
      paaa = particulierFacade.CreerParticulier("Andreï", "Journet", homme, d, "1889956841234", "Andreï.Journet@yopmail.com", "0666998899", "Num,Rue,CP,Ville,Pays", sp);
      particulierFacade.CreerID(pa);
      particulierFacade.CreerID(paa);
      particulierFacade.CreerID(paaa);
       
       rs = regimeSocialFacade.CreerRegimeSocial("Régime Général", plafMois, plafJour);
       /*LogCompteAssure*/ca = compteAssureFacade.CreerCompteAssure("MdpAssure", pa, rs);
       
       tt = typeTransactionFacade.CreerTypeTransaction("Acte");
       transactionFacade.CreerTransactions("Remboursement 1", d, montant, statT, "En attente de validation", tt, ca);
       
       tr = typeRemboursementFacade.CreerTypeRemboursement("Frais Réel");
       gr = garantieFacade.CreerGarantie("Lunettes", tr);
       listG = garantieFacade.ListerAllGarantie();
       
       tm = typeModuleFacade.CreerTypeModule("Base");
       md = moduleFacade.CreerModule("Santé base", tm, listG);
       listM = moduleFacade.ListerAllModule();
       
       dm = domaineProduitFacade.CreerDomaineProduit("Santé");
       pri = produitFacade.CreerProduit(typePi, "Produit Santé Basique Individuel", fiscalite, dm, listM);
       prc = produitFacade.CreerProduit(typePc, "Produit Santé Basique Collectif", fiscalite, dm, listM);
       
       og = objetGarantieFacade.CreerObjetGarantie("Vieux");
       ta = trancheAgeFacade.CreerTrancheAge("20-35 ans", min ,max );
       tg = tauxGarantieFacade.CreerTauxDeGarantie(maxRemb, tarifCot, ta, og, gr);
                

       devis = contratIndividuelFacade.CreerDevis("DevisDeTestAssure", ca, null, ce, og, pri);
       contratIndividuelFacade.CreerDevis("DevisDeTestPublique", null, pp, ce, og, pri);
       individuel = contratIndividuelFacade.CreerContratIndividuel("ContratIndivTest", choixP, ce, devis);
       cc =contratCollectifFacade.CreerContratCollectif("ContratCollectif", ca, ce, prc, pm);
       evenementFacade.CreerEvenement("Test", d, devis);//test
       c=devis;
       tf = typeFichierFacade.CreerTypeFichier("jpg");
       fichierFacade.CreerFichier("FichierDeTest", d, blob, tf, c);
       
      td = typeAyantDroitFacade.CreerTypeAyantDroit("Conjoint");
      ayantDroitFacade.CreerPersonnePublique(td, paaa, devis);
      ayantDroitFacade.CreerPersonnePublique(td, paa, devis);
        }

    @Override
    public Boolean VerificationDonne() {
        Boolean b;
        b = compteEmployeFacade.ListerAllCompteEmploye().isEmpty();
        return b;
    }
    

    
}
