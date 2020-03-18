/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.*;
import Enum.Genre;
import Enum.StatutPersonne;
import Session.AssureSessionLocal;
import Session.GestionSessionLocal;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clementratz
 */
@WebServlet(name = "menuDrajak", urlPatterns = {"/menuDrajak"})
public class menuDrajak extends HttpServlet {

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
            throws ServletException, IOException {
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
        boolean sessionPublic = true;
        List<Object> Response;
        System.out.println("===" + act + "===");
        if (session != null) {
            sessionAssure = (CompteAssure) session.getAttribute("sessionAssure");
            sessionGestionnaire = (CompteEmploye) session.getAttribute("sessionGestionnaire");
            sessionEntreprise = (PersonneMorale) session.getAttribute("sessionEntreprise");
            sessionAdministrateur = (CompteEmploye) session.getAttribute("sessionAdministrateur");
        }
        

        if ((sessionAssure != null && sessionGestionnaire != null && sessionEntreprise != null && sessionAdministrateur != null) || (sessionAssure == null && sessionGestionnaire == null && sessionEntreprise == null && sessionAdministrateur == null && act != null && !act.equals("")&&!act.equals("AssureMenu")&&!act.equals("GestionnaireMenu")&&!act.equals("EntrepriseMenu")&&!act.equals("AdministrateurMenu")&&!act.equals("AssureAuthentification")&&!act.equals("GestionnaireAuthentification")&&!act.equals("EntrepriseAuthentification")&&!act.equals("AdministrateurAuthentification")&&!act.equals("Deconnexion")&&!act.equals("DemandeDevis_besoins")&&!act.equals("DemandeDevis_infos")&&!act.equals("DemandeDevis_tarif")&&!act.equals("DemandeDevis_souscription")&&!act.equals("DemandeDevis_exportpdf"))) {
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
            System.out.println("act == Accueil Normale");
        } else {
            System.out.println("act != null");
            switch (act) {
                
            case "vide":
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
                        jspAffiche = "/menuAministrateur.jsp";
                        message = "";
                    } else {
                        jspAffiche = "/accueilPublic.jsp";
                        message = "Veuillez vous connecter";
                        request.setAttribute("typeConnexion", act);
                    }
                    break;

                case "Deconnexion":
                    session = request.getSession(false);
                    session.invalidate();
                    request.setAttribute("typeConnexion", request.getParameter("typeConnexion"));
                    jspAffiche = "/accueilPublic.jsp";
                    message = "Vous êtes déconnecté";
                    sessionPublic=true;
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
                            sessionPublic=false;
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
                            sessionPublic=false;
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
                            sessionPublic=false;
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
                            jspAffiche = "/menuAministrateur.jsp";
                            message = "Connexion réussie";
                            session = request.getSession(true);
                            session.setAttribute("sessionAdministrateur", sessionAdministrateur);
                            sessionPublic=false;
                        }
                    }
                    break;
                    
                case "AssureVersPageAfficherContrat" :
                    jspAffiche="/.jsp";
                    message="";
                    break;
                    
                case "DemandeDevis_besoins":
                    jspAffiche = "/realiserDevisBesoins.jsp";
                    message="";
                   if (sessionAssure != null) {
                        typeSession = "sessionAssure";
                    } else if (sessionGestionnaire != null) {
                        typeSession = "sessionGestionnaire";
                    } else if (sessionEntreprise != null) {
                        typeSession = "sessionEntreprise";
                    } else if (sessionAdministrateur != null) {
                        typeSession = "sessionAdministrateur";
                    } else if (sessionPublic=true) {
                        typeSession = "sessionPublic";
                    }  
                    request.setAttribute("typeSession",typeSession);
                    break;
                    
                case "DemandeDevis_infos":
                    jspAffiche = "/realiserDevisInfos.jsp";
                    message="";
                    
                    int nbAdulte =Integer.parseInt(request.getParameter("adulte").substring(6)); 
                    int trancheAge =Integer.parseInt(request.getParameter("age").substring(3));
                    String enfant =request.getParameter("enfant").substring(0,4);
                    int couverture =Integer.parseInt(request.getParameter("couverture").substring(10));
                    int optiqueDentaire =Integer.parseInt(request.getParameter("optiqueDentaire").substring(15));
                    request.setAttribute("nbAdulte", nbAdulte);
                    request.setAttribute("trancheAge", trancheAge);
                    request.setAttribute("enfant", enfant); 
                    request.setAttribute("couverture", couverture); 
                    request.setAttribute("optiqueDentaire", optiqueDentaire); 
                    
