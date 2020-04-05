<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Vos Contrats</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>

    <body> 

        <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
        </c:choose>


        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Gérer vos contrats</h1>                   
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
                        <div class="box1">
                            <p style="color:#167ce9;text-align: center; font-size: 24px"><i class="fas fa-search"></i> Recherche</p>
                            <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                                <div style="margin-bottom: 20px;">
                                    <input type="number" value="" name="nSsPersonne" placeholder="Numéro de sécurité sociale" required>
                                    <input type="hidden" name="idc" value="${requestScope.idc}">
                                </div>
                                <c:choose>
                                    <c:when test="${ !empty sessionScope.sessionAssure }">
                                        <input type="hidden" name="action" value="Assure_RechercherParticulier"/>
                                    </c:when>
                                    <c:when test="${ !empty sessionScope.sessionGestionnaire }">
                                        <input type="hidden" name="action" value="Gestionnaire_RechercherParticulier"/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="hidden" name="action" value="Administrateur_RechercherParticulier"/>
                                    </c:otherwise>
                                </c:choose>
                                <button type="submit" class="btn btn-primary btn-co" style="text-align: center;">Rechercher</button>
                            </form>
                        </div>

                        <c:if test="${requestScope.rechercheFaite eq 'true'}">
                            <div class="box2">
                                <c:choose>
                                    <c:when test="${ !empty sessionScope.sessionAssure }">
                                        <button type="button" class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Assure_GestionContrat_AjoutAyantDroit&&idc=${requestScope.idc}'" style="text-align: center;">Créer Particulier</button>
                                    </c:when>
                                    <c:when test="${ !empty sessionScope.sessionGestionnaire }">
                                        <button type="button" class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Gestionnaire_GestionContrat_AjoutAyantDroit&&idc=${requestScope.idc}'" style="text-align: center;">Créer Particulier</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button type="button" class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Administrateur_GestionContrat_AjoutAyantDroit&&idc=${requestScope.idc}'" style="text-align: center;">Créer Particulier</button>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </c:if>



                        <div class="box3">
                            <table>
                                <!-- here should go some titles... -->
                                <tr style="border-bottom: 1px solid #167ce9;">
                                    <th>Numéro de Sécurité sociale</th>
                                    <th>Nom</th>
                                    <th>Prénom</th>
                                    <th>Date de Naissance</th>
                                    <th>Adresse</th>
                                    <th></th>
                                </tr>
                                <c:forEach items="${requestScope.listRechercheParticulier}" var="personne">
                                    <tr>
                                        <td id="td1">
                                            <c:out value="${personne.getnSecuriteSocial()}" />
                                        </td>
                                        <td id="td2">
                                            <c:out value="${personne.getNom()}" />
                                        </td>
                                        <td id="td3">
                                            <c:out value="${personne.getPrenom()}" />
                                        </td>
                                        <td id="td4">
                                            <fmt:formatDate var="fmtDateNais" value="${personne.getDateNaissance()}" pattern="dd/MM/yyyy"/>
                                            <c:out value="${fmtDateNais}" />
                                        </td>
                                        <td id="td5">
                                            <c:out value="${personne.getAdresse()}" />
                                        </td>

                                        <td id="TD7">
                                            <div class="container">
                                                <!-- Trigger the modal with a button -->
                                                <button type="button" class="btn btn-primary btn-co" data-toggle="modal" data-target="#myModal" onclick="<c:set var="Personneselectionnee" value="${personne.getId()}" scope="page"/>">Selectioner</button>

                                                <!-- Modal -->
                                                <div class="modal fade" id="myModal" role="dialog">
                                                    <div class="modal-dialog">

                                                        <!-- Modal content-->
                                                        <div class="modal-content">

                                                            <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                                                                <div class="modal-header">
                                                                    <h4 class="modal-title">Selectioner la relation de l'ayant droit</h4>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <p>
                                                                        <select name="choixTypeAyantDroit">
                                                                            <c:forEach items="${requestScope.listeTypeAyantDroit}" var="elementTypeAyantDroit">
                                                                                <option value="${elementTypeAyantDroit.getId()}"><c:out value="${elementTypeAyantDroit.getLibelleAyantDroit()}"/></option>
                                                                            </c:forEach>
                                                                        </select>
                                                                        <input type="hidden" name="idc" value="${requestScope.idc}"/>
                                                                        <input type="hidden" name="idp" value="${Personneselectionnee}"/>
                                                                    </p>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <c:choose>
                                                                        <c:when test="${ !empty sessionScope.sessionAssure }">
                                                                            <input type="hidden" name="action" value="Assure_AttribuerParticulierCommeAyantDroit"/>
                                                                        </c:when>
                                                                        <c:when test="${ !empty sessionScope.sessionGestionnaire }">
                                                                            <input type="hidden" name="action" value="Gestionnaire_AttribuerParticulierCommeAyantDroit"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <input type="hidden" name="action" value="Administrateur_AttribuerParticulierCommeAyantDroit"/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <button type="submit" class="btn btn-primary btn-co">Sélectionner</button>
                                                                </div>
                                                            </form>

                                                        </div>

                                                    </div>
                                                </div>

                                            </div>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
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

    <style>
        input {margin: 5px 10px; width: 90%}
        table{width: 100%;}
        table>tr{ margin-bottom: 20px;}
        th {color:#167ce9}
        table td {height: 4em; vertical-align: middle;}
        #td3,#td4,#td6{width: 10%;}
        #td1{width: 20%;}
        #td2,#td7{width: 15%}
        #td5{width: 30%}
    </style>

    <style>
        * {box-sizing: border-box;}

        .wrapper > div {
            border: solid 2px #E2E2E2;
            border-radius: 20px;
            padding: 1em;
        }
        .wrapper {
            display: grid;
            grid-template-columns: 25% 25% 25% 25%;
            grid-template-rows: 100% 100%;
            grid-gap: 10px;
            margin: 100px auto;
            width: 100%;
        }

        .box1 {
            grid-column: 1/2;
            grid-row: 1;
        }

        .box2 {
            grid-column: 1/2;
            grid-row: 2;
        }

        .box3 {
            grid-row: 1/3;
            grid-column: 2/5;
        }
    </style>

</html>
