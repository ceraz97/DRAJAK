/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.*;
import Enum.*;
import Session.AssureSessionLocal;
import Session.GestionSessionLocal;
import Session.PubliqueSessionLocal;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.WebServlet;
import java.nio.file.Paths;

/**
 *
 * @author clementratz
 */
@WebServlet(name = "menuDrajak", urlPatterns = {"/menuDrajak"})
public class menuDrajak extends HttpServlet {

    

    public static final int TAILLE_TAMPON = 10240;
    
    @EJB
    private GestionSessionLocal gestionSession;

    @EJB
    private AssureSessionLocal assureSession;

    @EJB
    private PubliqueSessionLocal publiqueSession;
    
    /**
     *
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String jspAffiche = null;
        String message = null;
        String typeSession = null;
        String act = request.getParameter("action");
        HttpSession session = request.getSession(false);
        CompteAssure sessionAssure = null;
        CompteEmploye sessionGestionnaire = null;
        CompteEmploye sessionAdministrateur = null;
        PersonneMorale sessionEntreprise = null;
        //boolean sessionPublic = true;
        List<Object> Response;
        System.out.println("===" + act + "===");
        if (session != null) {
            sessionAssure = (CompteAssure) session.getAttribute("sessionAssure");
            sessionGestionnaire = (CompteEmploye) session.getAttribute("sessionGestionnaire");
            sessionEntreprise = (PersonneMorale) session.getAttribute("sessionEntreprise");
            sessionAdministrateur = (CompteEmploye) session.getAttribute("sessionAdministrateur");
        }

        //Initialisation de données dans la base de données
        if (gestionSession.VerificationDonne() == true) {
            gestionSession.AjouterDonnee();
        }

        if ((sessionAssure != null && sessionGestionnaire != null && sessionEntreprise != null && sessionAdministrateur != null) || (sessionAssure == null && sessionGestionnaire == null && sessionEntreprise == null && sessionAdministrateur == null && act != null && !act.equals("") && !act.equals("AssureMenu") && !act.equals("GestionnaireMenu") && !act.equals("EntrepriseMenu") && !act.equals("AdministrateurMenu") && !act.equals("AssureAuthentification") && !act.equals("GestionnaireAuthentification") && !act.equals("EntrepriseAuthentification") && !act.equals("AdministrateurAuthentification") && !act.equals("Deconnexion") && !act.equals("DemandeDevis_besoins") && !act.equals("DemandeDevis_infos") && !act.equals("DemandeDevis_tarif") && !act.equals("DemandeDevis_souscription") && !act.equals("DemandeDevis_exportpdf")&& !act.equals("DemandeDevis_RealisationContratIndiv")&& !act.equals("RechercherChargeAttenteGestionnaireListe")&& !act.equals("modifierFichierS")&& !act.equals("ModificationFichierStatutGestionnaire"))) {
      
            jspAffiche = "/ErreurSession.jsp";
            message = "Erreur de session ! Veuillez vous reconnecter !";
            if (act.substring(0, 5).equals("Assure")) {
                request.setAttribute("typeConnexion", "AssureMenu");
            } else if (act.substring(0, 5).equals("Gestionnaire")) {
                request.setAttribute("typeConnexion", "GestionnaireMenu");
            } else if (act.substring(0, 5).equals("Entreprise")) {
                request.setAttribute("typeConnexion", "EntrepriseMenu");
            } else if (act.substring(0, 5).equals("Administrateur")) {
                request.setAttribute("typeConnexion", "AdministrateurMenu");
            }
        } else if (act == null) {
            jspAffiche = "/accueilPublic.jsp";
            message = "Bienvenue";
        } else {
            switch (act) {
                case "accueilPublic":
                    jspAffiche = "/accueilPublic.jsp";
                    message = "Bienvenue";
                    break;

                case "AssureMenu":
                case "GestionnaireMenu":
                case "EntrepriseMenu":
                case "AdministrateurMenu":
                    if (sessionAssure != null) {
                        jspAffiche = "/menuAssure.jsp";
                        message = "";
                    } else if (sessionGestionnaire != null) {
                        jspAffiche = "/menuGestionnaire.jsp";
                        message = "";
                    } else if (sessionEntreprise != null) {
                        jspAffiche = "/menuEntreprise.jsp";
                        message = "";
                    } else if (sessionAdministrateur != null) {
                        jspAffiche = "/menuAdministrateur.jsp";
                        message = "";
                    } else {
                        jspAffiche = "/accueilPublic.jsp";
                        message = "Veuillez vous connecter";
                        request.setAttribute("typeConnexion", act);
                    }
                    break;

                case "Deconnexion":
                    if (sessionAssure != null || sessionEntreprise != null) {
                        jspAffiche = "/accueilPublic.jsp";
                    } else if (sessionGestionnaire != null || sessionAdministrateur != null) {
                        jspAffiche = "/accueilEmploye.jsp";
                    }
                    session = request.getSession(false);
                    session.invalidate();
                    request.setAttribute("typeConnexion", request.getParameter("typeConnexion"));
                    
                    message = "Vous êtes déconnecté";
                    break;

                case "AssureAuthentification":
                    String assureLogin = request.getParameter("login");
                    String assureMdp = request.getParameter("mdp");
                    if (assureLogin.trim().isEmpty() || assureMdp.trim().isEmpty()) {
                        message = "Erreur : Vous n'avez pas rempli tous les champs";
                        request.setAttribute("typeConnexion", "AssureMenu");
                        jspAffiche = "/accueilPublic.jsp";
                    } else {
                        sessionAssure = assureSession.RechercherCompteAssurePourConnexion(assureLogin, assureMdp);
                        if (sessionAssure == null) {
                            request.setAttribute("typeConnexion", "AssureMenu");
                            message = "Erreur : Le login ou le mot de passe est incorrect";
                            jspAffiche = "/accueilPublic.jsp";
                        } else {
                            jspAffiche = "/menuAssure.jsp";
                            message = "Connexion réussie";
                            session = request.getSession(true);
                            session.setAttribute("sessionAssure", sessionAssure);
                        }
                    }
                    break;

                case "GestionnaireAuthentification":
                    String GestionnaireLogin = request.getParameter("login");
                    String GestionnaireMdp = request.getParameter("mdp");
                    if (GestionnaireLogin.trim().isEmpty() || GestionnaireMdp.trim().isEmpty()) {
                        message = "Erreur : Vous n'avez pas rempli tous les champs";
                        request.setAttribute("typeConnexion", "GestionnaireMenu");
                        jspAffiche = "/accueilEmploye.jsp";
                    } else {
                        sessionGestionnaire = gestionSession.RechercherCompteEmployePourConnexion(GestionnaireLogin, GestionnaireMdp);
                        if (sessionGestionnaire == null) {
                            request.setAttribute("typeConnexion", "GestionnaireMenu");
                            message = "Erreur : Le login ou le mot de passe est incorrect";
                            jspAffiche = "/accueilEmploye.jsp";
                        } else {
                            jspAffiche = "/menuGestionnaire.jsp";
                            message = "Connexion réussie";
                            session = request.getSession(true);
                            session.setAttribute("sessionGestionnaire", sessionGestionnaire);
                        }
                    }
                    break;

                case "EntrepriseAuthentification":
                    String EntrepriseLogin = request.getParameter("login");
                    String EntrepriseMdp = request.getParameter("mdp");
                    if (EntrepriseLogin.trim().isEmpty() || EntrepriseMdp.trim().isEmpty()) {
                        message = "Erreur : Vous n'avez pas rempli tous les champs";
                        request.setAttribute("typeConnexion", "EntrepriseMenu");
                        jspAffiche = "/accueilPublic.jsp";
                    } else {
                        sessionEntreprise = assureSession.RechercherCompteEntreprisePourConnexion(EntrepriseLogin, EntrepriseMdp);
                        if (sessionEntreprise == null) {
                            request.setAttribute("typeConnexion", "EntrepriseMenu");
                            message = "Erreur : Le login ou le mot de passe est incorrect";
                            jspAffiche = "/accueilPublic.jsp";
                        } else {
                            jspAffiche = "/menuEntreprise.jsp";
                            message = "Connexion réussie";
                            session = request.getSession(true);
                            session.setAttribute("sessionEntreprise", sessionEntreprise);
                        }
                    }
                    break;

                case "AdministrateurAuthentification":
                    String AdministrateurLogin = request.getParameter("login");
                    String AdministrateurMdp = request.getParameter("mdp");
                    if (AdministrateurLogin.trim().isEmpty() || AdministrateurMdp.trim().isEmpty()) {
                        message = "Erreur : Vous n'avez pas rempli tous les champs";
                        request.setAttribute("typeConnexion", "AdministrateurMenu");
                        jspAffiche = "/accueilEmploye.jsp";
                    } else {
                        sessionAdministrateur = gestionSession.RechercherCompteEmployePourConnexion(AdministrateurLogin, AdministrateurMdp);
                        if (sessionAdministrateur == null) {
                            request.setAttribute("typeConnexion", "AdministrateurMenu");
                            message = "Erreur : Le login ou le mot de passe est incorrect";
                            jspAffiche = "/accueilEmploye.jsp";
                        } else {
                            jspAffiche = "/menuAdministrateur.jsp";
                            message = "Connexion réussie";
                            session = request.getSession(true);
                            session.setAttribute("sessionAdministrateur", sessionAdministrateur);
                            
                        }
                    }
                    break;

                case "AssureVersPageAfficherContrat":
                    jspAffiche = "/.jsp";
                    message = "";
                    break;

                case "DemandeDevis_besoins":
                    jspAffiche = "/realiserDevisBesoins.jsp";
                    message = "";
                    break;

                case "DemandeDevis_infos":
                    jspAffiche = "/realiserDevisInfos.jsp";
                    message = "";

                    String nbAdulte = request.getParameter("adulte").substring(6);
                    String trancheAge = request.getParameter("age").substring(3);
                    String enfant = request.getParameter("enfant").substring(0, 4);
                    String couverture = request.getParameter("couverture").substring(10);
                    String optiqueDentaire = request.getParameter("optiqueDentaire").substring(15);

                    request.setAttribute("nbAdulte", nbAdulte);
                    request.setAttribute("trancheAge", trancheAge);
                    request.setAttribute("enfant", enfant);
                    request.setAttribute("couverture", couverture);
                    request.setAttribute("optiqueDentaire", optiqueDentaire);

                    break;

                case "CreerGestionnaire":
                    jspAffiche = "/menuAdministrateur.jsp";
                    message = "Gestionnaire crée avec succès";
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String dateNaissance = request.getParameter("dateNaissance");
                    String adresse = request.getParameter("adresse");
                    String numero = request.getParameter("numero");
                    String genre = request.getParameter("genre");
                    String role = request.getParameter("role");
                    String mail = request.getParameter("mail");
                    String mdp = request.getParameter("mdp");

                    Date d = java.sql.Date.valueOf(dateNaissance); 
                    Role r;
                    if (role.equalsIgnoreCase("gestionnaire")) {
                        r = Role.Gestionnaire;
                    } else {
                        r = Role.Administrateur;
                    }
                    Genre g;
                    if (genre.equalsIgnoreCase("Homme")) {
                        g = Genre.Homme;
                    } else if (genre.equalsIgnoreCase("Femme")) {
                        g = Genre.Femme;
                    } else {
                        g = Genre.Autre;
                    }

                    gestionSession.CreerCompteEmploye(mail, mdp, nom, prenom, g, d, mail, numero, adresse, r, StatutPersonne.Actif);
                    message = "Gestionnaire créé avec succès !";
                    break;

                case "ModifierGestionnaire":
                    jspAffiche = "/modificationGestionnaire.jsp";
                    
                    message = "Gestionnaire modifié avec succès";
                     List<CompteEmploye> listeGestionnaire = gestionSession.ListerAllCompteEmploye();
                     System.out.println("Liste gestionnaire " +listeGestionnaire);
                    if (listeGestionnaire == null){
                        message="Aucun contrats n'a été trouvé";
                    }
                  try {
                          request.setAttribute("listeGestionnaire", listeGestionnaire);}
                    catch (Exception e){}
                  break;
                    
                   
                  

                  
                    

                case "Assure_CreerParticulier":
                case "Gestionnaire_CreerParticulier":
                case "Administrateur_CreerParticulier":
                    String numRueNewPersonne, nomRueNewPersonne,cpNewPersonne,villeNewPersonne,paysNewPersonne, adresseNewPersonne=null;
                    String nomPart=null, prenomPart=null, dateNaissancePart = null, numeroPart=null, genrePart =null, numSSPart=null,mailPart=null;
                    String selectString =null;
                    TypeAyantDroit typeAdInstance = null;
                    String origineCreationParticulier = request.getParameter("origine");
                    String idContratHidden = request.getParameter("idContratHidden");
                    System.out.println("idContratHidden="+idContratHidden);
                    ContratIndividuel contratIndivDetailsApresAjoutAyantDroit = null;
                    Particulier particulierOrigine = null;
                    if (origineCreationParticulier.equals("true") && !idContratHidden.equals("")) {
                        long idContratIndivAjoutAyantDroit =Long.parseLong(idContratHidden);
                        if (sessionAssure!=null){
                            contratIndivDetailsApresAjoutAyantDroit = assureSession.RechercherContratIndivParId(idContratIndivAjoutAyantDroit);
                        } else {
                            contratIndivDetailsApresAjoutAyantDroit = gestionSession.RechercherContratIndivParId(idContratIndivAjoutAyantDroit);
                        }
                        if (contratIndivDetailsApresAjoutAyantDroit == null){
                            message="Aucun contrat n'a été trouvé";
                        } else {
                            particulierOrigine = contratIndivDetailsApresAjoutAyantDroit.getCleCompteAssure().getCleParticulier();
                            request.setAttribute("contrat", contratIndivDetailsApresAjoutAyantDroit);
                            List <AyantDroit> listeAyantsDroits = contratIndivDetailsApresAjoutAyantDroit.getLesAyantDroits();
                            if (listeAyantsDroits!=null){request.setAttribute("listeAyantDroit", listeAyantsDroits);}
                        }
                    }
                    
                    
                    try {
                        try{
                            if (particulierOrigine==null){
                                numeroPart = request.getParameter("numero");
                                mailPart = request.getParameter("mail");
                                numRueNewPersonne = request.getParameter("adrNum").trim();
                                nomRueNewPersonne = request.getParameter("adrNomRue").trim();
                                cpNewPersonne= request.getParameter("adrCP").trim();
                                villeNewPersonne = request.getParameter("adrVille").trim();
                                paysNewPersonne = request.getParameter("adrPays").trim();
                                adresseNewPersonne = numRueNewPersonne + "," + nomRueNewPersonne + "," + cpNewPersonne + "," + villeNewPersonne + "," + paysNewPersonne;
                            } else{
                                numeroPart = particulierOrigine.getnTelephone();
                                mailPart = particulierOrigine.getEmail();
                                adresseNewPersonne = particulierOrigine.getAdresse();
                                selectString = request.getParameter("typeAyantDroitSelect");
                                System.out.println("selectString="+selectString);
                                if (sessionAssure != null) {
                                    typeAdInstance = assureSession.RechercherTypeAyantDroitParId(Long.parseLong(selectString));
                                } else {
                                    typeAdInstance = gestionSession.RechercherTypeAyantDroitParId(Long.parseLong(selectString));
                                }
                            }
                            nomPart = request.getParameter("nom");
                            prenomPart = request.getParameter("prenom");
                            dateNaissancePart = request.getParameter("dateNaissance");
                            genrePart = request.getParameter("genre");
                            numSSPart = request.getParameter("numeroSS");
                        }
                        catch (Exception e){
                            message ="Erreur : Une des données saisie n'a pu être récupérée";
                        }
                    Date date = java.sql.Date.valueOf(dateNaissancePart);
                    Genre gr;
                    if (genrePart.equalsIgnoreCase("Homme")) {
                        gr = Genre.Homme;
                    } else if (genrePart.equalsIgnoreCase("Femme")) {
                        gr = Genre.Femme;
                    } else {
                        gr = Genre.Autre;
                    }
                    
                    
                    
                    if (sessionAssure != null) {
                        if (origineCreationParticulier.equals("true")){
                            jspAffiche = "/gestionContrat_DetailsContat.jsp";
                            System.out.println("Création Particulier : go");
                            Particulier p = assureSession.CreerParticulier(nomPart, prenomPart, gr, date, numSSPart, mailPart, numeroPart, adresseNewPersonne);
                            assureSession.CreerIdParticulier(p);
                            System.out.println("Création Particulier : ok");
                            
                            //Si l'assuré crée une personne c'est que c'est pour ajouter en tant qu'ayant droit
                            System.out.println("Attribution ayant droit : go");
                            assureSession.CreerAyantDroit(typeAdInstance, p, contratIndivDetailsApresAjoutAyantDroit);
                            System.out.println("Attribution ayant droit : ok");
                        }
                    } else if (sessionGestionnaire != null) {
                        jspAffiche = "/menuGestionnaire.jsp";
                        Particulier p = gestionSession.CreerParticulier(nomPart, prenomPart, gr, date, numSSPart, mailPart, numeroPart, adresseNewPersonne);
                        gestionSession.CreerIdParticulier(p);
                        if (origineCreationParticulier.equals("true")){
                            jspAffiche = "/gestionContrat_DetailsContat.jsp";
                            gestionSession.CreerAyantDroit(typeAdInstance, p, contratIndivDetailsApresAjoutAyantDroit);
                        }
                    } else {
                        jspAffiche = "/menuAdministrateur.jsp";
                        Particulier p = gestionSession.CreerParticulier(nomPart, prenomPart, gr, date, numSSPart, mailPart, numeroPart, adresseNewPersonne);
                        gestionSession.CreerIdParticulier(p);
                        if (origineCreationParticulier.equals("true")){
                            jspAffiche = "/gestionContrat_DetailsContat.jsp";
                            gestionSession.CreerAyantDroit(typeAdInstance, p, contratIndivDetailsApresAjoutAyantDroit);
                        }
                    } 
                    
                    message = "Particulier crée avec succès";
                    } catch (Exception e){
                        message="Erreur : Un problème a été rencontré lors de la création de la personne";
                    }
                    break;

                case "CreerPersMorale":
                    jspAffiche = "/menuAdministrateur.jsp";
                    message = "Personne morale créee avec succès";
                    String raisonSociale = request.getParameter("raisonSociale");
                    String siret = request.getParameter("siret");
                    String siren = request.getParameter("siren");
                    String adressePersMorale = request.getParameter("adresse");
                    String mailPersMorale = request.getParameter("mail");
                    String mdpPersMorale = request.getParameter("mdp");

                    gestionSession.CreerPersonneMorale(raisonSociale, siret, siren, mailPersMorale, mdpPersMorale, mailPersMorale);                    
                    break;

                case "AfficherGest":
                    jspAffiche = "/listeGestionnaire.jsp";
                    List<CompteEmploye> list = gestionSession.ListerAllCompteEmploye();
                    request.setAttribute("listeGestionnaire", list);
                    break;

                case "AfficherPart":
                    jspAffiche = "/listePersonne.jsp";
                    List<Particulier> listePart = gestionSession.ListerAllParticulier();
                    List<PersonneMorale> listeMorale = gestionSession.ListerAllPersonneMorale();

                    request.setAttribute("listeParticulier", listePart);
                    request.setAttribute("listePersMorale", listeMorale);
                    break;

                case "DemandeDevis_tarif":
                    jspAffiche = "/realiserDevisTarif.jsp";
                    message = "";

                    String nbAdulteTarif = null,
                     trancheAgeTarif = null,
                     enfantTarif = null,
                     couvertureTarif = null,
                     optiqueDentaireTarif = null;
                    Genre genreAdulte1= null,
                     genreAdulte2= null,
                     genreEnfant1= null,
                     genreEnfant2= null,
                     genreEnfant3= null;
                    String DobA1String= null,
                     DobA2String= null,
                     DobE1String= null,
                     DobE2String= null,
                     DobE3String= null;
                    Date DobA1Date= null,
                     DobA2Date= null,
                     DobE1Date= null,
                     DobE2Date= null,
                     DobE3Date= null;
                    int ageA1= 0,
                     ageA2= 0,
                     ageE1= 0,
                     ageE2= 0,
                     ageE3= 0;
                    String nomA1= null,
                     prenomA1= null;
                    String regimeA1= null;
                    String nbEnfant = null;
                    String numRueTarif= null,
                     nomRueTarif= null,
                     cpTarif= null,
                     villeTarif= null,
                     paysTarif= null,
                     adresseTarif= null,
                     email= null,
                     tel= null;
                    Particulier particulierDevis = null;
                    PersonnePublique personnePubliqueDevis = null;
                    ContratIndividuel devisCree = null;
                    MemoireTamponPersonne TamponPersonneA2=null, TamponPersonneE1=null, TamponPersonneE2=null, TamponPersonneE3=null;
                    List <MemoireTamponPersonne> listeMemoireTamponPersonne= new ArrayList<>();
                    //Récupération des données
                    try {
                        nbAdulteTarif = request.getParameter("adulteHidden");
                        trancheAgeTarif = request.getParameter("ageHidden");
                        enfantTarif = request.getParameter("enfantHidden");
                        couvertureTarif = request.getParameter("couvertureHidden");
                        optiqueDentaireTarif = request.getParameter("optiqueDentaireHidden");
                    } catch (Exception e) {
                        message = "Erreur : une information sur les besoins n'a pu être récupérée";
                        jspAffiche = "/realiserDevisBesoins.jsp";
                    }
                    
                    //recherche des éléments de granties
                    //Adulte
                    if (sessionAssure != null) {
                        particulierDevis = assureSession.RechercherParticulier(sessionAssure.getCleParticulier().getnSecuriteSocial());
                        if (particulierDevis == null) {
                            message = "Erreur : le propiétaire du compte n'a pas été trouvé dans la base de données";
                        }
                    } else {
                        try {
                            String gA1 = request.getParameter("genreA1");
                            if (gA1.equalsIgnoreCase("Homme")) {
                                genreAdulte1 = Genre.Homme;
                            } else if (gA1.equalsIgnoreCase("Femme")) {
                                genreAdulte1 = Genre.Femme;
                            } else {
                                genreAdulte1 = Genre.Autre;
                            }
                            DobA1String = request.getParameter("bdayA1");
                            DobA1Date = java.sql.Date.valueOf(DobA1String);
                            nomA1 = request.getParameter("nomA1");
                            prenomA1 = request.getParameter("prenomA1");
                            ageA1 = doActionCalculerAge(DobA1Date, request, response);
                        } catch (Exception e) {
                            message = "Erreur : une information sur le premier adulte n'a pu être récupérée";
                            jspAffiche = "/realiserDevisBesoins.jsp";
                        }
                    }

                    if (nbAdulteTarif.equalsIgnoreCase("2")) {
                        try {
                            String gA2 = request.getParameter("genre2");
                            if (gA2.equalsIgnoreCase("Homme")) {
                                genreAdulte2 = Genre.Homme;
                            } else if (gA2.equalsIgnoreCase("Femme")) {
                                genreAdulte2 = Genre.Femme;
                            } else {
                                genreAdulte2 = Genre.Autre;
                            }
                            DobA2String = request.getParameter("bdayA2");
                            DobA2Date = java.sql.Date.valueOf(DobA2String);
                            ageA2 = doActionCalculerAge(DobA2Date, request, response);
                            TamponPersonneA2 = publiqueSession.CreerPersonneTampon("Adulte2",genreAdulte2, DobA2Date);
                            listeMemoireTamponPersonne.add(TamponPersonneA2);
                        } catch (Exception e) {
                            message = "Erreur : une information sur le deuxième adulte n'a pu être récupéreée";
                            jspAffiche = "/realiserDevisBesoins.jsp";
                        }
                    }

                    try {
                        nbEnfant = request.getParameter("enfantSelect");
                    } catch (Exception e) {
                        message = "Erreur : le nombre d'enfant n'a pu être récupéré";
                        jspAffiche = "/realiserDevisBesoins.jsp";
                    }
                    
                    //Enfant
                    if (enfantTarif.equalsIgnoreCase("avec")) {
                        try {
                            String gE1 = request.getParameter("genreE1");
                            if (gE1.equalsIgnoreCase("Homme")) {
                                genreEnfant1 = Genre.Homme;
                            } else if (gE1.equalsIgnoreCase("Femme")) {
                                genreEnfant1 = Genre.Femme;
                            } else {
                                genreEnfant1 = Genre.Autre;
                            }
                            DobE1String = request.getParameter("bdayE1");
                            DobE1Date = java.sql.Date.valueOf(DobE1String);
                            ageE1 = doActionCalculerAge(DobE1Date, request, response);
                            TamponPersonneE1 = publiqueSession.CreerPersonneTampon("Enfant1",genreEnfant1, DobE1Date);
                            listeMemoireTamponPersonne.add(TamponPersonneE1);
                        } catch (Exception e) {
                            message = "Erreur : une information sur le premier enfant n'a pu être récupéreée";
                            jspAffiche = "/realiserDevisBesoins.jsp";
                        }

                        if (nbEnfant.equalsIgnoreCase("2") || nbEnfant.equalsIgnoreCase("3")) {
                            try {
                                String gE2 = request.getParameter("genreE2");
                                if (gE2.equalsIgnoreCase("Homme")) {
                                    genreEnfant2 = Genre.Homme;
                                } else if (gE2.equalsIgnoreCase("Femme")) {
                                    genreEnfant2 = Genre.Femme;
                                } else {
                                    genreEnfant2 = Genre.Autre;
                                }
                                DobE2String = request.getParameter("bdayE2");
                                DobE2Date = java.sql.Date.valueOf(DobE2String);
                                ageE2 = doActionCalculerAge(DobE2Date, request, response);
                                TamponPersonneE2 = publiqueSession.CreerPersonneTampon("Enfant2",genreEnfant2, DobE2Date);
                                listeMemoireTamponPersonne.add(TamponPersonneE2);
                            } catch (Exception e) {
                                message = "Erreur : une information sur le deuxième enfant n'a pu être récupéreée";
                                jspAffiche = "/realiserDevisBesoins.jsp";
                            }
                        }
                        if (nbEnfant.equalsIgnoreCase("3")) {
                            try {
                                String gE3 = request.getParameter("genreE3");
                                if (gE3.equalsIgnoreCase("Homme")) {
                                    genreEnfant3 = Genre.Homme;
                                } else if (gE3.equalsIgnoreCase("Femme")) {
                                    genreEnfant3 = Genre.Femme;
                                } else {
                                    genreEnfant3 = Genre.Autre;
                                }
                                DobE3String = request.getParameter("bdayE3");
                                DobE3Date = java.sql.Date.valueOf(DobE3String);
                                ageE3 = doActionCalculerAge(DobE3Date, request, response);
                                TamponPersonneE3 = publiqueSession.CreerPersonneTampon("Enfant3",genreEnfant3, DobE3Date);
                                listeMemoireTamponPersonne.add(TamponPersonneE3);
                            } catch (Exception e) {
                                message = "Erreur : une information sur le troisième enfant n'a pu être récupéreée";
                                jspAffiche = "/realiserDevisBesoins.jsp";
                            }
                        }
                    } else {
                        nbEnfant = "0";
                    }

                    if (sessionAssure == null) {
                        try {
                            //Adresse
                            numRueTarif = request.getParameter("adrNum").trim();
                            nomRueTarif = request.getParameter("adrNomRue").trim();
                            cpTarif = request.getParameter("adrCP").trim();
                            villeTarif = request.getParameter("adrVille").trim();
                            paysTarif = request.getParameter("adrPays").trim();
                            if (numRueTarif!=null && nomRueTarif !=null && cpTarif!=null && villeTarif!=null && paysTarif!=null) {
                                adresseTarif = numRueTarif + "," + nomRueTarif + "," + cpTarif + "," + villeTarif + "," + paysTarif;
                            }
                            //Mail & tel
                            email = request.getParameter("adrMail");
                            tel = request.getParameter("numTel");
                            
                            //Recherche de personne
                            personnePubliqueDevis = publiqueSession.RechercherPersonnePublique(email);
                            if (personnePubliqueDevis==null) {
                                if (nomA1!=null && prenomA1 !=null && genreAdulte1!=null && DobA1Date!=null && email!=null && tel!=null && adresseTarif!=null){
                                    personnePubliqueDevis = publiqueSession.CreerPersonnePublique(nomA1, prenomA1, genreAdulte1, DobA1Date, email, tel, adresseTarif);
                                } 
                            }
                        } catch (Exception e) {
                            message = "Erreur : une information sur le l'adresse ou l'email n'a pu être récupéreée";
                            jspAffiche = "/realiserDevisBesoins.jsp";
                        }
                    }
                    //Obtention tranche Age
                    TrancheAge trancheAgeMaxTarif = null;
                    try {
                        if (trancheAgeTarif.equalsIgnoreCase("1")) {
                            trancheAgeMaxTarif = assureSession.RechercherTrancheAgeParLibelle("18-34 ans");
                        } else if (trancheAgeTarif.equalsIgnoreCase("2")) {
                            trancheAgeMaxTarif = assureSession.RechercherTrancheAgeParLibelle("35-54 ans");
                        } else if (trancheAgeTarif.equalsIgnoreCase("3")) {
                            trancheAgeMaxTarif = assureSession.RechercherTrancheAgeParLibelle("55-70 ans");
                        } else if (trancheAgeTarif.equalsIgnoreCase("4")) {
                            trancheAgeMaxTarif = assureSession.RechercherTrancheAgeParLibelle("71-80 ans");
                        }
                        if (trancheAgeMaxTarif!=null){
                            System.out.println("tranche age trouvée");
                        } else {
                            System.out.println("tranche age non trouvée");
                        }
                    } catch (Exception e) {
                        message = "Erreur : l'age n'a pu être récupéreée";
                        jspAffiche = "/realiserDevisBesoins.jsp";
                    }

                    //Obetenir objet garantie
                    ObjetGarantie objGarantieHSC = null,
                     objGarantieOD = null;
                    try {
                        objGarantieHSC = assureSession.RechercherObjetGarantieParLibelle("N" + couvertureTarif);
                        objGarantieOD = assureSession.RechercherObjetGarantieParLibelle("N" + optiqueDentaireTarif);
                        TypeModule typeModuleBaseInstanceTarif = assureSession.RechercherTypeModule("Base");
                    } catch (Exception e) {
                        message = "Erreur : les niveaux de garantie n'ont pu être récupérés";
                        jspAffiche = "/realiserDevisBesoins.jsp";
                    }

                    //Obtenir Garantie 
                    List<String> listObjetGarantieHSC = Arrays.asList(new String[]{"Honoraires hospitaliers", "Forfait journalier"});
                    List<TauxGarantie> listeTauxGarantieHospitalisation = new ArrayList<TauxGarantie>();
                    List<TauxGarantie> listeTauxGarantieTotale = new ArrayList<TauxGarantie>();
                    
                    for (int i = 0; i < listObjetGarantieHSC.size(); i++) {
                        Garantie garantieInstance = assureSession.RechercherGarantieParLibelle(listObjetGarantieHSC.get(i));
                        if (garantieInstance!=null && objGarantieHSC!=null && trancheAgeMaxTarif!=null){
                            TauxGarantie txGarantiInstance = assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieHSC, garantieInstance);
                            listeTauxGarantieHospitalisation.add(txGarantiInstance);
                            listeTauxGarantieTotale.add(txGarantiInstance);
                        } else {
                            System.out.println("Erreur dans la partie Devis 1");
                            message="Erreur : aucune garantie n'a été trouvée";
                        }
                    }
                    request.setAttribute("honorairesHospitaliers", listeTauxGarantieHospitalisation.get(0));
                    request.setAttribute("forfaitJournalier", listeTauxGarantieHospitalisation.get(1));
                    
                   
                    
                    List<String> listObjetGarantieSoinsCourants = Arrays.asList(new String[]{"Honoraires médicaux", "Honoraires paramédicaux"});
                    List<TauxGarantie> listeTauxGarantieSoinsCourants = new ArrayList<TauxGarantie>();
                    for (int i = 0; i < listObjetGarantieSoinsCourants.size(); i++) {
                        Garantie garantieInstance = assureSession.RechercherGarantieParLibelle(listObjetGarantieSoinsCourants.get(i));
                        listeTauxGarantieSoinsCourants.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieOD, garantieInstance));
                        listeTauxGarantieTotale.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieHSC, garantieInstance));
                    }
                    request.setAttribute("honorairesMedicaux", listeTauxGarantieSoinsCourants.get(0));
                    request.setAttribute("honorairesParamedicaux", listeTauxGarantieSoinsCourants.get(1));

                    List<String> listObjetGarantieOD = Arrays.asList(new String[]{"Soins dentaires remboursés par la sécurité sociale", "Orthodontie remboursée par la Sécurité Sociale", "Lunettes verres simples", "Lunettes verres complexes"});
                    List<TauxGarantie> listeTauxGarantieOptiqueDentaire = new ArrayList<TauxGarantie>();
                    for (int i = 0; i < listObjetGarantieOD.size(); i++) {
                        Garantie garantieInstance = assureSession.RechercherGarantieParLibelle(listObjetGarantieOD.get(i));
                        listeTauxGarantieOptiqueDentaire.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieOD, garantieInstance));
                        listeTauxGarantieTotale.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieHSC, garantieInstance));
                    }
                    
                    request.setAttribute("soinsDentaires", listeTauxGarantieOptiqueDentaire.get(0));
                    request.setAttribute("Orthodontie", listeTauxGarantieOptiqueDentaire.get(1));
                    request.setAttribute("verresSimples", listeTauxGarantieOptiqueDentaire.get(2));
                    request.setAttribute("verresComplexes", listeTauxGarantieOptiqueDentaire.get(3));

                    System.out.println("Arriver à la recherche de modules");
                    //Recherche des modules
                        List<Modules> listeTousModules = new ArrayList<Modules>();
                        List <String> listeLibelleGarantieModules = new ArrayList <String>();
                        List <Garantie> listeGarantieDunModule = new ArrayList <Garantie>();
                        List<Modules> listeModulesTrouve = new ArrayList <Modules>();
                        listeTousModules = publiqueSession.ListerAllModules();
                        int i=0;
                        boolean WhileTrouve = false;
                        
                        
                        //Recherche du module d'hospitalisation
                        System.out.println("Recherche du module d'hospitalisation");
                        while (i<listeTousModules.size() && WhileTrouve == false){
                            listeGarantieDunModule = listeTousModules.get(i).getLesGaranties();
                            listeLibelleGarantieModules=new ArrayList<>();
                            for (int y=0; y<listeGarantieDunModule.size();y++){
                                listeLibelleGarantieModules.add(listeGarantieDunModule.get(y).getLibelleGarantie());
                            }
                            if (listeLibelleGarantieModules.containsAll(listObjetGarantieHSC) && listObjetGarantieHSC.containsAll(listeLibelleGarantieModules)) {
                                WhileTrouve = true;
                                listeModulesTrouve.add(listeTousModules.get(i));
                                System.out.println("___Module 1 trouvé");
                            }
                            i++;
                        }
                        if (WhileTrouve == false){System.out.println("___Module non trouvé");}
                        
                        
                        //Recherche du module de Soins Courants
                        System.out.println("Recherche du module de Soins Courants");
                        WhileTrouve = false;
                        i=0;
                        while (i<listeTousModules.size() && WhileTrouve == false){
                            listeGarantieDunModule = listeTousModules.get(i).getLesGaranties();
                            listeLibelleGarantieModules=new ArrayList<>();
                            for (int y=0; y<listeGarantieDunModule.size();y++){
                                listeLibelleGarantieModules.add(listeGarantieDunModule.get(y).getLibelleGarantie());
                            }
                            if (listeLibelleGarantieModules.containsAll(listObjetGarantieSoinsCourants) && listObjetGarantieSoinsCourants.containsAll(listeLibelleGarantieModules)) {
                                WhileTrouve = true;
                                listeModulesTrouve.add(listeTousModules.get(i));
                                System.out.println("___Module 2 trouvé");
                            }
                            i++;
                        }
                        if (WhileTrouve == false){System.out.println("___Module non trouvé");}
                        
                        
                        //Recherche du module d'optique dentaire
                        System.out.println("Recherche du module d'optique dentaire");
                        WhileTrouve = false;
                        i=0;
                        while (i<listeTousModules.size() && WhileTrouve == false){
                            listeGarantieDunModule = listeTousModules.get(i).getLesGaranties();
                            listeLibelleGarantieModules=new ArrayList<>();
                            for (int y=0; y<listeGarantieDunModule.size();y++){
                                listeLibelleGarantieModules.add(listeGarantieDunModule.get(y).getLibelleGarantie());
                            }
                            if (listeLibelleGarantieModules.containsAll(listObjetGarantieOD) && listObjetGarantieOD.containsAll(listeLibelleGarantieModules)) {
                                WhileTrouve = true;
                                listeModulesTrouve.add(listeTousModules.get(i));
                                System.out.println("___Module 3 trouvé");
                            }
                            i++;
                        }
                        if (WhileTrouve == false){System.out.println("___Module non trouvé");}
                    
                    
                    //Recherche du produit
                        //Recherche du produit contenant tous les modules
                        System.out.println("Recherche du produit contenant tous les modules");
                        Produit ProduitRecherche = null;
                        List<Produit> listeTousProduits = publiqueSession.ListerAllProduits();
                        if (listeTousProduits!=null){
                            WhileTrouve = false;
                            i=0;
                            while (i<listeTousProduits.size() && WhileTrouve == false){
                                List<Modules> listeModulesDunProduit = listeTousProduits.get(i).getLesModules();

                                if (listeModulesDunProduit.containsAll(listeModulesTrouve) && listeModulesTrouve.containsAll(listeModulesDunProduit)) {
                                    WhileTrouve = true;
                                    ProduitRecherche = listeTousProduits.get(i); 
                                    System.out.println("___Produit trouvé");
                                }
                                i++;
                            }
                        }
                        
                    //Cotisations 
                    //Calcul des cotisations
                    double TarifCotisation = 0;
                    for (i = 0; i < listeTauxGarantieTotale.size(); i++) {
                        TarifCotisation = TarifCotisation + ((listeTauxGarantieTotale.get(i).getTarifCotisation()* (Double.parseDouble(nbAdulteTarif))) + (listeTauxGarantieTotale.get(i).getTarifCotisation() * (Double.parseDouble(nbEnfant)) / 3) );
                        System.out.println("Cotisations="+TarifCotisation);
                    }
                    System.out.println("Cotisations totales="+TarifCotisation);
                    request.setAttribute("MontantCotisationTotale", TarifCotisation);
                    request.setAttribute("listeTxGarantie", listeTauxGarantieTotale);
                    request.setAttribute("listePersonneTampon", listeMemoireTamponPersonne);

                    
                    //ObjetGarantie du devis 
                    ObjetGarantie objGarantieDevis = null;
                    objGarantieDevis = publiqueSession.RechercherObjetGarantieParLibelle("Devis");
                    //Enregistrement du devis
                    if (objGarantieDevis!=null && ProduitRecherche!=null ){
                        if (sessionAssure!=null) {
                            devisCree = assureSession.CreerDevis("Devis_", sessionAssure, personnePubliqueDevis, sessionGestionnaire, objGarantieDevis, ProduitRecherche);
                            assureSession.AttribuerNomDevis(devisCree);
                        } else {
                            devisCree = publiqueSession.CreerDevis("Devis_", sessionAssure, personnePubliqueDevis, sessionGestionnaire, objGarantieDevis, ProduitRecherche);
                            
                        }
                        request.setAttribute("Devis", devisCree);
                    } else {
                        message = "Erreur : produit non trouvé";
                    }
                    
                    break;

                case "DemandeDevis_souscription":
                    jspAffiche = "/realiserDevisSouscription.jsp";
                    request.setAttribute("idDevis", request.getParameter("idDevis"));
                    message = "";
                    break;

                case "DemandeDevis_exportpdf":
                    String idc= request.getParameter("idDevis");
                    ContratIndividuel ContratIndivInstance = publiqueSession.RechercherContratIndivParId(Long.parseLong(idc));
                    jspAffiche = "/realiserDevisTarif.jsp";
                    List <TauxGarantie> listeTxGar = (List<TauxGarantie>) session.getAttribute("listeTxGar");
                    int idDocument = 0;
                    try {
                        idDocument = Integer.parseInt(request.getParameter(("idDocument")));
                    } catch (Exception exception) {
                    }

                    String TemplatePath = request.getServletContext().getRealPath("/WEB-INF/DevisTemplate.pdf");
                    response.setContentType("application/pdf");

                    try (PdfReader reader = new PdfReader(TemplatePath);
                            PdfWriter writer = new PdfWriter(response.getOutputStream());
                            PdfDocument document = new PdfDocument(reader, writer)) {

                        PdfPage page = document.getPage(1);
                        PdfCanvas canvas = new PdfCanvas(page);

                        FontProgram fontProgram = FontProgramFactory.createFont();
                        PdfFont font = PdfFontFactory.createFont(fontProgram, PdfEncodings.UTF8, true);
                        canvas.setFontAndSize(font, 10);

                        //Numéro du devis
                        canvas.beginText();
                        canvas.setTextMatrix(100, 753);
                        canvas.showText(Double.toString(ContratIndivInstance.getId()));
                        canvas.endText();

                        //Date du devis
                        canvas.beginText();
                        canvas.setTextMatrix(127, 737);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                        String strDate = formatter.format(ContratIndivInstance.getDateCreation());  
                        canvas.showText(strDate);
                        canvas.endText();

                        //Honnoraire Hospitalisation
                        canvas.beginText();
                        canvas.setTextMatrix(210, 655);
                        canvas.showText(Double.toString(listeTxGar.get(0).getMaxRemboursement()));
                        canvas.endText();

                        //Forfait Hospitalisation
                        canvas.beginText();
                        canvas.setTextMatrix(210, 625);
                        canvas.showText(Double.toString(listeTxGar.get(1).getMaxRemboursement()));
                        canvas.endText();

                        //Honnoraire Médicaux
                        canvas.beginText();
                        canvas.setTextMatrix(210, 560);
                        canvas.showText(Double.toString(listeTxGar.get(2).getMaxRemboursement()));
                        canvas.endText();

                        //Honnoraire Paramédicaux
                        canvas.beginText();
                        canvas.setTextMatrix(210, 500);
                        canvas.showText(Double.toString(listeTxGar.get(3).getMaxRemboursement()));
                        canvas.endText();

                        //soins dentaire
                        canvas.beginText();
                        canvas.setTextMatrix(210, 410);
                        canvas.showText(Double.toString(listeTxGar.get(4).getMaxRemboursement()));
                        canvas.endText();

                        //Orthodontie
                        canvas.beginText();
                        canvas.setTextMatrix(210, 373);
                        canvas.showText(Double.toString(listeTxGar.get(5).getMaxRemboursement()));
                        canvas.endText();

                        //Lunettes verres simples
                        canvas.beginText();
                        canvas.setTextMatrix(210, 315);
                        canvas.showText(Double.toString(listeTxGar.get(6).getMaxRemboursement()));
                        canvas.endText();

                        //Lunettes verres complexes
                        canvas.beginText();
                        canvas.setTextMatrix(210, 285);
                        canvas.showText(Double.toString(listeTxGar.get(7).getMaxRemboursement()));
                        canvas.endText();
                    }
                    message = "";
                    break;

                case "Assure_GestionContrat_ListeContrat":
                    jspAffiche = "/gestionContratMenu_Assure.jsp";
                    message = "";
                    List listeContrats = assureSession.RechercherListeContratAssure(sessionAssure);
                    if (listeContrats == null){
                        message="Aucun contrat n'a été trouvé";
                    }
                    try {
                        request.setAttribute("listeContrats", listeContrats);}
                    catch (Exception e){}
                    break;

                case "Assure_GestionContrat_resilier":
                    jspAffiche = "/resiliationContrat_Assure.jsp";
                    idc=request.getParameter("idc");
                    long idContratIndivPourRsiliation =Long.parseLong(idc);
                    ContratIndividuel contratIndivPourResiliation = assureSession.RechercherContratIndivParId(idContratIndivPourRsiliation);
                    if (contratIndivPourResiliation == null){
                        message="Aucun contrat n'a été trouvé";
                    } else {
                        request.setAttribute("contrat", contratIndivPourResiliation);
                    }

                    break;
                    
                case "Assure_GestionDocument_envoiFichier":
                    
                    // On récupère le champ du fichier
                    List<String> fileInfo = new ArrayList<String>();
                    String nomFichier, extension, newFileName;
                    Part part = request.getPart("fichier");
                    idc = request.getParameter("idc");
                    ContratIndividuel contratIndivididuelInstance = assureSession.RechercherContratIndivParId(Long.parseLong(idc));
                            
                    // On vérifie qu'on a bien reçu un fichier
                    fileInfo= getNomFichier(part,contratIndivididuelInstance);
                    nomFichier = fileInfo.get(0);
                    extension = fileInfo.get(1);

                    // Si on a bien un fichier
                    if (nomFichier != null && !nomFichier.isEmpty()) {
                        String nomChamp = part.getName();
                        
                        // On écrit définitivement le fichier sur le disque
                        //ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
                    }
                    jspAffiche = "/menuAssure.jsp";
                    message = "Le fichier a bien été envoyé";
                    
                    break;
                
                case "Assure_InformationsCompte":
                    jspAffiche = "/informationCompte_Assure.jsp";
                    message = "";
                    break;
                    
                case "Module_ListeCreation_Produit":
                    jspAffiche = "/creationProduit.jsp";
                    message = "";
                    List listeModules = gestionSession.afficherLesModules();
                    if (listeModules == null){
                        message="Aucun module n'a été trouvé";
                    }
                  try {
                        request.setAttribute("listeModules", listeModules);}
                    catch (Exception e){}
                    break;
                
                
                case "CreerProduit":
                    jspAffiche = "/creationProduit.jsp";
                    message = "";
                    String libelle = request.getParameter("libelle");
                    String fiscalite = request.getParameter("fiscalite");
                    String typeproduitpart = request.getParameter("typeproduit");
                    String domaineproduitpart = request.getParameter("domaineproduit");
                    if (libelle==null || fiscalite==null || typeproduitpart==null || domaineproduitpart==null ) {
                        message="Erreur : Au moins un des champs n'est pas rempli";
                    
                    } else {
                        Double fisc = Double.parseDouble(fiscalite);

                        DomaineProduit dp;
                        List<Modules> listemodulet = new ArrayList<>();

                        String[] lesmodules = request.getParameterValues("checkbox");
                        for (i = 0; i < lesmodules.length; i++) {
                            long values = Long.valueOf(lesmodules[i]);
                            Modules m = gestionSession.RechercherModuleParId(values);
                            listemodulet.add(m);
                        }

                        List listeModuless = gestionSession.afficherLesModules();
                        if (listeModuless == null) {
                            message = "Aucun module n'a été trouvé";
                        } else {
                            request.setAttribute("listeModules", listeModuless);
                        }

                        TypeProduit az = null;
                        if (typeproduitpart.equalsIgnoreCase("collectif")) {
                            az = TypeProduit.Collectif;
                        } else if (typeproduitpart.equalsIgnoreCase("individuel")) {
                            az = TypeProduit.Individuel;
                        }

                        dp = gestionSession.AffecterDomaineAProduit(domaineproduitpart);
                        if (dp != null) {
                            gestionSession.CreerProduit(az, libelle, fisc, dp, listemodulet);
                        } else {
                            message = "Erreur : Le domaine produit n'a pas été trouvé";
                        }
                    }
                    break;
                    
                case "Assure_ModifierMotDePasse":
                    jspAffiche = "/informationCompte_Assure.jsp";
                    String ancienMdp = request.getParameter("ancienMDP");
                    String nouveauMdp = request.getParameter("newMDP");
                    String nouveauMdpConfirmation = request.getParameter("newMDPConf");
                    if (ancienMdp==null || nouveauMdp==null || nouveauMdpConfirmation==null) {
                        message="Erreur : Au moins un des champs n'est pas rempli";
                    } else {
                        if (nouveauMdp.equals(nouveauMdpConfirmation)){
                            assureSession.ModifierMotDePasse(nouveauMdp, sessionAssure);
                            message="Votre mot de passe à bien été mit à jour";
                        } else {
                            message = "Erreur : les mots de passes saisis ne correspondent pas ";
                        }
                    }
                    break;
                    
                 case "Module_ListeCreation_Module":
                    jspAffiche = "/creationModule.jsp";
                    message = "";
                    List listeGarantie = gestionSession.afficherLesGaranties();
                    if (listeGarantie == null){
                        message="Aucun module n'a été trouvé";
                    }
                  try {
                        request.setAttribute("listeGarantie", listeGarantie);}
                    catch (Exception e){}
                    break;
                    
                case "CreerModule" : 
         
                    jspAffiche = "/creationModule.jsp";
                    message = "";
                    String libelleModule = request.getParameter("libelle");
                    System.out.println("libelle "+libelleModule);
                    String TypeModule = request.getParameter("typeModule");
                    System.out.println("tyep "+TypeModule);
                  
                    TypeModule tp;
                    List  <Garantie> listeGaranties = new ArrayList<> ();
                   
                    String [] lesGaranties 
                            = request.getParameterValues("checkbox");
                    System.out.println("les garant "+lesGaranties);
                        for ( i=0;i<lesGaranties.length;i++){
                        long values=Long.valueOf(lesGaranties[i]);
                        Garantie ga = gestionSession.RechercherGarantieParId(values);
                       listeGaranties.add(ga);
                        }
                
                    List listeGarantiee = gestionSession.afficherLesGaranties();
                     if (listeGarantiee == null){
                        message="Aucune Garantie n'a été trouvé";
                    }
                  try {
                        request.setAttribute("listeGarantie", listeGarantiee);}
                    catch (Exception e){}
                   
                  
                    
                    
                tp = gestionSession.AffecterTypeAModule(TypeModule);
                 System.out.println("Type Module "+tp);
                 gestionSession.CreerModule(libelleModule, tp, listeGaranties);
                 
                 
                    break;
                 case "Remboursement_ListeCreation_Garantie":
                    jspAffiche = "/creationGarantie.jsp";
                    message = "";
                
                    break;
                    
                
                case "CreerGarantie":
                    jspAffiche="/creationGarantie.jsp";
                    message = "";
                    
                     String libelleGarantie = request.getParameter("libelle");
                     System.out.println("libelle "+libelleGarantie);
                     String TypeRemboursement = request.getParameter("typeRemboursement");
                     System.out.println("libelle "+TypeRemboursement);
                     
                     TypeRemboursement tr;
                             
                             
                 tr = gestionSession.AffecterTypeAGarantie(TypeRemboursement);
                 System.out.println("Type Remboursement "+tr);
                 gestionSession.CreerGarantie(libelleGarantie, tr);

                 break;    

                 
                case "Assure_ModifierInformations_AffichagePage":
                    jspAffiche = "/informationCompte_Assure.jsp";
                    message="";
                    request.setAttribute("origineModification", "true");
                    break;
                
                case "Assure_ModifierInformations_Modifications":
                    jspAffiche = "/informationCompte_Assure.jsp";
                    try {
                        String adrNumModif = request.getParameter("adrNum").trim();
                        String adrRueModif = request.getParameter("adrNomRue").trim();
                        String adrCPModif = request.getParameter("adrCP").trim();
                        String adrVilleModif = request.getParameter("adrVille").trim();
                        String adrPaysModif = request.getParameter("adrPays").trim();

                        assureSession.ModifierAdresse(adrNumModif, adrRueModif, adrCPModif, adrVilleModif, adrPaysModif, sessionAssure);

                        message="Le changement d'adresse a bien été effectué";
                    } catch (Exception e){ message="Le changement d'adresse a échoué";}
                    break;
                    
                case "Assure_GestionContrat_detailContrat":
                case "Gestionnaire_GestionContrat_detailContrat":
                    jspAffiche = "/gestionContrat_DetailsContat.jsp";
                    String idContratDetail=request.getParameter("idc");
                    long idContratIndivDetail =Long.parseLong(idContratDetail);
                    ContratIndividuel contratIndivDetail = null;
                    if (sessionAssure!=null){
                        contratIndivDetail = assureSession.RechercherContratIndivParId(idContratIndivDetail);
                    } else {
                        contratIndivDetail = gestionSession.RechercherContratIndivParId(idContratIndivDetail);
                    }
                    if (contratIndivDetail == null){
                        message="Aucun contrat n'a été trouvé";
                    } else {
                        request.setAttribute("contrat", contratIndivDetail);
                        List <AyantDroit> listeAyantDroit = contratIndivDetail.getLesAyantDroits();
                        if (listeAyantDroit!=null){request.setAttribute("listeAyantDroit", listeAyantDroit);}
                    }
                    break;
                    
                case "Assure_GestionContrat_AjoutAyantDroit":
                case "Gestionnaire_GestionContrat_AjoutAyantDroit":
                case "Administrateur_GestionContrat_AjoutAyantDroit":
                    jspAffiche = "/creationParticulier.jsp";
                    String idContratAjoutAyantDroit=request.getParameter("idc");
                    System.out.println("String idContrat ="+idContratAjoutAyantDroit);
                    long idContratIndivAjoutAyantDroit = Long.parseLong(idContratAjoutAyantDroit);
                    System.out.println("long idContrat "+idContratIndivAjoutAyantDroit) ;
                    ContratIndividuel contratIndivAjoutAyantDroit = null;
                    List listeTypeAyantDroit = null;
                    if (sessionAssure!=null){
                        contratIndivAjoutAyantDroit = assureSession.RechercherContratIndivParId(idContratIndivAjoutAyantDroit);
                    } else {
                        contratIndivAjoutAyantDroit = gestionSession.RechercherContratIndivParId(idContratIndivAjoutAyantDroit);
                    }
                    if (contratIndivAjoutAyantDroit == null){
                        message="Aucun contrat n'a été trouvé";
                    } else {
                        request.setAttribute("contrat", contratIndivAjoutAyantDroit);
                        request.setAttribute("depuisInfosContrat", "true");
                        if (sessionAssure!=null){
                        listeTypeAyantDroit = assureSession.ListerAllTypeAyantDroit();
                    } else {
                        listeTypeAyantDroit = gestionSession.ListerAllTypeAyantDroit();
                    }
                        if (listeTypeAyantDroit.isEmpty()){message="Erreur : Les type d'ayant droit n'ont pas été trouvés";} 
                        else {request.setAttribute("typeAyantDroit", listeTypeAyantDroit);}
                    }
                    break;
                    
                case "Assure_VersRechercherPersonne":
                case "Gestionnaire_VersRecherchePersonne":
                case "Administrateur_VersRecherchePersonne":
                    jspAffiche = "/gestionParticulier_Recherche.jsp";
                    message="";
                    request.setAttribute("idc", request.getParameter("idc"));
                    break;
                    
                case "Assure_RechercherParticulier":
                case "Gestionnaire_RechercherParticulier":
                case "Administrateur_RechercherParticulier":
                    jspAffiche = "/gestionParticulier_Recherche.jsp";
                    message="";
                    String nssRechercheParticulier = request.getParameter("nSsPersonne");
                    List listRechercheParticulier = null;
                    if (!nssRechercheParticulier.trim().isEmpty()){
                        if (sessionAssure!=null){
                            listRechercheParticulier = assureSession.RechercherListeParticulier(nssRechercheParticulier);
                            listeTypeAyantDroit = assureSession.ListerAllTypeAyantDroit();                   
                        } else {
                            listRechercheParticulier = gestionSession.RechercherListeParticulier(nssRechercheParticulier);
                            listeTypeAyantDroit = gestionSession.ListerAllTypeAyantDroit();
                        }
                        if (listRechercheParticulier.size()==0){
                            message="Erreur : Aucune personne trouvée";
                        }
                        request.setAttribute("listeTypeAyantDroit", listeTypeAyantDroit);
                        request.setAttribute("listRechercheParticulier", listRechercheParticulier);
                        request.setAttribute("idc", request.getParameter("idc"));
                        request.setAttribute("rechercheFaite", "true");
                    } else {
                        message ="Erreur : Un des champs n'est pas rempli";
                    }
                    break;
                    
                case "Assure_AttribuerParticulierCommeAyantDroit":
                case "Gestionnaire_AttribuerParticulierCommeAyantDroit":
                case "Administrateur_AttribuerParticulierCommeAyantDroit":
                    
                    if (sessionAssure != null) {
                        jspAffiche = "/menuAssure.jsp";
                    } else if (sessionGestionnaire != null) {
                        jspAffiche = "/menuGestionnaire.jsp";
                    } else {
                        jspAffiche = "/menuAdministrateur.jsp";
                    } 
                    CompteAssure cptAssure = null;
                    idc = request.getParameter("idc");
                    String idp = request.getParameter("idp");
                    String idTypeAyantDroitString = request.getParameter("choixTypeAyantDroit");
                    if (!idc.trim().isEmpty() && !idp.trim().isEmpty() && !idTypeAyantDroitString.trim().isEmpty()) {
                        long idContratIndiv = Long.parseLong(idc);
                        ContratIndividuel contratIndiv = assureSession.RechercherContratIndivParId(idContratIndiv);
                        if (contratIndiv == null){
                            message="Aucun contrat n'a été trouvé";
                        } else {
                            cptAssure = contratIndiv.getCleCompteAssure();
                            long idParticulier = Long.parseLong(idp);
                            long idTypeAyantDroit = Long.parseLong(idTypeAyantDroitString);
                            Particulier particulierObj = null;
                            TypeAyantDroit typeAyantDroitObj = null;
                            if (sessionAssure!=null){
                                particulierObj = assureSession.RechercherParticulierParId(idParticulier);
                                if (assureSession.RechercherAyantDroitParCleparticulier(particulierObj, contratIndiv) == null){
                                    typeAyantDroitObj = assureSession.RechercherTypeAyantDroitParId(idTypeAyantDroit);
                                    assureSession.CreerAyantDroit(typeAyantDroitObj, particulierObj, contratIndiv);
                                    message = ("Ayant droit bien attribué à votre contrat N°"+idc);
                                }
                                else {
                                    message="Erreur : l'ayant droit existe déjà";
                                    request.setAttribute("idc", idc);
                                    jspAffiche = "/gestionParticulier_Recherche.jsp";
                                } 
                            } else {
                                particulierObj = gestionSession.RechercherParticulierParId(idParticulier);
                                typeAyantDroitObj = gestionSession.RechercherTypeAyantDroitParId(idTypeAyantDroit);
                                gestionSession.CreerAyantDroit(typeAyantDroitObj, particulierObj, contratIndiv);
                            }
                            
                        }
                    } else {
                        message="Erreur : un des paramètres est manquant";
                        request.setAttribute("idc", idc);
                        jspAffiche = "/gestionParticulier_Recherche.jsp";
                    }       
                    break;
                    
                case "Assure_GestionContrat_SuppressionAyantDroit":
                case "Gestionnaire_GestionContrat_SuppressionAyantDroit":
                case "Administrateur_GestionContrat_SuppressionAyantDroit":
                    ContratIndividuel idcInstance = null;
                    idc =  request.getParameter("idc");
                    request.setAttribute("idc",idc);
                    idp = request.getParameter("idp");
                    long idParticulier = Long.parseLong(idp);
                    Particulier particulierInstance = null;
                    AyantDroit ayantDroitInstance = null;
                    if (sessionAssure != null) {
                        particulierInstance = assureSession.RechercherParticulierParId(idParticulier);
                        idcInstance = assureSession.RechercherContratIndivParId(Long.parseLong(idc));
                    } else {
                        particulierInstance = gestionSession.RechercherParticulierParId(idParticulier);
                        idcInstance = gestionSession.RechercherContratIndivParId(Long.parseLong(idc));
                    }

                    message = "Erreur : Un problème est survenu pendant la suppression";

                    if (particulierInstance != null) {
                        if (!idp.trim().isEmpty()) {
                            if (sessionAssure != null) {
                                ayantDroitInstance = assureSession.RechercherAyantDroitParCleparticulier(particulierInstance, idcInstance);
                            } else {
                                ayantDroitInstance = gestionSession.RechercherAyantDroitParCleparticulier(particulierInstance, idcInstance);
                            }
                            if (ayantDroitInstance != null) {
                                try {
                                    if (sessionAssure != null) {
                                        assureSession.SupprimerAyantDroit(ayantDroitInstance);
                                    } else {
                                        gestionSession.SupprimerAyantDroit(ayantDroitInstance);
                                    }
                                    if (sessionAssure != null) {
                                        jspAffiche = "/menuAssure.jsp";
                                    } else if (sessionGestionnaire != null) {
                                        jspAffiche = "/menuGestionnaire.jsp";
                                    } else {
                                        jspAffiche = "/menuAdministrateur.jsp";
                                    }
                                    message = "Ayant droit supprimé avec succés, l'affichage sera mis à jour au prochain lancement";
                                } catch (Exception e) {
                                    if (sessionAssure != null) {
                                        jspAffiche = "/menuAssure.jsp";
                                    } else if (sessionGestionnaire != null) {
                                        jspAffiche = "/menuGestionnaire.jsp";
                                    } else {
                                        jspAffiche = "/menuAdministrateur.jsp";
                                    }
                                    message = "Erreur : Un problème est survenu pendant la suppression";
                                }
                            } else {
                                message = "Ayant droit non trouvé";
                                if (sessionAssure != null) {
                                    jspAffiche = "/menuAssure.jsp";
                                } else if (sessionGestionnaire != null) {
                                    jspAffiche = "/menuGestionnaire.jsp";
                                } else {
                                    jspAffiche = "/menuAdministrateur.jsp";
                                }
                            }
                        }
                    }
                    break;
                    

                case "Morale_GestionContrat_ListeContrat":
                    jspAffiche = "/gestionContratMenu_Morale.jsp";
                    message = "";
                    
                  
                            
                    List listeContratsM = assureSession.RechercherListeContratMorale(sessionEntreprise);
                    if (listeContratsM == null){
                        message="Aucun contrat n'a été trouvé";
                    }
                    try {
                        request.setAttribute("listeContratsM", listeContratsM);}
                    catch (Exception e){}
                    break;
               
                case "Morale_Modification_Rib":
                    jspAffiche = "/modificationRibMorale.jsp";
                    message = "";
                    
                    break;  
                    
                         
                case "Collectif_GestionContrat_detailContrat":
                case "GestionnaireM_GestionContrat_detailContrat":
                    jspAffiche = "/gestionContratCollectif_DetailsContrat.jsp";
                    message = "";
                    idc=request.getParameter("idc");
                    System.out.println("String Contrat detail " +idc);
                     
                    long idContratCollectifDetail =Long.parseLong(idc);
                    System.out.println("Long Contrat detail " +idContratCollectifDetail);
                    ContratCollectif contratCollectifDetail = null;
                  
                    
                   // if (sessionEntreprise!=null){
                        contratCollectifDetail = assureSession.RechercherContratCollectifParId(idContratCollectifDetail);
                        System.out.println("Parti 1");
                   /* } else {
                        contratCollectifDetail = gestionSession.RechercherContratCollectifParId(idContratCollectifDetail);
                        System.out.println("Parti 2");*/
                        //}
                   /* if (contratCollectifDetail == null){
                        message="Aucun contrat n'a été trouvé";
                        System.out.println("Parti 3");
                    } else {*/
                        request.setAttribute("contrat", contratCollectifDetail);
                        System.out.println("Parti 4");
                        
