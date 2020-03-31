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
        <script type="text/javascript">
            function getConfirmSuppression(nomPersonne,prenomPresonne, idAyantDroit, idContrat) {
                var result = confirm("Voulez vous supprimer l'ayant droit " + nomPersonne +" "+ prenomPresonne +"?");
                if (result) {
                    location.href = "menuDrajak?action=Assure_GestionContrat_SuppressionAyantDroit&idc=" + idContrat+"&&idp="+idAyantDroit;
                }
            }

        </script>    

        <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
        </c:choose>
        <fmt:formatDate var="fmtDateDebut" value="${contrat.getDateCreation()}" pattern="dd/MM/yyyy"/>
        <fmt:formatDate var="fmtDateFin" value="${contrat.getDateFin()}" pattern="dd/MM/yyyy"/>



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
                    <div class="formulaire_devis">
                        <div>
                            <p style="color:#167ce9;font-size: 18px"><i class="fas fa-info-circle"></i> Informations contrat</p>
                            <div style="padding-left: 40px; margin-bottom: 30px;">
                                <p>Numéro de contrat : <c:out value="${requestScope.contrat.getId()}"/></p>
                                <p>Date création contrat : <c:out value="${fmtDateDebut}"/></p>
                                <p>Date fin de contrat : <c:out value="${fmtDateFin}"/></p>
                            </div>
                            <p style="color:#167ce9;font-size: 18px"><i class="fas fa-user"></i> Assurés et ayants droits</p>
                            <div style="padding-left: 40px; margin-bottom: 30px;">
                                <div style="margin-bottom: 20px;">
                                    <p style="color:#167ce9;"> Assuré principal</p>
                                    <div style="margin-left: 20px;">
                                        <p>Nom : <c:out value="${requestScope.contrat.getCleCompteAssure().getCleParticulier().getNom()}"/></p>
                                        <p>Prénom : <c:out value="${requestScope.contrat.getCleCompteAssure().getCleParticulier().getPrenom()}"/></p>
                                        <fmt:formatDate var="fmtDobAssure" value="${requestScope.contrat.getCleCompteAssure().getCleParticulier().getDateNaissance()}" pattern="dd/MM/yyyy"/>
                                        <p>Date de naissance : <c:out value="${fmtDobAssure}"/></p>
                                    </div>
                                </div>

                                <c:forEach items="${requestScope.listeAyantDroit}" var="ayantDroit">
                                    <div style="margin-bottom: 20px;">
                                        <p style="color:#167ce9;"> Ayant droit</p>
                                        <div style="margin-left: 20px;">
                                            <p>Nom : <c:out value="${ayantDroit.getCleParticulier().getNom()}"/></p>
                                            <p>Prénom : <c:out value="${ayantDroit.getCleParticulier().getPrenom()}"/></p>
                                            <fmt:formatDate var="fmtDobAssure" value="${ayantDroit.getCleParticulier().getDateNaissance()}" pattern="dd/MM/yyyy"/>
                                            <p>Date de naissance : <c:out value="${fmtDobAssure}"/></p>
                                            <p>Relation : <c:out value="${ayantDroit.getCleTypeAyantDroit().getLibelleAyantDroit()}"/></p>
                                           <button class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Assure_VersRechercherPersonne&&idc=${requestScope.contrat.getId()}'">Modifier</button>
                                           <button class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Assure_VersRechercherPersonne&&idc=${requestScope.contrat.getId()}'">Supprimer</button>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:choose>
                                    <c:when test="${ !empty sessionScope.sessionAssure }">
                                        <button class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Assure_VersRechercherPersonne&&idc=${requestScope.contrat.getId()}'">Ajouter ayant droit</button>
                                    </c:when>
                                    <c:when test="${ !empty sessionScope.sessionGestionnaire }">
                                        <button class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Gestionnaire_VersRecherchePersonne&&idc=${requestScope.contrat.getId()}'">Ajouter ayant droit</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=Administrateur_VersRecherchePersonne&&idc=${requestScope.contrat.getId()}'">Ajouter ayant droit</button>
                                    </c:otherwise>
                                </c:choose>
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
        table{width: 100%;}
        table>tr{ margin-bottom: 20px;}
        th {color:#167ce9}
        table td {height: 4em; vertical-align: middle;}
        #td2,td3,td4,td5,td6{width: 10%;}
        #td7{width: 20%;}
        #td1{width: 30%;}
    </style>

</html>
