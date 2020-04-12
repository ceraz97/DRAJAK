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
    <fmt:formatDate var="fmtDate" value="${sessionScope.sessionAssure.getCleParticulier().getDateNaissance()}" pattern="yyyy-MM-dd"/>
    <c:set var="adresseFromBD" value="${sessionScope.sessionAssure.getCleParticulier().getAdresse()}"/>
    <c:set var="adresseSplit" value="${fn:split(adresseFromBD, ',')}"/>
    
    <body>
        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4"><c:out value="Réaliser un contrat collectif"/></h1>                   
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
                    

                    <div class="formulaire_devis">
                        <form role="form" method="post" action="menuDrajak" name="formulaireDevis2">

                            <table class="devisPartieInfos">
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLigneImpaire">1</td>
                                    <td class="colonne2Lignehaut">Récapitulatif des employés</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <table id="tableauEmploye" name="tableauEmploye">
                                            <tr>
                                              <th>Nom</th>
                                              <th>Prénom</th>
                                              <th>Date de naissance</th>
                                              <th>Numéro de Sécurité sociale</th>
                                              <th>Genre</th>
                                              <th>Adresse</th>
                                              <th>Email</th>
                                              <th>Téléphone</th>
                                            </tr>
                                          </table>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLignePaire">2</td>
                                    <td class="colonne2Lignehaut">Ajouter un employé :</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <section>
                                            <div>
                                                <div class="champsAdresseDevis">Nom : <input type="text" name="nomPersonne" id="nomPersonne"></div>
                                                <div class="champsAdresseDevis">Prénom : <input type="text" name="prenomPersonne" id="prenomPersonne"></div>
                                                <div class="champsAdresseDevis">Date de Naissance : <input type="date" name="dobPersonne" id="dobPersonne"></div>
                                                <div class="champsAdresseDevis">Numéro de sécurité sociale<input type="number" min="1000000000000" max="2999999999999" name="nSsPersonne" id="nSsPersonne"></div>
                                                <div class="champsAdresseDevis">Genre : <select id="genre">
                                                        <option>Homme</option>
                                                        <option>Femme</option>
                                                        <option>Autre</option>
                                                </select></div>
                                                <div class="champsAdresseDevis">Numéro de rue : <input type="text" name="numAdr" id="numAdr" ></div>
                                                <div class="champsAdresseDevis">Rue : <input type="text" name="rueAdr" id="rueAdr" ></div>
                                                <div class="champsAdresseDevis">Code Postal : <input type="text" name="cpAdr" id="cpAdr" ></div>
                                                <div class="champsAdresseDevis">Ville : <input type="text" name="villeAdr" id="villeAdr" ></div>
                                                <div class="champsAdresseDevis">Pays : <input type="text" name="paysAdr" id="paysAdr" ></div>
                                                <div class="champsAdresseDevis">Email : <input type="email" name="email" id="email" ></div>
                                                <div class="champsAdresseDevis">Téléphone : <input type="tel" id="tel" name="tel"></div>
                                                <button class="btn btn-primary btn-block" style="width: 60%; margin: 20px auto; position:relative;" type="button" onclick="myFunction()">Ajouter employé</button>
                                            </div>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLigneImpaire">3</td>
                                    <td class="colonne2Lignehaut">Les modules de la formule de base</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <section>
                                            <div>
                                                <div>
                                                    Hospitalisation
                                                    <select name="hospitalisationBase">
                                                        <option value="1">Niveau 1</option>
                                                        <option value="2">Niveau 2</option>
                                                        <option value="3">Niveau 3</option>
                                                    </select>
                                                </div>
                                                
                                                <div>
                                                    Soins courants
                                                    <select name="soinsCourantBase">
                                                        <option value="1">Niveau 1</option>
                                                        <option value="2">Niveau 2</option>
                                                        <option value="3">Niveau 3</option>
                                                    </select>
                                                </div>
                                                
                                                <div>
                                                    Optique et dentaires
                                                    <select name="optiqueDentaireBase">
                                                        <option value="1">Niveau 1</option>
                                                        <option value="2">Niveau 2</option>
                                                        <option value="3">Niveau 3</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLignePaire">4</td>
                                    <td class="colonne2Lignehaut">Les modules de la formule facultative</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <section>
                                            <div>
                                                <div>
                                                    Hospitalisation
                                                    <select name="hospitalisationFacultatif">
                                                        <option value="1">Niveau 1</option>
                                                        <option value="2">Niveau 2</option>
                                                        <option value="3">Niveau 3</option>
                                                    </select>
                                                </div>
                                                
                                                <div>
                                                    Soins courants
                                                    <select name="soinsCourantFacultatif">
                                                        <option value="1">Niveau 1</option>
                                                        <option value="2">Niveau 2</option>
                                                        <option value="3">Niveau 3</option>
                                                    </select>
                                                </div>
                                                
                                                <div>
                                                    Optique et dentaires
                                                    <select name="optiqueDentaireFacultatif">
                                                        <option value="1">Niveau 1</option>
                                                        <option value="2">Niveau 2</option>
                                                        <option value="3">Niveau 3</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                
                            </table>
                            <div class="form-group">
                                <input type="hidden" name="action" value="Gestionnaire_CreerContratCollectif"/>


                                <button type="submit" class="btn btn-primary btn-block btn-formulaire" value="Valider">Obtenir tarifs</button>
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

<script>
    function myFunction() {
        var table = document.getElementById("tableauEmploye");
        var row = table.insertRow(1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        var nom = document.getElementById("nomPersonne");
        var prenom = document.getElementById("prenomPersonne");
        var dob = document.getElementById("dobPersonne");
        var nss= document.getElementById("nSsPersonne");
        var genre = document.getElementById("genre");
        var email= document.getElementById("email");
        var tel = document.getElementById("tel");
        var numAdr = document.getElementById("numAdr");
        var rueAdr = document.getElementById("rueAdr");
        var cpAdr = document.getElementById("cpAdr");
        var villeAdr = document.getElementById("villeAdr");
        var paysAdr = document.getElementById("paysAdr");
        var adr = numAdr.value+","+rueAdr.value+","+cpAdr.value+","+villeAdr.value+","+paysAdr.value;

        if (nom.value!='' && prenom.value!='' && dob.value!='' && nss.value!='' && genre.value!='' && email.value!='' && tel.value!='' && numAdr.value!='' && rueAdr.value!='' && cpAdr.value!='' && villeAdr.value!='' && paysAdr.value!='' ) {
            cell1.innerHTML = nom.value;
            cell2.innerHTML = prenom.value;
            cell3.innerHTML = dob.value;
            cell4.innerHTML = nss.value;
            cell5.innerHTML = adr;
            cell6.innerHTML = genre.value;
            cell7.innerHTML = email.value;
            cell8.innerHTML = tel.value;

            nom.value='';
            prenom.value='';
            dob.value='';
            nss.value='';
            numAdr.value='';
            rueAdr.value='';
            cpAdr.value='';
            villeAdr.value='';
            paysAdr.value='';
            genre.value='Homme';
            email.value='';
            tel.value='';
        }
    }
</script>