                        List <ContratIndividuel> listeContratIndiv = contratCollectifDetail.getContratIndividuels();
                        if (listeContratIndiv!=null){
                            request.setAttribute("listeContratIndiv", listeContratIndiv);
                            System.out.println("Parti 5");
                        }
                    
                    break;
                
                    
                    
                case "Gestionnaire_ListeContrat":
                    jspAffiche = "/listeContratRealiseGestionnaire.jsp";
                    message = "";
                    List listeContratsR = gestionSession.RechercherContratIndividuel();
                    if (listeContratsR == null){
                        message="Aucun contrats n'a été trouvé";
                    }
                  try {
                        request.setAttribute("listeContratsR", listeContratsR);}
                    catch (Exception e){}
                    break;
                    
                case "RechercherContratGestionnaireBouton":
                    jspAffiche = "/informationContratRechercherGestionnaire.jsp";
                    message = "";
                    
                    
                     String id = request.getParameter("idcontrat");
                     long idd = Long.parseLong(id);
                    if (id==null ) {
                        message="Erreur : Le champs Id n'est pas rempli";
                    
                    } else {
                     ContratIndividuel ci;
                     ci = gestionSession.RechercherContratIndivParId(idd);
                     if (ci == null) {
                            message = "Aucun contrat n'a été trouvé";
                        } else {
                            request.setAttribute("contrat", ci);
                             List <AyantDroit> listeAyantDroit = ci.getLesAyantDroits();
                             if (listeAyantDroit!=null){request.setAttribute("listeAyantDroit", listeAyantDroit);}
                        }
                    }
                    break;
                    
