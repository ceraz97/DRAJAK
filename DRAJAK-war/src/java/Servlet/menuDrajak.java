/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entity.*;
import Session.AssureSessionLocal;
import Session.GestionSessionLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
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
        String act = request.getParameter("action");
        HttpSession session = request.getSession(false);
        CompteAssure sessionAssure = null;
        CompteEmploye sessionGestionnaire = null;
        CompteEmploye sessionAdministrateur = null;
        PersonneMorale sessionEntreprise = null;
        List<Object> Response;

        if (session != null) {
            sessionAssure = (CompteAssure) session.getAttribute("sessionAssure");
            sessionGestionnaire = (CompteEmploye) session.getAttribute("sessionGestionnaire");
            sessionEntreprise = (PersonneMorale) session.getAttribute("sessionEntreprise");
            sessionAdministrateur = (CompteEmploye) session.getAttribute("sessionAdministrateur");
        }

        if ((sessionAssure != null && sessionGestionnaire != null && sessionEntreprise != null && sessionAdministrateur != null) || (sessionAssure == null && sessionGestionnaire == null && sessionEntreprise == null && sessionAdministrateur == null && act != null && !act.equals(""))) {
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
        } else if (null == act) {
            jspAffiche = "/accueilPublic.jsp";
            message = "Bienvenue";
        } else {
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
                    jspAffiche = "/accueiPublic.jsp";
                    message = "Vous êtes déconnecté";
                    break;

                case "AssureAuthentification":
                    String assureLogin = request.getParameter("login");
                    String assureMdp = request.getParameter("mdp");
                    if (assureLogin.trim().isEmpty() || assureMdp.trim().isEmpty()) {
                        message = "Erreur : Vous n'avez pas rempli tous les champs";
                        request.setAttribute("typeConnexion", "AssureMenu");
                        jspAffiche = "/accueiPublic.jsp";
                    } else {
                        sessionAssure = assureSession.RechercherCompteAssurePourConnexion(assureLogin, assureMdp);
                        if (sessionAssure == null) {
                            request.setAttribute("typeConnexion", "AssureMenu");
                            message = "Erreur : Le login ou le mot de passe est incorrect";
                            jspAffiche = "/accueiPublic.jsp";
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
                        jspAffiche = "/accueilEmploye.jsp";
                    } else {
                        sessionEntreprise = assureSession.RechercherCompteEntreprisePourConnexion(EntrepriseLogin, EntrepriseMdp);
                        if (sessionEntreprise == null) {
                            request.setAttribute("typeConnexion", "EntrepriseMenu");
                            message = "Erreur : Le login ou le mot de passe est incorrect";
                            jspAffiche = "/accueiPublic.jsp";
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
                            jspAffiche = "/menuAministrateur.jsp";
                            message = "Connexion réussie";
                            session = request.getSession(true);
                            session.setAttribute("sessionAdministrateur", sessionAdministrateur);
                        }
                    }
                break;
                
            }
        }
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
