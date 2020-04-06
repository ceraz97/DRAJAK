<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@page import="Entity.CompteAssure"%>
<%@page import="Enum.Genre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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


    <c:choose>
        <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
        <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
        <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
        <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
        <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
    </c:choose>

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

        <p class="message-attribut">
            <c:set var="messagePage" value="${requestScope.message}" scope="page"/>
            <c:choose>
                <c:when test = "${fn:containsIgnoreCase(messagePage, 'erreur')}">
                    <span class="message_erreur">
                        <c:out value="${messagePage}"/>
                    </span>
                </c:when>
                <c:otherwise>
                    <span class="message_normal">
                        <c:out value="${messagePage}"/>
                    </span>
                </c:otherwise>
            </c:choose>
        </p>
        
        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="container_progressbar">
                        <ul class="progressbar">
                            <li class="active_progressebar"><a href="javascript:history.go(-2)"><span>Vos besoins</span></a></li>
                            <li class="active_progressebar"><a href="javascript:history.go(-1)"><span>Vos infos</span></a></li>
                            <li class="active_progressebar"><span>Votre tarif</span></li>
                            <li><span>Souscription</span></li>
                        </ul>
                    </div>
                    <div class="formulaire_devis">

                            <table class="devisPartieTarif">
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire premiereLigneTarifDevis" style="height: 150px;">
                                    <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif" id="celluleVideTarifDevis"></td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><span style="color: black"> Vos cotisations s'élèveront à <br /> <span style="color: #f2ac1d; font-size: 42px"><fmt:formatNumber var="fmtPrix" currencySymbol="€" maxIntegerDigits="2" type="currency" value="${requestScope.MontantCotisationTotale}"/><c:out value="${fmtPrix}"/></span></span></td>
                                </tr>
                                <tr class="ligneGeneraleTableauLignePaire">
                                    <td class="colonneDevisPartie colonneEnteteLignePaireTarif colonneDevisTarif ">Hospitalisation (en établissement conventionné, hors psychiatrie)</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Honoraires hospitaliers</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.honorairesHospitaliers.getMaxRemboursement()}"/></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Forfait journalier</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.forfaitJournalier.getMaxRemboursement()}"/></td>
                                    </tr>
                                <tr class="ligneGeneraleTableauLignePaire">
                                    <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisPartie">Soins courants</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Honoraires médicaux (médecins généralistes et, radiologie)</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.honorairesMedicaux.getMaxRemboursement()}"/></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Honoraires paramédicaux (kinésithérapeutes, infirmiers, auxiliaires médicaux)</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.honorairesParamedicaux.getMaxRemboursement()}"/></td>
                                    </tr>
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisPartie">Dentaire</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Soins dentaires remboursés par la Sécurité social</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.soinsDentaires.getMaxRemboursement()}"/></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Orthodontie remboursée par la Sécurité sociale</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.Orthodontie.getMaxRemboursement()}"/></td>
                                    </tr>
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisPartie">Optique</td>
                                    <td class="colonneGrilleTarif colonneDevisTarif colonneColspan"></td>
                                </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLigneImpaireTarif colonneDevisTarif colonneDevisTarifEnTete">Lunettes verres simples</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.verresSimples.getMaxRemboursement()}"/></td>
                                    </tr>
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete">Lunettes verres complexes</td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire"><c:out value="${requestScope.verresComplexes.getMaxRemboursement()}"/></td>
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
                                        <td class="colonneEnteteLignePaireTarif colonneDevisTarif colonneDevisTarifEnTete"><a class ="ensembleLiens" onclick="window.open('menuDrajak?action=DemandeDevis_exportpdf&&idDevis=${requestScope.Devis.getId()}','_blank')"><i id="faImpression"class="fas fa-print"></i> Imprimer</a></td>
                                        <td class="colonneGrilleTarif colonneDevisTarif colonnePaire">
                                            <div class="form-group">
                                                <c:set var="listeTxGar" value="${requestScope.listeTxGarantie}" scope="session"/>
                                                <button class="btn btn-primary btn-block btn-formulaireSouscription" onclick="location.href = 'menuDrajak?action=DemandeDevis_souscription&&idDevis=${requestScope.Devis.getId()}'">Souscription</button>
                                            </div>
                                        </td>
                                    </tr>
                            </table>
                            
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