                    case "RechercherContratGestionnaireListe":
                  jspAffiche = "/informationContratRechercherGestionnaire.jsp";
                    message = "";
                    String idContrat=request.getParameter("idc");
                    long idContratd =Long.parseLong(idContrat);
                    
                    if (idContrat==null ) {
                        message="Erreur : Le champs Id n'est pas rempli";
                    } else {
                     ContratIndividuel ci;
                     ci = gestionSession.RechercherContratIndivParId(idContratd);
                     if (ci == null) {
                            message = "Aucun contrat n'a été trouvé";
                        } else {
                            request.setAttribute("contrat", ci);
                            List <AyantDroit> listeAyantDroit = ci.getLesAyantDroits();
                            if (listeAyantDroit!=null){request.setAttribute("listeAyantDroit", listeAyantDroit);}
                        }
                    }
                    break;
                    
                
                    
                case "ChoixValidationGestionnaire":
                    jspAffiche = "/listeChoixGestionnaireAttenteValidation.jsp";
                    message = "";
                    break;
                 
                    
                     
                case "RechercherContratIndivAttenteGestionnaireListe":
                    jspAffiche = "/listeContratIndivAttenteGestionnaire.jsp";
                    message = "";
                    String typecontr = "Enattentevalidation";
                      if (typecontr==null  ) {
                        message="Erreur : Le champ de type n'est pas rempli";
                    
                    } else {
                    
                       StatutContrat az = null;
                       typecontr.equalsIgnoreCase("Enattentevalidation");
                        az = StatutContrat.Enattentevalidation;
                        
               
                    
                    List listeContratsRs = gestionSession.RechercherContratIndividuelAttente(az);
                    if (listeContratsRs == null){
                        message="Aucun contrats n'a été trouvé";
                    }
                          System.out.println("contrat" + listeContratsRs);
                  try {
                        request.setAttribute("listeContratsRs", listeContratsRs);}
                    catch (Exception e){}
                      }
                      
