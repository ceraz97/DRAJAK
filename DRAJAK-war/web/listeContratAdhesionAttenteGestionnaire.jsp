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
        <title>Contrats réalisés </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>

    <body>
        <script type="text/javascript">
        
        </script>    

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
                  <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Les contrats d'adhesions en attente</h1>                   
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    
                    <div class="formulaire_devis">
                        
                    
                            <!-- here should go some titles... -->
                           
                        <table>
                            <tr style="border-bottom: 1px solid #167ce9;">
                                <th>Contrat</th>
                                <th>Date d'effet</th>
                                <th>Date de fin</th>
                                <th>Statut</th>
                                <th>Type</th>
                                <th>Paiement</th>
                                <th>Nom Gestionnaire</th>
                                <th>Prenom Gestionnaire</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${requestScope.listeContratsRsr}" var="document">
                                <tr>
                                    <td id="td1">
                                        <c:out value="${document.getLibelleContrat()}" />
                                    </td>
                                    <td id="td2">
                                        <fmt:formatDate var="fmtDateDebut" value="${document.getDateCreation()}" pattern="dd/MM/yyyy"/>
                                        <c:out value="${fmtDateDebut}" />
                                    </td>
                                    <td id="td3">
                                        <fmt:formatDate var="fmtDateFin" value="${document.getDateFin()}" pattern="dd/MM/yyyy"/>
                                        <c:out value="${fmtDateFin}" />
                                    </td>
                                    <td id="td4">
                                        <c:out value="${document.getStatut()}" />
                                    </td>
                                    <td id="td5">
                                        <c:out value="${document.getType()}" />
                                    </td>
                                    <td id="TD6">
                                        <c:out value="${document.getPaiement()}" />
                                    </td>
                                     <td id="TD7">
                                        <c:out value="${document.getCleCompteEmploye().getNom()}" />
                                    </td>
                                    <td id="TD8">
                                        <c:out value="${document.getCleCompteEmploye().getPrenom()}" />
                                    </td>
                                    
                                    <td id="TD9">
                                        <c:choose>
                                            <c:when test="${ !empty sessionScope.sessionGestionnaire }">
                                                <button class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=GestionnaireM_GestionContrat_detailContrat&&idc=${document.getId()}'">Modifier</button>
                                            </c:when>
                                        </c:choose>
                                      
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
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
