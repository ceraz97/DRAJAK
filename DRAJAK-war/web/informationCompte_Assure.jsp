<%-- 
    Document   : creationGestionnaire
    Created on : 16 mars 2020, 10:43:48
    Author     : Clément
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Mon Compte</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>
    <style>
        * {box-sizing: border-box;}

        .wrapper > div {
            border: solid 2px #E2E2E2;
            border-radius: 20px;
            padding: 1em;
        }
        .wrapper {
            display: grid;
            grid-template-columns: 60% 40%;
            grid-template-rows: 100% 100%;
            grid-gap: 10px;
            margin: 100px auto;
            width: 100%;
        }

        .box1 {
            grid-column: 2 / 3;
            grid-row: 0/1;
        }

        .box2 {
            grid-column: 1;
            grid-row: 1/3;
        }

        .box3 {
            grid-row: 2;
            grid-column: 2/3;
        }
    </style>
    <script type="text/javascript">
        function phoneMask() {
            var num = $(this).val().replace(/\D/g, '');
            $(this).val(num.substring(0, 2) + ' ' + num.substring(2, 4) + ' ' + num.substring(4, 6) + ' ' + num.substring(6, 8) + ' ' + num.substring(8, 10));
        }
        $('[type="tel"]').keyup(phoneMask);
        
    </script>
    <body>

        <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
        </c:choose>
        <fmt:formatDate var="fmtDate" value="${sessionScope.sessionAssure.getCleParticulier().getDateNaissance()}" pattern="dd/MM/yyyy"/>
        <fmt:formatDate var="fmtDateForm" value="${sessionScope.sessionAssure.getCleParticulier().getDateNaissance()}" pattern="yyyy-MM-dd"/>
        <c:set var="adresseFromBD" value="${sessionScope.sessionAssure.getCleParticulier().getAdresse()}"/>
        <c:set var="adresseSplit" value="${fn:split(adresseFromBD, ',')}"/>


        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Mon compte</h1>                   
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
                    <div class="wrapper">
                        <div class="box2">
                            <p style="color:#167ce9;text-align: center; font-size: 24px"><i class="fas fa-info-circle"></i> Mes informations</p>
                            <form role="form" method="post" action="menuDrajak">
                                <c:choose>
                                    <c:when test="${requestScope.origineModification eq 'true'}">
                                        <div class="NomPrenomDevis">
                                            <label for="nomA1">Nom :</label>
                                            <input type="text" id="nomA1" name="nomA1" placeholder="Nom" value="${sessionScope.sessionAssure.getCleParticulier().getNom()}" disabled="disabled" required>
                                            <label for="prenomA1">Prénom :</label>
                                            <input type="text" id="prenomA1" name="prenomA1" placeholder="Prénom" value="${sessionScope.sessionAssure.getCleParticulier().getPrenom()}" disabled="disabled" required>
                                            </div>
                                        <div>
                                            <label for="bdayA1">Date de naissance :</label>
                                            <input type="date" id="bdayA1" name="bdayA1" value="${fmtDateForm}" disabled="disabled" required>
                                        </div>
                                        <div class="NomPrenomDevis">
                                            <label for="phone-input">Téléphone :</label>
                                            <input id="phone-input" type="tel" name="PhoneIn" aria-label="Entré votre numéro de téléphone" placeholder="${sessionScope.sessionAssure.getCleParticulier().getnTelephone()}" disabled="disabled">
                                        </div>
                                        <div>
                                            <div class="champsAdresseDevis"><label for="adrNum">Numéro :</label><input type="text" id="adrNum" name="adrNum" placeholder="${adresseSplit[0]}" value=""></div>
                                            <div class="champsAdresseDevis"><label for="adrNomRue">Rue :</label><input type="text" id="adrNomRue" name="adrNomRue" placeholder="${adresseSplit[1]}" value="" ></div>
                                            <div class="champsAdresseDevis"><label for="adrCP">Code Postal :</label><input type="text" id="adrCP" name="adrCP" placeholder="${adresseSplit[2]}" value=""></div>
                                            <div class="champsAdresseDevis"><label for="adrVille">Ville :</label><input type="text" id="adrVille" name="adrVille" placeholder="${adresseSplit[3]}" value=""></div>
                                            <div class="champsAdresseDevis"><label for="adrPays">Pays :</label><input type="text" id="adrPays" name="adrPays" placeholder="${adresseSplit[4]}" value=""></div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <p>Nom : <c:out value="${sessionScope.sessionAssure.getCleParticulier().getNom()}"/></p>
                                        <p>Prénom : <c:out value="${sessionScope.sessionAssure.getCleParticulier().getPrenom()}"/></p>
                                        <p>Date de naissance : <c:out value="${fmtDate}"/></p>
                                        <p>Téléphone : <c:out value="${sessionScope.sessionAssure.getCleParticulier().getnTelephone()}"/></p>
                                        <p></p>
                                        <p>Numéro : <c:out value="${adresseSplit[0]}"/></p>
                                        <p>Rue : <c:out value="${adresseSplit[1]}"/></p>
                                        <p>Code Postal : <c:out value="${adresseSplit[2]}"/></p>
                                        <p>Ville : <c:out value="${adresseSplit[3]}"/></p>
                                        <p>Pays : <c:out value="${adresseSplit[4]}"/></p>
                                    </c:otherwise>
                                </c:choose>
                                
                                <div style="margin: auto; position: relative; display: block; text-align: center;">
                                    <c:choose>
                                        <c:when test="${requestScope.origineModification eq 'true'}">    
                                            <input type="hidden" name="action" value="Assure_ModifierInformations_Modifications">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="hidden" name="action" value="Assure_ModifierInformations_AffichagePage">
                                        </c:otherwise>
                                    </c:choose>
                                    <button type="submit" class="btn btn-primary btn-co">Modifier</button>
                                </div>
                            </form>
                        </div>
                        <div class="box1">
                            <form role="form" method="post" action="menuDrajak">
                                <div class="champsAdresseDevis">
                                    <label for="ancienMDP">Ancien mot de passe :</label>
                                    <input id="ancienMDP" type="password"  name="ancienMDP" placeholder="Ancien mot de passe" required>
                                </div>
                                <div class="champsAdresseDevis">
                                    <label for="newMDP">Nouveau mot de passe :</label>
                                    <input id="newMDP" type="password"  name="newMDP" placeholder="Nouveau mot de passe" required>
                                </div>
                                <div class="champsAdresseDevis">
                                    <label for="newMDPConf">Confirmer nouveau mot de passe :</label>
                                    <input id="newMDPConf" type="password"  name="newMDPConf" placeholder="Nouveau mot de passe" required>
                                </div>
                                <div style="margin: auto; position: relative; display: block; text-align: center;">
                                    <input type="hidden" name="axction" value="Assure_ModifierMotDePasse">
                                    <button type="submit" class="btn btn-primary btn-co">Modifier</button>
                                </div>
                            </form>
                        </div>
                        <!--<div class="box3">Trois</div>-->
                    </div>
                </div>
            </div>
        </section>
        <%@include file="Shared/ElementFooter.jsp" %>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen">
            <svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
        </div>

        <style>
            select option:first-child{color:grey; display: none;}
            select option {color:black;}
            input { margin-bottom: 1em;}
        </style>

        <%@include file="Shared/script_js.jsp" %>
    </body>

</html>