                    break;                              
                
                           
                case "RechercherContratAdhesionAttenteGestionnaireListe":
                    jspAffiche = "/listeContratAdhesionAttenteGestionnaire.jsp";
                    message = "";
                    String typecontrr = "Enattentevalidation";
                      if (typecontrr==null  ) {
                        message="Erreur : Le champ de type n'est pas rempli";
                    
                    } else {
                    
                       StatutContrat az = null;
                     typecontrr.equalsIgnoreCase("AttenteAdhesion");
                            az = StatutContrat.AttenteAdhesion;
                        
               
                    
                    List listeContratsRsr = gestionSession.RechercherContratIndividuelAttente(az);
                    if (listeContratsRsr == null){
                        message="Aucun contrats n'a été trouvé";
                    }
                          System.out.println("contrat" + listeContratsRsr);
                  try {
                        request.setAttribute("listeContratsRsr", listeContratsRsr);}
                    catch (Exception e){}
                      }
                      
                    break;                              
                    
                case "RechercherRIBAttenteGestionnaireListe":
                    jspAffiche = "/listeRIBAttenteGestionnaire.jsp";
                    message = "";
                    TypeFichier t;
                    
                    String nomf = "png"; 
                    
                    t = gestionSession.RechercherFichierLibelle(nomf);
                   List listeFichier = gestionSession.RechercherFichierParIdTransactionRIB(t);
                   
                    
                 
                    
                    
