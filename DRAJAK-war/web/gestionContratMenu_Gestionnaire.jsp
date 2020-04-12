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
            function getConfirmResiliation(nomContrat,idContrat)  {
                var result = confirm("Voulez vous résilier le contrat "+nomContrat+"?");
                if(result)  {
                    location.href = "menuDrajak?action=Assure_GestionContrat_resilier&idc="+idContrat;
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
            <div class="container" style="margin-bottom: 200px;">
                <div class="row no-gutters" style="height: 700px;">
                    <div class="col-md-4 ftco-animate py-5 nav-link-wrap">
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <a class="nav-link px-4 active" id="v-pills-master-tab" data-toggle="pill" href="#v-pills-master" role="tab" aria-controls="v-pills-master" aria-selected="true"><span class="mr-3"><i style="margin-right: 10px;" class="far fa-file-alt"></i></span>Collectifs</a>

                            <a class="nav-link px-4" id="v-pills-buffet-tab" data-toggle="pill" href="#v-pills-buffet" role="tab" aria-controls="v-pills-buffet" aria-selected="false"><span><i style="margin-right: 10px;" class="fas fa-calculator"></i></span> Individuels</a>

                        </div>
                    </div>
                    <div class="col-md-8 ftco-animate p-4 p-md-5 d-flex align-items-center">

                        <div class="tab-content pl-md-5" id="v-pills-tabContent">

                            <div class="tab-pane fade show active py-5" id="v-pills-master" role="tabpanel" aria-labelledby="v-pills-master-tab">
                                <span><i style="font-size: 7em; color: #167ce9;margin-bottom: 20px;" class="far fa-file-alt"></i></span>
                                <h2 class="mb-4">Gérer mes contrats</h2>
                                <p>Accédez à vos contrats simplement. Suivez l'avancer de vos demandes et réalisez en d'autres</p>
                                <p>Consulter la totalité de vos contrats ainsi que les garanties dont vous disposez.</p>
                                <p><a onclick="location.href = 'menuDrajak?action=Gestionnaire_versCreationContratCollectif'" class="btn btn-primary">Creer Contrat collectif</a></p>
                                <p><a onclick="location.href = '#'" class="btn btn-primary">Voir les contrat collectif</a></p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-buffet" role="tabpanel" aria-labelledby="v-pills-buffet-tab">
                                <span><i style="font-size: 7em; color: #167ce9;margin-bottom: 20px;" class="fas fa-calculator"></i></span>
                                <h2 class="mb-4">Réaliser des devis</h2>
                                <p>Vous souhaitez réaliser un devis.</p>
                                <p>Choisissez les éléments qui vous intéresse et obtenez le prix de votre prochaine cotisation.</p>
                                <p>
                                    <a onclick="location.href = 'menuDrajak?action=DemandeDevis_besoins'" class="btn btn-primary btn-ajoute" style="margin-right: 20px;">Créer un contrat individuel en simulation</a>
                                    <a onclick="location.href = '#'" class="btn btn-primary btn-ajoute" style="margin-right: 20px;">Créer un contrat individuel sur mesure</a>
                                </p>
                            </div>

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