                    if (sessionAssure != null) {
                        typeSession = "sessionAssure";
                        session.setAttribute("sessionAssure", sessionAssure);
                        System.out.println("genre = "+sessionAssure.getCleParticulier().getGenre());
                    } else if (sessionGestionnaire != null) {
                        typeSession = "sessionGestionnaire";
                    } else if (sessionEntreprise != null) {
                        typeSession = "sessionEntreprise";
                    } else if (sessionAdministrateur != null) {
                        typeSession = "sessionAdministrateur";
                    } else if (sessionPublic=true) {
                        typeSession = "sessionPublic";
                    }  
                    request.setAttribute("typeSession",typeSession);
                    break;
                    
                case "DemandeDevis_tarif":
                    jspAffiche = "/realiserDevisTarif.jsp";
                    message="";
                                        
                    if (sessionAssure != null) {
                        typeSession = "sessionAssure";
                        session.setAttribute("sessionAssure", sessionAssure);
                    } else if (sessionGestionnaire != null) {
                        typeSession = "sessionGestionnaire";
                    } else if (sessionEntreprise != null) {
                        typeSession = "sessionEntreprise";
                    } else if (sessionAdministrateur != null) {
                        typeSession = "sessionAdministrateur";
                    } else if (sessionPublic=true) {
                        typeSession = "sessionPublic";
                    }  
                    request.setAttribute("typeSession",typeSession);
                    break;
                    
                case "DemandeDevis_souscription":
                    jspAffiche = "/realiserDevisTarif.jsp";
                    message="";
                                        
                    if (sessionAssure != null) {
                        typeSession = "sessionAssure";
                        session.setAttribute("sessionAssure", sessionAssure);
                    } else if (sessionGestionnaire != null) {
                        typeSession = "sessionGestionnaire";
                    } else if (sessionEntreprise != null) {
                        typeSession = "sessionEntreprise";
                    } else if (sessionAdministrateur != null) {
                        typeSession = "sessionAdministrateur";
                    } else if (sessionPublic=true) {
                        typeSession = "sessionPublic";
                    }  
                    request.setAttribute("typeSession",typeSession);
                    break;
                    
                case "DemandeDevis_exportpdf":
                    jspAffiche = "/realiserDevisTarif.jsp";
                    doActionEditionDevis(request, response);
                    message="";
                    
                    if (sessionAssure != null) {
                        typeSession = "sessionAssure";
                        session.setAttribute("sessionAssure", sessionAssure);
                    } else if (sessionGestionnaire != null) {
                        typeSession = "sessionGestionnaire";
                    } else if (sessionEntreprise != null) {
                        typeSession = "sessionEntreprise";
                    } else if (sessionAdministrateur != null) {
                        typeSession = "sessionAdministrateur";
                    } else if (sessionPublic=true) {
                        typeSession = "sessionPublic";
                    }  
                    request.setAttribute("typeSession",typeSession);
                    break;
            }
        }
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspAffiche);
        request.setAttribute("message", message);
        Rd.forward(request, response);
        System.out.println("Public : " + sessionPublic+", Assuré : "+sessionAssure+", Administrateur : "+ sessionAdministrateur+", Entreprise : "+sessionEntreprise+", Gestionnaire : "+sessionGestionnaire);
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
        processRequest(request, response);
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
        processRequest(request, response);
    }
    
    protected void doActionEditionDevis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDocument =0;
        try {
            idDocument = Integer.parseInt(request.getParameter(("idDocument")));
        } catch (Exception exception) {
        }
        
        String TemplatePath = request.getServletContext().getRealPath("/WEB-INF/DevisTemplate.pdf");
        response.setContentType("application/pdf");
        
        try (PdfReader reader = new PdfReader(TemplatePath);
            PdfWriter writer = new PdfWriter (response.getOutputStream());
            PdfDocument document = new PdfDocument (reader, writer)) {
            
            PdfPage page = document.getPage(1);
            PdfCanvas canvas = new PdfCanvas(page);
            
            FontProgram fontProgram = FontProgramFactory.createFont();
            PdfFont font = PdfFontFactory.createFont(fontProgram, "utf-8", true);
            canvas.setFontAndSize(font, 12);
                    
            canvas.beginText();
            canvas .setTextMatrix(0, 0);
            canvas.showText("Origine");
            canvas.endText();
        }
        
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

}