                    if (listeFichier  == null){
                        message="Aucun contrats n'a été trouvé";
                    }
                    
                    
                    
                   
                          System.out.println("fichier" + listeFichier );
                    try {
                        request.setAttribute("listeFichier", listeFichier );}
                    catch (Exception e){}
                      
                      
                    break;                              
                 
                    
                case "RechercherChargeAttenteGestionnaireListe":
                    jspAffiche = "/listeChargeAttenteGestionnaire.jsp";
                    message = "";
                    //String nomfc = "Soin";
                    //String typefichierc ="Attente";
                    StatutTransaction stat; 
                    
                    stat = StatutTransaction.EnAttente;
                    
                    
                    List listetransa = gestionSession.ListeTransactionAttente(stat);
                   
                    
                   /* TypeFichier a;
                    a = gestionSession.RechercherTypeRIBouChargeAttente(typefichier);
                          
                      System.out.println("Type" +a);
                    
                      List listeFichier = gestionSession.RechercherRIBouChargeAttente(a);*/
                    
                    if (listetransa == null){
                        message="Aucun contrats n'a été trouvé";
                    }
                          System.out.println("fichier" +listetransa );
                  try {
                        request.setAttribute("listeFichiers", listetransa);}
                    catch (Exception e){}
                      
                      
                    break;  
                    
                    
                    
                    
                    
                    
                      
