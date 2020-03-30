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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author clementratz
 */
@WebServlet(name = "menuDrajak", urlPatterns = {"/menuDrajak"})
public class menuDrajak extends HttpServlet {

    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "/Users/mateo21/fichiers/"; // A changer
    
    @EJB
    private GestionSessionLocal gestionSession;

    @EJB
    private AssureSessionLocal assureSession;

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

        if ((sessionAssure != null && sessionGestionnaire != null && sessionEntreprise != null && sessionAdministrateur != null) || (sessionAssure == null && sessionGestionnaire == null && sessionEntreprise == null && sessionAdministrateur == null && act != null && !act.equals("") && !act.equals("AssureMenu") && !act.equals("GestionnaireMenu") && !act.equals("EntrepriseMenu") && !act.equals("AdministrateurMenu") && !act.equals("AssureAuthentification") && !act.equals("GestionnaireAuthentification") && !act.equals("EntrepriseAuthentification") && !act.equals("AdministrateurAuthentification") && !act.equals("Deconnexion") && !act.equals("DemandeDevis_besoins") && !act.equals("DemandeDevis_infos") && !act.equals("DemandeDevis_tarif") && !act.equals("DemandeDevis_souscription") && !act.equals("DemandeDevis_exportpdf") )) {
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
                    //message = "Gestionnaire créé avec succès !";
                    //request.setAttribute("messsage", message);
                    break;

                case "Assure_CreerParticulier":
                case "Gestionnaire_CreerParticulier":
                case "Administrateur_CreerParticulier":
                    String numRueNewPersonne, nomRueNewPersonne,cpNewPersonne,villeNewPersonne,paysNewPersonne, adresseNewPersonne=null;
                    String nomPart=null, prenomPart=null, dateNaissancePart = null, numeroPart=null, genrePart =null, numSSPart=null,mailPart=null;
                    String origineCreationParticulier = request.getParameter("origine");
                    String idContratHidden = request.getParameter("idContratHidden");
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
                            }
                            nomPart = request.getParameter("nom");
                            prenomPart = request.getParameter("prenom");
                            dateNaissancePart = request.getParameter("dateNaissance");
                            genrePart = request.getParameter("genre");
                            numSSPart = request.getParameter("numeroSS");
                        }
                        catch (Exception e){
                            message ="Erreur : Une des données saisie n'a pu etre récupérée";
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
                            assureSession.CreerParticulier(nomPart, prenomPart, gr, date, numSSPart, mailPart, numeroPart, adresseNewPersonne);
                        }
                    } else if (sessionGestionnaire != null) {
                        jspAffiche = "/menuGestionnaire.jsp";
                        gestionSession.CreerParticulier(nomPart, prenomPart, gr, date, numSSPart, mailPart, numeroPart, adresseNewPersonne);
                        if (origineCreationParticulier.equals("true")){jspAffiche = "/gestionContrat_DetailsContat.jsp";}
                    } else if (sessionAdministrateur != null) {
                        jspAffiche = "/menuAdministrateur.jsp";
                        gestionSession.CreerParticulier(nomPart, prenomPart, gr, date, numSSPart, mailPart, numeroPart, adresseNewPersonne);
                        if (origineCreationParticulier.equals("true")){jspAffiche = "/gestionContrat_DetailsContat.jsp";}
                    } 
                    
                    message = "Particulier crée avec succès";
                    } catch (Exception e){
                        message="Erreur : Un problème a été rencpntré lors de la création de la personne";
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

                  /*  gestionSession.CreerPersonneMorale(raisonSociale, siret, siren, mailPersMorale, mdpPersMorale, mailPersMorale);
                    //message = "Gestionnaire créé avec succès !";
                    //request.setAttribute("messsage", message);
                    break; */

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
                    Genre genreAdulte1,
                     genreAdulte2,
                     genreEnfant1,
                     genreEnfant2,
                     genreEnfant3;
                    String DobA1String,
                     DobA2String,
                     DobE1String,
                     DobE2String,
                     DobE3String;
                    Date DobA1Date,
                     DobA2Date,
                     DobE1Date,
                     DobE2Date,
                     DobE3Date;
                    int ageA1,
                     ageA2,
                     ageE1,
                     ageE2,
                     ageE3;
                    String nomA1,
                     prenomA1;
                    String regimeA1;
                    String nbEnfant = null;
                    String numRueTarif,
                     nomRueTarif,
                     cpTarif,
                     villeTarif,
                     paysTarif,
                     adresseTarif,
                     email;
                    Particulier particulierDevis = null;

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
                            regimeA1 = request.getParameter("selectRegimeA1");
                            nomA1 = request.getParameter("nomA1");
                            prenomA1 = request.getParameter("prenomA1");
                            ageA1 = doActionCalculerAge(DobA1Date, request, response);
                        } catch (Exception e) {
                            message = "Erreur : une information sur le premier adulte n'a pu être récupérée";
                            jspAffiche = "/realiserDevisBesoins.jsp";
                        }
                    }

                    try {
                        nbEnfant = request.getParameter("enfantSelect");
                    } catch (Exception e) {
                        message = "Erreur : le nombre d'enfant n'a pu être récupéré";
                        jspAffiche = "/realiserDevisBesoins.jsp";
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
                        } catch (Exception e) {
                            message = "Erreur : une information sur le deuxième adulte n'a pu être récupéreée";
                            jspAffiche = "/realiserDevisBesoins.jsp";
                        }
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
                            } catch (Exception e) {
                                message = "Erreur : une information sur le troisième enfant n'a pu être récupéreée";
                                jspAffiche = "/realiserDevisBesoins.jsp";
                            }
                        }
                    }

                    if (sessionAssure == null) {
                        try {
                            //Adresse
                            numRueTarif = request.getParameter("adrNum").trim();
                            nomRueTarif = request.getParameter("adrNomRue").trim();
                            cpTarif = request.getParameter("adrCP").trim();
                            villeTarif = request.getParameter("adrVille").trim();
                            paysTarif = request.getParameter("adrPays").trim();
                            adresseTarif = numRueTarif + "," + nomRueTarif + "," + cpTarif + "," + villeTarif + "," + paysTarif;

                            //Mail
                            email = request.getParameter("adrMail");
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
                    } catch (Exception e) {
                        message = "Erreur : l'âge n'a pu être récupéreée";
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
                    List<TauxGarantie> listeTauxGarantieHospitalisation = null;
                    List<TauxGarantie> listeTauxGarantieTotale = null;
                    for (int i = 0; i < listObjetGarantieHSC.size(); i++) {
                        Garantie garantieInstance = assureSession.RechercherGarantieParLibelle(listObjetGarantieHSC.get(i));
                        listeTauxGarantieHospitalisation.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieHSC, garantieInstance));
                        listeTauxGarantieTotale.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieHSC, garantieInstance));
                    }
                    request.setAttribute("honorairesHospitaliers", listeTauxGarantieHospitalisation.get(0));
                    request.setAttribute("forfaitJournalier", listeTauxGarantieHospitalisation.get(1));

                    List<String> listObjetGarantieSoinsCourants = Arrays.asList(new String[]{"Honoraires médicaux", "Honoraires paramédicaux"});
                    List<TauxGarantie> listeTauxGarantieSoinsCourants = null;
                    for (int i = 0; i < listObjetGarantieSoinsCourants.size(); i++) {
                        Garantie garantieInstance = assureSession.RechercherGarantieParLibelle(listObjetGarantieSoinsCourants.get(i));
                        listeTauxGarantieSoinsCourants.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieOD, garantieInstance));
                        listeTauxGarantieTotale.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieHSC, garantieInstance));
                    }
                    request.setAttribute("honorairesMedicaux", listObjetGarantieSoinsCourants.get(0));
                    request.setAttribute("honorairesParamedicaux", listObjetGarantieSoinsCourants.get(1));

                    List<String> listObjetGarantieOD = Arrays.asList(new String[]{"Soins dentaires remboursés par la sécurité sociale", "Orthodontie remboursée par la Sécurité Sociale", "Lunettes verres simples", "Lunettes verres complexes"});
                    List<TauxGarantie> listeTauxGarantieOptiqueDentaire = null;
                    for (int i = 0; i < listObjetGarantieOD.size(); i++) {
                        Garantie garantieInstance = assureSession.RechercherGarantieParLibelle(listObjetGarantieOD.get(i));
                        listeTauxGarantieOptiqueDentaire.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieOD, garantieInstance));
                        listeTauxGarantieTotale.add(assureSession.RechercherTauxGarantie(trancheAgeMaxTarif, objGarantieHSC, garantieInstance));
                    }
                    request.setAttribute("soinsDentaires", listeTauxGarantieOptiqueDentaire.get(0));
                    request.setAttribute("Orthodontie", listeTauxGarantieOptiqueDentaire.get(1));
                    request.setAttribute("verresSimples", listeTauxGarantieOptiqueDentaire.get(2));
                    request.setAttribute("verresComplexes", listeTauxGarantieOptiqueDentaire.get(3));

                    //Recherche des modules
                    //Recherche du produit
                    //Cotisations 
                    //Calcul des cotisations
                    double TarifCotisation = 0;
                    for (int i = 0; i < listeTauxGarantieTotale.size(); i++) {
                        TarifCotisation = TarifCotisation + ((listeTauxGarantieTotale.get(i).getTarifCotisation() * (Integer.parseInt(nbAdulteTarif))) + (listeTauxGarantieTotale.get(i).getTarifCotisation() * (Integer.parseInt(nbEnfant)) / 3));
                    }
                    request.setAttribute("MontantCotisationTotale", TarifCotisation);

                    //Enregistrement du devis
                    //assureSession.CreerDevis(email, sessionAssure, persoPublique, sessionGestionnaire, objGarantieOD, prod);
                    break;

                case "DemandeDevis_souscription":
                    jspAffiche = "/realiserDevisTarif.jsp";
                    message = "";
                    break;

                case "DemandeDevis_exportpdf":
                    jspAffiche = "/realiserDevisTarif.jsp";
                    doActionEditionDevis(request, response);
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
                    String idc=request.getParameter("idc");
                    long idContratIndivPourRsiliation =Long.parseLong(idc);
                    ContratIndividuel contratIndivPourResiliation = assureSession.RechercherContratIndivParId(idContratIndivPourRsiliation);
                    if (contratIndivPourResiliation == null){
                        message="Aucun contrat n'a été trouvé";
                    } else {
                        request.setAttribute("contrat", contratIndivPourResiliation);
                    }
                    
                    break;
                    
                case "Assure_GestionContrat_resilierJustificatif":
                    
                    Connection myConn = null;
                    PreparedStatement myStmt = null;

                    FileInputStream input = null;

                    try {
                            // 1. Get a connection to database
                            myConn = DriverManager.getConnection(
                            "jdbc:derby://localhost:1527/DRAJAK_BDX", "administrator", "Drajak_2020");

                            // 2. Prepare statement
                            String sql = "update employees set resume=? where email='john.doe@foo.com'";
                            myStmt = myConn.prepareStatement(sql);

                            // 3. Set parameter for resume file name
                            File theFile = new File("");
                            input = new FileInputStream(theFile);
                            myStmt.setBinaryStream(1, input);

                            System.out.println("Reading input file: " + theFile.getAbsolutePath());

                            // 4. Execute statement
                            System.out.println("\nStoring resume in database: " + theFile);
                            System.out.println(sql);

                            myStmt.executeUpdate();

                            System.out.println("\nCompleted successfully!");

                    } catch (Exception exc) {
                            exc.printStackTrace();
                    } finally {			
                            if (input != null) {
                                    input.close();
                            }

                            close(myConn, myStmt);			
                    }
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
                        for (int i = 0; i < lesmodules.length; i++) {
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
                        for (int i=0;i<lesGaranties.length;i++){
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
                        request.setAttribute("listeTypeAyantDroit", listeTypeAyantDroit);
                        request.setAttribute("listRechercheParticulier", listRechercheParticulier);
                        request.setAttribute("idc", request.getParameter("idc"));
                        System.out.println("Liste passé");
                    } else {
                        message ="Erreur : Un des champs n'est pas rempli";
                        System.out.println("Liste non passé");
                    }
                    break;
                    
                case "Assure_AttribuerParticulierCommeAyantDroit":
                case "Gestionnaire_AttribuerParticulierCommeAyantDroit":
                case "Administrateur_AttribuerParticulierCommeAyantDroit":
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
                                typeAyantDroitObj = assureSession.RechercherTypeAyantDroitParId(idTypeAyantDroit);
                                assureSession.CreerAyantDroit(typeAyantDroitObj, particulierObj, contratIndiv);
                            } else {
                                particulierObj = gestionSession.RechercherParticulierParId(idParticulier);
                                typeAyantDroitObj = gestionSession.RechercherTypeAyantDroitParId(idTypeAyantDroit);
                                gestionSession.CreerAyantDroit(typeAyantDroitObj, particulierObj, contratIndiv);
                            }
                            
                            if (sessionAssure != null) {
                                jspAffiche = "/menuAssure.jsp";
                                message = ("Ayant droit bien attribué à votre contrat N°"+idc);
                            } else if (sessionGestionnaire != null) {
                                jspAffiche = "/menuGestionnaire.jsp";
                                message = ("Ayant droit bien attribué au contrat N°"+idc);
                            } else {
                                jspAffiche = "/menuAdministrateur.jsp";
                                message = ("Ayant droit bien attribué au contrat N°"+idc);
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
                    request.setAttribute("idc", request.getParameter("idc"));
                    idp = request.getParameter("idcp");
                    long idAyantDroit = Long.parseLong(idp);
                    AyantDroit ayantDroitInstance = null;
                    if (!idp.trim().isEmpty()){
                        if (sessionAssure != null) {
                            ayantDroitInstance = assureSession.RechercherAyantDroitParId(idAyantDroit);
                        } else {
                            ayantDroitInstance = gestionSession.RechercherAyantDroitParID(idAyantDroit);
                        }
                        if (ayantDroitInstance != null){
                            if (sessionAssure != null) {
                                assureSession.SupprimerAyantDroit(ayantDroitInstance);
                            } else {
                                gestionSession.SupprimerAyantDroit(ayantDroitInstance);
                            }
                            jspAffiche = "/menuAssure.jsp";
                            message = "Ayant droit supprimé avec succés";
                        } else {
                            message="Ayant droit non trouvé";
                            jspAffiche = "/menuGestionnaire.jsp";
                        }
                    } else {
                        jspAffiche = "/menuGestionnaire.jsp";
                        message = "Erreur : un problème est survenu";
                    }
                    break;
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

    protected void doActionEditionDevis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            canvas.showText("nDevis");
            canvas.endText();

            //Date du devis
            canvas.beginText();
            canvas.setTextMatrix(127, 737);
            canvas.showText("dateDevis");
            canvas.endText();

            //Honnoraire Hospitalisation
            canvas.beginText();
            canvas.setTextMatrix(210, 655);
            canvas.showText("HonnoraireHospitalisation");
            canvas.endText();

            //Forfait Hospitalisation
            canvas.beginText();
            canvas.setTextMatrix(210, 625);
            canvas.showText("HonnoraireHospitalisation");
            canvas.endText();

            //Honnoraire Médicaux
            canvas.beginText();
            canvas.setTextMatrix(210, 560);
            canvas.showText("HonnoraireMédicaux");
            canvas.endText();

            //Honnoraire Paramédicaux
            canvas.beginText();
            canvas.setTextMatrix(210, 500);
            canvas.showText("HonnoraireParamédicaux");
            canvas.endText();

            //soins dentaire
            canvas.beginText();
            canvas.setTextMatrix(210, 410);
            canvas.showText("soins dentaire");
            canvas.endText();

            //Orthodontie
            canvas.beginText();
            canvas.setTextMatrix(210, 373);
            canvas.showText("Orthodontie");
            canvas.endText();

            //Lunettes verres simples
            canvas.beginText();
            canvas.setTextMatrix(210, 315);
            canvas.showText("Lunettes verres simples");
            canvas.endText();

            //Lunettes verres complexes
            canvas.beginText();
            canvas.setTextMatrix(210, 285);
            canvas.showText("Lunettes verres complexes");
            canvas.endText();
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
    
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
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
