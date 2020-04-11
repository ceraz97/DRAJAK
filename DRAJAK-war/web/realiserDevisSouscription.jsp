<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@ page import="Entity.CompteAssure"%>
<%@ page import="Enum.Genre"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Demande de devis</title>
        <meta charset="utf-8"/>
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
                        <h1 class="mb-4"><c:out value="Réaliser un devis santé"/></h1>                   
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
                            <li class="active_progressebar"><a href="javascript:history.go(-3)"><span>Vos besoins</span></a></li>
                            <li class="active_progressebar"><a href="javascript:history.go(-2)"><span>Vos infos</span></a></li>
                            <li class="active_progressebar"><a href="javascript:history.go(-1)"><span>Votre tarif</span></a></li>
                            <li class="active_progressebar"><span>Souscription</span></li>
                        </ul>
                    </div>


                    <div class="formulaire_devis">
                        <form role="form" method="post" action="menuDrajak" name="formulaireDevis2" enctype="multipart/form-data">

                            <table class="devisPartieInfos">
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLigneImpaire">1</td>
                                    <td class="colonne2Lignehaut">Premier adulte</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <c:choose>
                                            <c:when test="${!empty sessionScope.sessionAssure}">
                                                <c:out value="Toutes vos informations sont déjà enregistrées"/>
                                            </c:when>
                                            <c:otherwise>
                                                <div>
                                                    <label for="nSSA1"> Numéro de sécurité sociale :</label>
                                                    <input type="number" id="nSSA1" name="nSSA1" min="1000000000000" max="2999999999999" required>
                                                </div>
                                                <div>
                                                    <label for="selectRegimeA1">Régime :</label>
                                                    <select name="selectRegimeA1" required>
                                                        <option value="Régime Général" selected>Régime Général</option>
                                                        <option value="Alsace Moselle" >Alsace Moselle</option>
                                                    </select>
                                                </div>
                                                <div>
                                                    <span>Votre login sera votre adsresse mail précédemment fournie.</span>
                                                    <label for="mdp"> Mot de passe :</label>
                                                    <input type="password" name="mdp"placeholder="Mot de passe" required>
                                                    <label for="mdp2"> Confirmer mot de passe :</label>
                                                    <input type="password" name="mdp2" placeholder="Confirmer mot de passe"required>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                <c:if test="${!empty sessionScope.listePersonneTampon}">
                                    <c:forEach items="${sessionScope.listePersonneTampon}" var="personneTamp">
                                        <c:if test="${personneTamp.getNature() eq 'Adulte2'}">
                                            <tr class="ligneGeneraleTableauLigneImpaire">
                                                <td width rowspan="2"class="colonneEnteteLigneImpaire"></td>
                                                <td class="colonne2Lignehaut">Deuxième adulte</td>
                                            </tr>
                                            <tr class="ligneGeneraleTableau">
                                                <td class="colonne2LigneBas">
                                                    <section>
                                                        <div>
                                                            <c:out value="">Date de Naissance : ${personneTamp.getDateNaissance()}</c:out>
                                                            <c:out value="">Genre : ${personneTamp.getGenre()}</c:out>
                                                            <label for="adulte2Nom">Nom :</label>
                                                            <input type="text" id="adulte2Nom" name="adulte2Nom" required>
                                                            <label for="adulte2Prenom">Prénom :</label>
                                                            <input type="text" id="adulte2Prenom" name="adulte2Prenom" required>
                                                            <label for="adulte2Nss">Numéro de Sécurité Sociale :</label>
                                                            <input type="number" id="adulte2Nss" name="adulte2Nss" min="1000000000000" max="2999999999999" required>
                                                        </div>
                                                    </section>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>

                                    <c:forEach items="${sessionScope.listePersonneTampon}" var="personneTamp">
                                        <c:if test="${(personneTamp.getNature() eq 'Enfant1') || (personneTamp.getNature() eq 'Enfant2') || (personneTamp.getNature() eq 'Enfant3')}">
                                            <c:if test="${personneTamp.getNature() eq 'Enfant1'}">
                                                <tr class="ligneGeneraleTableauLigneImpaire">
                                                    <td width rowspan="2"class="colonneEnteteLigneImpaire"></td>
                                                    <td class="colonne2Lignehaut">Premier enfant</td>
                                                </tr>
                                                <tr class="ligneGeneraleTableau">
                                                    <td class="colonne2LigneBas">
                                                        <section>
                                                            <div>
                                                                <c:out value="">Date de Naissance : ${personneTamp.getDateNaissance()}</c:out>
                                                                <c:out value="">Genre : ${personneTamp.getGenre()}</c:out>
                                                                <label for="enfant1Nom">Nom :</label>
                                                                <input type="text" id="enfant1Nom" name="enfant1Nom" required>
                                                                <label for="enfant1Prenom">Prénom :</label>
                                                                <input type="text" id="enfant1Prenom" name="enfant1Prenom" required>
                                                                <label for="enfant1Nss">Numéro de Sécurité Sociale :</label>
                                                                <input type="number" id="enfant1Nss" name="enfant1Nss" min="1000000000000" max="2999999999999" required>
                                                            </div>
                                                        </section>
                                                    </td>
                                                </tr>
                                            </c:if>
                                            <c:if test="${personneTamp.getNature() eq 'Enfant2'}">
                                                <tr class="ligneGeneraleTableauLigneImpaire">
                                                    <td width rowspan="2"class="colonneEnteteLigneImpaire"></td>
                                                    <td class="colonne2Lignehaut">Deuxième enfant</td>
                                                </tr>
                                                <tr class="ligneGeneraleTableau">
                                                    <td class="colonne2LigneBas">
                                                        <section>
                                                            <div>
                                                                <c:out value="">Date de Naissance : ${personneTamp.getDateNaissance()}</c:out>
                                                                <c:out value="">Genre : ${personneTamp.getGenre()}</c:out>
                                                                <label for="enfant2Nom">Nom :</label>
                                                                <input type="text" id="enfant2Nom" name="enfant2Nom" required>
                                                                <label for="enfant2Prenom">Prénom :</label>
                                                                <input type="text" id="enfant2Prenom" name="enfant2Prenom" required>
                                                                <label for="enfant2Nss">Numéro de Sécurité Sociale :</label>
                                                                <input type="number" id="enfant2Nss" name="enfant2Nss" min="1000000000000" max="2999999999999" required>
                                                            </div>
                                                        </section>
                                                    </td>
                                                </tr>
                                            </c:if>
                                            <c:if test="${personneTamp.getNature() eq 'Enfant3'}">
                                                <tr class="ligneGeneraleTableauLigneImpaire">
                                                    <td width rowspan="2"class="colonneEnteteLigneImpaire"></td>
                                                    <td class="colonne2Lignehaut">Troisième enfant</td>
                                                </tr>
                                                <tr class="ligneGeneraleTableau">
                                                    <td class="colonne2LigneBas">
                                                        <section>
                                                            <div>
                                                                <c:out value="">Date de Naissance : ${personneTamp.getDateNaissance()}</c:out>
                                                                <c:out value="">Genre : ${personneTamp.getGenre()}</c:out>
                                                                <label for="enfant3Nom">Nom :</label>
                                                                <input type="text" id="enfant3Nom" name="enfant3Nom" required>
                                                                <label for="enfant3Prenom">Prénom :</label>
                                                                <input type="text" id="enfant3Prenom" name="enfant3Prenom" required>
                                                                <label for="enfant3Nss">Numéro de Sécurité Sociale :</label>
                                                                <input type="number" id="enfant3Nss" name="enfant3Nss" min="1000000000000" max="2999999999999" required>
                                                            </div>
                                                        </section>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </c:if>


                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLigneImpaire">3</td>
                                    <td class="colonne2Lignehaut">Votre moyen de paiement :</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <section class="sectionFormulaireRadio" style="background-color: transparent">
                                            <div style="flex:0">
                                                <input type="radio" name="periodePaiement" id="periodePaiement1" value="Mensuel" checked>
                                                <label for="periodePaiement1">Mensuel</label>
                                            </div>
                                            <div style="flex:0">
                                                <input type="radio" name="periodePaiement" id="periodePaiement2" value="Trimestriel" >
                                                <label for="periodePaiement2">Trimestriel</label>
                                            </div>
                                            <div style="flex:0">
                                                <input type="radio" name="periodePaiement" id="periodePaiement3" value="Annuel">
                                                <label for="periodePaiement3">Annuel</label>
                                            </div>
                                        </section>
                                        <section>
                                            <p style="margin: 15px autp;">
                                                <label for="fichier">Fichier à envoyer : </label>
                                                <input type="file" name="fichier" id="fichier" required/>
                                            </p>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                
                                </table>
                                <div class="form-group">
                                    <input type="hidden" name="action" value="DemandeDevis_RealisationContratIndiv"/>
                                    <input type="hidden" name="idDevis" value="${requestScope.idDevis}"/>
                                    

                                    <button type="submit" class="btn btn-primary btn-block btn-formulaireSouscription" value="Valider">Souscription</button>
                                </div>
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