                case "ModificationContratIndivStatutGestionnaire":
                    jspAffiche = "/modifierContratIndivStatutGestionnaire.jsp";
                    
                    String idContratv =request.getParameter("idc");
                    long idContratvv =Long.parseLong(idContratv);
                    
                    ContratIndividuel contratIndivValidation;
                  
                        contratIndivValidation = gestionSession.RechercherContratIndivParId(idContratvv);
                    System.out.println("Contrat"+contratIndivValidation);
                    
                        request.setAttribute("contrat", contratIndivValidation);
                        List <AyantDroit> listeAyantDroits = contratIndivValidation.getLesAyantDroits();
                        if (listeAyantDroits!=null){request.setAttribute("listeAyantDroits",listeAyantDroits);}
                        System.out.println("list"+listeAyantDroits);
                    break;
               
                case "ModificationvalidationContratStatutGestionnaireIndiv":
                    jspAffiche = "/listeChoixGestionnaireAttenteValidation.jsp";
                   String idContratO =request.getParameter("idc");
                    long idContratOu =Long.parseLong(idContratO);
                   
                    ContratIndividuel contratIndivValidationOui = null;
                 
                     java.util.Date d1 = new java.util.Date();
                    java.sql.Date d2 = new java.sql.Date(d1.getTime());

                    
                     String libellee ;
                  
