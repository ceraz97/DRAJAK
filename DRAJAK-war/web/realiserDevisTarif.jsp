<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@page import="Entity.CompteAssure"%>
<%@page import="Enum.Genre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Demande de devis</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>



    <!-- Affichage du menu suivant l'utilisateur-->
    <%String attributSession = (String) request.getAttribute("typeSession");
        if (attributSession.equalsIgnoreCase("sessionAssure")) {%>
            <%@include file="Menus/NavBar_assure.jsp" %>
            <jsp:useBean id="sessionAssure" scope="session" class="CompteAssure"></jsp:useBean>
        <%} else if (attributSession.equalsIgnoreCase("sessionPublic")) {%>
            <%@include file="Menus/NavBar_public.jsp" %>
        <%} else if (attributSession.equalsIgnoreCase("sessionGestionnaire")) {%>
            <%@include file="Menus/NavBar_gestionnaire.jsp" %>
        <%} else if (attributSession.equalsIgnoreCase("sessionEntreprise")) {%>
            <%@include file="Menus/NavBar_entreprise.jsp" %>
        <%} else if (attributSession.equalsIgnoreCase("sessionAdministrateur")) {%>
            <%@include file="Menus/NavBar_administrateur.jsp" %>
        <%}
    %>


    <body>
        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Réaliser un devis santé</h1>                   
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="container_progressbar">
                        <ul class="progressbar">
                            <li class="active_progressebar"><span>Vos besoins</span></li>
                            <li class="active_progressebar"><span>Vos infos</span></li>
                            <li class="active_progressebar"><span>Votre tarif</span></li>
                            <li><span>Souscription</span></li>
                        </ul>
                    </div>
                    <div class="formulaire_devis">
                        <form role="form" method="post" action="menuDrajak" name="formulaireDevis2">

                            <table class="devisPartieTarif">
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire premiereLigneTarifDevis" style="height: 150px;">
                                    <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif" id="celluleVideTarifDevis"></td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                </tr>
                                <tr class="ligneGeneraleTableauLignePaire">
                                    <td class="colonneDevisPartie colonneEnteteLignePaireTarif colonneDevisTarif ">Hospitalisation (en établissement conventionné, hors psychiatrie)</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Honoraires hospitaliers</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Frais de séjour (hors chambre particulière)</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Forfait journalier</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                <tr class="ligneGeneraleTableauLignePaire">
                                    <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisPartie">Soins courants</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Honoraires médicaux (médecins généralistes et, radiologie)</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Honoraires paramédicaux (kinésithérapeutes, infirmiers, auxiliaires médicaux)</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisPartie">Dentaire</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Soins dentaires remboursés par la Sécurité social</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Orthodontie remboursée par la Sécurité sociale</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisPartie">Optique</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Lunettes verres simples</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Lunettes verres complexes</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"></td>
                                    </tr>
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisPartie">Services</td>
                                    <td colspan="3"class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Assistance</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><i class="fas fa-check"></i></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Conseil et accompagnement maladie grave</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><i class="fas fa-check"></i></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Tiers Payant</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><i class="fas fa-check"></i></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Télétransmission</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><i class="fas fa-check"></i></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete"><a class ="ensembleLiens" onclick="window.open('menuDrajak?action=DemandeDevis_exportpdf','_blank')"><i id="faImpression"class="fas fa-print"></i> Imprimer</a></td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire">
                                            <div class="form-group">
                                                <input type="hidden" name="action" value="DemandeDevis_souscription"/>
                                                <button type="submit" class="btn btn-primary btn-block btn-formulaireSouscription" value="Valider">Souscription</button>
                                            </div>
                                        </td>
                                    </tr>
                                    
                            </table>
                            
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="Shared/ElementFooter.jsp" %>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg></div>


        <%@include file="Shared/script_js.jsp" %>
    </body>

</html>