                      contratIndivValidationOui = gestionSession.RechercherContratIndivParId(idContratOu);
                      System.out.println("contrat indiv cher" + contratIndivValidationOui);
                      
                   if ( contratIndivValidationOui.getCleContratCollectif()== null)
                      { libellee = "Contrat valider par le gestionnaire";
                      }
                      
                      else {
                          libellee = "Adhésion valider par le gestionnaire";
                      }                      
                  
                      
                      gestionSession.ModifierContratStatutActifIndiv(idContratOu);
                      System.out.println("Changement"+contratIndivValidationOui);
                      
                      gestionSession.CreerEvenement(libellee, d2, contratIndivValidationOui);
                      
                    
                      
                       
                    break;
                    
                case "DemandeDevis_RealisationContratIndiv":
                    message="";
                    if (sessionAssure != null) {
                        jspAffiche = "/menuAssure.jsp";
                    } else if (sessionGestionnaire != null) {
                        jspAffiche = "/menuGestionnaire.jsp";
                    } else if (sessionEntreprise != null) {
                        jspAffiche = "/menuEntreprise.jsp";
                    } else if (sessionAdministrateur != null) {
                        jspAffiche = "/menuAdministrateur.jsp";
                    } else {
                        jspAffiche = "/accueilPublic.jsp";
                    }
                    
                    String emailDevis, adrDevis, telDevis;
                    Particulier partA1,partA2,partE1,partE2,partE3;
                    cptAssure=null;
                    
                    listeMemoireTamponPersonne = (List<MemoireTamponPersonne>) session.getAttribute("listePersonneTampon");
                    String idDevis = request.getParameter("idDevis");
                    ContratIndividuel devisInstance = publiqueSession.RechercherContratIndivParId(Long.parseLong(idDevis));
                    
                    System.out.println("Chargement des données communes");
                    if (devisInstance.getClePersonnePublique()!=null) {
                        emailDevis = devisInstance.getClePersonnePublique().getEmail();
                        adrDevis = devisInstance.getClePersonnePublique().getAdresse();
                        telDevis = devisInstance.getClePersonnePublique().getnTelephone();
                    } else {
                        emailDevis = devisInstance.getCleCompteAssure().getCleParticulier().getEmail();
                        adrDevis = devisInstance.getCleCompteAssure().getCleParticulier().getAdresse();
                        telDevis = devisInstance.getCleCompteAssure().getCleParticulier().getnTelephone();
                    }
                    
                    System.out.println("Chargement des données individuelles");
                    if (devisInstance.getClePersonnePublique()!=null) {
                        PersonnePublique pPublique = devisInstance.getClePersonnePublique();
                        String nSsA1 = request.getParameter("nSSA1");
                        partA1 = publiqueSession.CreerParticulier(pPublique.getNom(), pPublique.getPrenom(), pPublique.getGenre(),pPublique.getDateNaissance(), nSsA1, emailDevis, telDevis, adrDevis);
                        String mdp1A1 = request.getParameter("mdp");
                        String mdp2A1 = request.getParameter("mdp2");
                        if((mdp1A1!=null && mdp2A1!=null) && (mdp1A1.equals(mdp2A1))) {
                            regimeA1 = request.getParameter("selectRegimeA1");
                            if (regimeA1!=null) {
                                RegimeSocial regimeA1Instance = publiqueSession.RechercherRegimeSocial(regimeA1);
                                System.out.println("regime social recherché");
                                if (regimeA1Instance!=null) {
                                    System.out.println("regime social trouvé");
                                    cptAssure = publiqueSession.CreerCompteAssure(mdp1A1, partA1, regimeA1Instance);
                                    System.out.println("Compte assure créé");
                                }
                            } else {
                                message="Erreur : Regime social non sélectionné";
                            }
                        } else {
                            message="Erreur : les mots de passe ne correspondent pas";
                        }
                    }
                    
                    //Partie Paiement 
                    System.out.println("Chargement des données de paiement");
                    ChoixPaiement choixPaiementInstance;
                    String periodePaiement = request.getParameter("periodePaiement");
                    if (periodePaiement.equalsIgnoreCase("Mensuel")) {
                        choixPaiementInstance = ChoixPaiement.Mensuel;
                    } else if (periodePaiement.equalsIgnoreCase("Trimestriel")) {
                        choixPaiementInstance = ChoixPaiement.Trimestriel;
                    } else {
                        choixPaiementInstance = ChoixPaiement.Annuel;
                    }
                    
                    
                    
                    //Création du contrat
                    System.out.println("Creation du contrat");
                    CompteEmploye cptEmployeInstance=null;
                    ContratIndividuel contratIndividuelInstance=null;
                    if (cptAssure!=null){
                        contratIndividuelInstance = publiqueSession.CreerContratIndividuelPersonnePublique("Contrat_Temporaire",choixPaiementInstance, cptEmployeInstance, devisInstance, cptAssure);
                    }  else {
                         contratIndividuelInstance = assureSession.CreerContratIndividuel("Contrat_Temporaire",choixPaiementInstance, cptEmployeInstance, devisInstance);
                    }
                    
                    
                    //Partie fichier pour le rib 
                    System.out.println("Gestion du fichier transmi");

                    
                    String projectPathStart = request.getServletContext().getRealPath("");
                    String[] projectPathStep = projectPathStart.split("dist/gfdeploy/DRAJAK/DRAJAK-war_war");
                    String finallyProjectPath = projectPathStep[0]+"DRAJAK-war/web/WEB-INF/FichiersGeneres/";
                    part = request.getPart("fichier");
                    if (contratIndividuelInstance!=null) {
                       fileInfo = getNomFichier(part, contratIndividuelInstance);
                        nomFichier = fileInfo.get(0);
                        extension = fileInfo.get(1);
                        // Si on a bien un fichier
                        if (nomFichier != null && extension != null && !nomFichier.isEmpty()) {
                            // On écrit définitivement le fichier sur le disque
                            newFileName = nomFichier+extension;
                            ecrireFichier(part, newFileName, finallyProjectPath );
                            
                            //On enregistre le chemin du fichier en base de données
                            TypeFichier typeFichierInstance = publiqueSession.RechercherTypeFichierParLibelle(extension.substring(1));
                            if (typeFichierInstance!=null) {
                                System.out.println("typeFichier trouvé");
                                publiqueSession.CreerFichier(nomFichier, typeFichierInstance,finallyProjectPath+newFileName ,contratIndividuelInstance);
                            }
                            
                            //On enregsitre un nouvel évènement
                            publiqueSession.CreerEvenement("Demande de validation de RIB", contratIndividuelInstance);
                        }
                    }
                    
                    System.out.println("Enregistrement des ayant droit");
                    typeAdInstance=null;
                    if (devisInstance!=null) {       
                        if (listeMemoireTamponPersonne!= null) {
                            for (i=0;i<listeMemoireTamponPersonne.size();i++) {
                                if (listeMemoireTamponPersonne.get(i).getNature().equals("Adulte2")){
                                    Genre genreA2 =listeMemoireTamponPersonne.get(i).getGenre();
                                    Date dobA2 = listeMemoireTamponPersonne.get(i).getDateNaissance();
                                    String nomA2 = request.getParameter("adulte2Nom");
                                    String prenomA2 = request.getParameter("adulte2Prenom");
                                    String nSsA2 = request.getParameter("adulte2Nss");
                                    if( genreA2!=null && dobA2!=null && nomA2!=null && prenomA2!=null && nSsA2!=null){
                                        particulierDevis = publiqueSession.CreerParticulier(nomA2, prenomA2, genreA2, dobA2, nSsA2, emailDevis, telDevis, adrDevis);
                                        if(genreA2.equals(Genre.Femme)) {
                                             typeAdInstance = publiqueSession.RechercherTypeAyantDroitParLibelle("Conjointe");
                                        } else {
                                            typeAdInstance = publiqueSession.RechercherTypeAyantDroitParLibelle("Conjoint");
                                        }
                                        publiqueSession.CreerAyantDroit(typeAdInstance, particulierDevis, contratIndividuelInstance);
                                    } else {
                                        message="Erreur : Des informations sont manquantes pour le deuxième adulte";
                                    }
                                }
                                if (listeMemoireTamponPersonne.get(i).getNature().equals("Enfant1")){
                                    Genre genreE1 =listeMemoireTamponPersonne.get(i).getGenre();
                                    Date dobE1 = listeMemoireTamponPersonne.get(i).getDateNaissance();
                                    String nomE1 = request.getParameter("enfant1Nom");
                                    String prenomE1 = request.getParameter("enfant1Prenom");
                                    String nSsE1 = request.getParameter("enfant1Nss");
                                    if( genreE1!=null && dobE1!=null && nomE1!=null && prenomE1!=null && nSsE1!=null){
                                        particulierDevis = publiqueSession.CreerParticulier(nomE1, prenomE1, genreE1, dobE1, nSsE1, emailDevis, telDevis, adrDevis);
                                        typeAdInstance = publiqueSession.RechercherTypeAyantDroitParLibelle("Enfant");
                                        publiqueSession.CreerAyantDroit(typeAdInstance, particulierDevis, contratIndividuelInstance);
                                    } else {
                                        message="Erreur : Des informations sont manquantes pour le premier enfant";
                                    }
                                }
                                if (listeMemoireTamponPersonne.get(i).getNature().equals("Enfant2")){
                                    Genre genreE2 =listeMemoireTamponPersonne.get(i).getGenre();
                                    Date dobE2 = listeMemoireTamponPersonne.get(i).getDateNaissance();
                                    String nomE2 = request.getParameter("enfant2Nom");
                                    String prenomE2 = request.getParameter("enfant2Prenom");
                                    String nSsE2 = request.getParameter("enfant2Nss");
                                    if( genreE2!=null && dobE2!=null && nomE2!=null && prenomE2!=null && nSsE2!=null){
                                        particulierDevis = publiqueSession.CreerParticulier(nomE2, prenomE2, genreE2, dobE2, nSsE2, emailDevis, telDevis, adrDevis);
                                        typeAdInstance = publiqueSession.RechercherTypeAyantDroitParLibelle("Enfant");
                                        publiqueSession.CreerAyantDroit(typeAdInstance, particulierDevis, contratIndividuelInstance);
                                    } else {
                                        message="Erreur : Des informations sont manquantes pour le deuxième enfant";
                                    }
                                }
                                if (listeMemoireTamponPersonne.get(i).getNature().equals("Enfant3")){
                                    Genre genreE3 =listeMemoireTamponPersonne.get(i).getGenre();
                                    Date dobE3 = listeMemoireTamponPersonne.get(i).getDateNaissance();
                                    String nomE3 = request.getParameter("enfant3Nom");
                                    String prenomE3 = request.getParameter("enfant3Prenom");
                                    String nSsE3 = request.getParameter("enfant3Nss");
                                    if( genreE3!=null && dobE3!=null && nomE3!=null && prenomE3!=null && nSsE3!=null){
                                        particulierDevis = publiqueSession.CreerParticulier(nomE3, prenomE3, genreE3, dobE3, nSsE3, emailDevis, telDevis, adrDevis);
                                        typeAdInstance = publiqueSession.RechercherTypeAyantDroitParLibelle("Enfant");
                                        publiqueSession.CreerAyantDroit(typeAdInstance, particulierDevis, contratIndividuelInstance);
                                    } else {
                                        message="Erreur : Des informations sont manquantes pour le troisième enfant";
                                    }
                                }
                            }
                        }
                    } else {
                        message="Erreur : Aucun devis n'a été trouvé";
                    }
                    
                    break;
                        
                
                case "ModificationrefusContratStatutGestionnaireIndiv": 
                    jspAffiche = "/listeChoixGestionnaireAttenteValidation.jsp";
                    String idContratOo =request.getParameter("idc");
                    long idContratOuo =Long.parseLong(idContratOo);
                    String ddd = request.getParameter("dateevenement");
                    
                  java.util.Date d11 = new java.util.Date();
                    java.sql.Date d22 = new java.sql.Date(d11.getTime());

                    
               
            
            
            
                     String libelleee ;
                     
                    
                    ContratIndividuel contratIndivValidationOuii = null;
                      
                  
                      contratIndivValidationOuii = gestionSession.RechercherContratIndivParId(idContratOuo);
                      System.out.println("contrat indiv cher" + contratIndivValidationOuii);
                      
                      if ( contratIndivValidationOuii.getCleContratCollectif()== null)
                      { libelleee = "Contrat refuser par le gestionnaire";
                      }
                      
                      else {
                          libelleee = "Adhésion refuser par le gestionnaire";
                      }                      
                  
                      
                      
                      gestionSession.ModifierContratStatutRefuserIndiv(idContratOuo);
                      System.out.println("Changement"+contratIndivValidationOuii);
                       gestionSession.CreerEvenement(libelleee, d22, contratIndivValidationOuii);
                     
                      
                      
                       
                    break;
                    
                 
                      
                    
                      
           
                    
                case "ModificationFichierStatutGestionnaire":
                    jspAffiche = "/modifierFichierStatutGestionnaire.jsp";
                    
                    String idContratvef =request.getParameter("idc");
                    long idContratf =Long.parseLong(idContratvef);
                         System.out.println("idc" +idContratvef);
                    Fichier contratIndivValidationf;
                    Transactions td;
                  
                    td = gestionSession.RechercherTransactionParID(idContratf);
                    request.setAttribute("contrat",td);
                    
                    contratIndivValidationf = gestionSession.RechercherFichierParIdTransaction(idContratvef);
                     request.setAttribute("fichier",contratIndivValidationf);
                    
                    
                    
                    System.out.println("contrat"+contratIndivValidationf);
                    break;
                    
                 case "ModificationFichierRIBStatutGestionnaire":
                    jspAffiche = "/modifierFichierStatutGestionnaire.jsp";
                    
                    String idContratvff =request.getParameter("idc");
                    long idContratff =Long.parseLong(idContratvff);
                         System.out.println("idc" +idContratvff);
                    Fichier contratIndivValidationff;
                  
                    
                    contratIndivValidationff = gestionSession.RechercherFichierParId(idContratff);;
                     request.setAttribute("fichier",contratIndivValidationff);
                    
                    
                    
                    break;
                    
                    
                    
                case "ModificationvalidationRIBStatutGestionnaire":
                    jspAffiche = "/listeChoixGestionnaireAttenteValidation.jsp";
                   String idcvc =request.getParameter("idc");
                    long idfcc =Long.parseLong(idcvc);
                    String libelleasupp = "A DEFINIR AVEC CLEMENT";
                    String libelleevnemente = "Contrat Validé";
                    String nomff ="RIB"; 
                  
                  Evenement e;
                    
                  ContratIndividuel  contrate;   
                  Fichier f;
                  
                  java.util.Date d1111 = new java.util.Date();
                  java.sql.Date dateevenemente = new java.sql.Date(d1111.getTime());
                  
                  f = gestionSession.RechercherFichierParId(idfcc);
                  Contrat c = f.getCleContrat();
            
                  
                  contrate = gestionSession.RechercherContratIndivParIdContrat(c);
                  
                  System.out.println("contrat indiv cher");
                  
                  
                      
                  e = gestionSession.RechercherEvenementSupprimer(contrate, libelleasupp);
                  
                   gestionSession.ModifierEvenementRIBValider(contrate, libelleevnemente, dateevenemente);
                   
                  
                       
                    break;
                    
                    
                      case "ModificationrefusRIBStatutGestionnaire":
                    jspAffiche = "/listeChoixGestionnaireAttenteValidation.jsp";
                   String idcontrat=request.getParameter("idc");
                    long idcontrate =Long.parseLong(idcontrat);
                   
                    String libelleevnement = "RIB refusé";
                 
                    
                   ContratIndividuel  contrat;   
                    Fichier ff;
                  
                  java.util.Date d111 = new java.util.Date();
                  java.sql.Date dateevenement = new java.sql.Date(d111.getTime());
                  
                  
                  
                   ff = gestionSession.RechercherFichierParId(idcontrate);
                  Contrat cc = ff.getCleContrat();
                  
                  
                  
                       contrat = gestionSession.RechercherContratIndivParIdContrat(cc);
                      System.out.println("contrat indiv cher");
                      
                      gestionSession.ModifierEvenementRIBValider(contrat, libelleevnement, dateevenement);
                      
                      
                      
                     
                      
                       
                    break;
                    
                    
                      case "ModificationvalidationChargeStatutGestionnaire":
                    jspAffiche = "/listeChoixGestionnaireAttenteValidation.jsp";
                   String idfic =request.getParameter("idc");
                   String libe =request.getParameter("libelle");
                   StatutTransaction st;
                   libe = "test1";

                    long idfichierc =Long.parseLong(idfic);
                    Transactions ta;
                   
                   
                    st = StatutTransaction.Remboursé;
                         
                      ta = gestionSession.RechercherTransactionParID(idfichierc);
                     
                      
                      gestionSession.ModifierTransaction(ta,st,libe);
                    
                      
                      
                       
                    break;
                    
                      case "ModificationrefusChargeStatutGestionnaire":
                    jspAffiche = "/listeChoixGestionnaireAttenteValidation.jsp";
                   String idficc =request.getParameter("idc");
                    long idfichiercc =Long.parseLong(idficc);
                    String libee =request.getParameter("libelle");
                   StatutTransaction sts;
                   Transactions taa;
                   
                   sts = StatutTransaction.Refusé;
                         
                      taa = gestionSession.RechercherTransactionParID(idfichiercc);
                      //fichierrc = gestionSession.RechercherFichierParId(idfichierc);
                    
                      gestionSession.ModifierTransaction(taa,sts,libee);
                     
                   
                       
                    break;
                    
                    
                    case "ModificationGestionnaire":
                    jspAffiche = "/modifierGestionnaire.jsp";
                    
                    String idContratvzff = request.getParameter("idc");
                    long idCon = Long.parseLong(idContratvzff);
                         System.out.println("idc" +idCon);
                         
                      
                    CompteEmploye cy;
                  
                    cy = gestionSession.RechercherGestionnaireParId(idCon);
                    request.setAttribute("gest",cy);
                    
                    System.out.println("gest"+cy);
                    break;
                    
                  
                    
                    
                     case "ModificationGestionnaireAdresseTel":
                    jspAffiche = "/modificationGestionnaire.jsp";
                    
                   String idfico =request.getParameter("idc");
                    long idce =Long.parseLong(idfico);
                    
                        String adrNumModif = request.getParameter("adrNum").trim();
                        String adrRueModif = request.getParameter("adrNomRue").trim();
                        String adrCPModif = request.getParameter("adrCP").trim();
                        String adrVilleModif = request.getParameter("adrVille").trim();
                        String adrPaysModif = request.getParameter("adrPays").trim();
                        
                        String numt =request.getParameter("adrNumtel");

                    
                 
                   CompteEmploye cpe;
                    
                  cpe = gestionSession.RechercherGestionnaireParId(idce);
                      System.out.println("ce" + cpe);
                      
                      gestionSession.ModifierGestionnaireAdresse(adrNumModif,adrRueModif,adrCPModif,adrVilleModif,adrPaysModif,cpe);
                      gestionSession.ModifierGestionnaireTelephone(numt,cpe);
                      
                      
               
                  break;
                    
                 /*case "ModificationGestionnaireNum":
                    jspAffiche = "/modificationGestionnaire.jsp";
                    
                   String idficoo =request.getParameter("idc");
                    long idces =Long.parseLong(idficoo);
                    String numt =request.getParameter("num");
                    
                 
                   CompteEmploye cpee = null;
                    
                  cpee = gestionSession.RechercherGestionnaireParId(idces);
                      System.out.println("ce" + cpee);
                      
                      gestionSession.ModifierGestionnaireTelephone(numt,cpee);
                      
                      
               
                  break;*/
                    
                  

            }
            
        }
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspAffiche);
        request.setAttribute("message", message);
        Rd.forward(request, response);
        System.out.println("Assuré : " + sessionAssure + ", Administrateur : " + sessionAdministrateur + ", Entreprise : " + sessionEntreprise + ", Gestionnaire : " + sessionGestionnaire);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(menuDrajak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(menuDrajak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected int doActionCalculerAge(Date DOB, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date currentDate = new Date();
        Calendar a = getCalendar(DOB);
        Calendar b = getCalendar(currentDate);
        int age = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH)
                || (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            age--;
        }
        return age;
    }
    
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private static List<String> getNomFichier( Part part, ContratIndividuel contrat) {
        String nomFichier, extension;
        List<String> infosFichier = new ArrayList<String>();
        String contentDisposition = part.getSubmittedFileName();
        extension = contentDisposition.substring(contentDisposition.lastIndexOf("."));
        if (part!=null && extension!=null) {
            nomFichier = contrat.getLibelleContrat()+"_RIB";
            infosFichier.add(nomFichier);
            infosFichier.add(extension);
        } 
        return infosFichier;
    } 
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        cal.setTime(date);
        return cal;
    }
    
    private static void close(Connection myConn, Statement myStmt)
			throws SQLException {

		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

}
