<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@page import="Entity.CompteAssure"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>PFE</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
        <jsp:useBean id="sessionAssure" scope="session" class="CompteAssure"></jsp:useBean>
        </head>

        <body>

        <%@include file="Menus/NavBar_assure.jsp" %>

        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Bonjour</h1>
                        <p><%out.println(sessionAssure.getCleParticulier().getNom() + " " + sessionAssure.getCleParticulier().getPrenom());%></p>
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
                            <a class="nav-link px-4 active" id="v-pills-master-tab" data-toggle="pill" href="#v-pills-master" role="tab" aria-controls="v-pills-master" aria-selected="true"><span class="mr-3"><i style="margin-right: 10px;" class="far fa-file-alt"></i></span>Contrats</a>

                            <a class="nav-link px-4" id="v-pills-buffet-tab" data-toggle="pill" href="#v-pills-buffet" role="tab" aria-controls="v-pills-buffet" aria-selected="false"><span><i style="margin-right: 10px;" class="fas fa-calculator"></i></span> Devis</a>

                            <a class="nav-link px-4" id="v-pills-fitness-tab" data-toggle="pill" href="#v-pills-fitness" role="tab" aria-controls="v-pills-fitness" aria-selected="false"><span class="mr-3 flaticon-stethoscope"></span> Soins</a>

                            <a class="nav-link px-4" id="v-pills-reception-tab" data-toggle="pill" href="#v-pills-reception" role="tab" aria-controls="v-pills-reception" aria-selected="false"><span><i class="fas fa-user"></i></span> Mon compte</a>
                        </div>
                    </div>
                    <div class="col-md-8 ftco-animate p-4 p-md-5 d-flex align-items-center">

                        <div class="tab-content pl-md-5" id="v-pills-tabContent">

                            <div class="tab-pane fade show active py-5" id="v-pills-master" role="tabpanel" aria-labelledby="v-pills-master-tab">
                                <span><i style="font-size: 7em; color: #167ce9;margin-bottom: 20px;" class="far fa-file-alt"></i></span>
                                <h2 class="mb-4">Gérer mes contrats</h2>
                                <p>Accédez à vos contrats simplement. Suivez l'avancer de vos demandes et réalisez en d'autres</p>
                                <p>Consulter la totalité de vos contrats ainsi que les garanties dont vous disposez.</p>
                                <p><a onclick="location.href = 'menuDrajak?action=Assure_GestionContrat_ListeContrat'" class="btn btn-primary">Accéder aux contrats</a></p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-buffet" role="tabpanel" aria-labelledby="v-pills-buffet-tab">
                                <span><i style="font-size: 7em; color: #167ce9;margin-bottom: 20px;" class="fas fa-calculator"></i></span>
                                <h2 class="mb-4">Réaliser des devis</h2>
                                <p>Vous souhaitez réaliser un devis.</p>
                                <p>Choisissez les éléments qui vous intéresse et obtenez le prix de votre prochaine cotisation.</p>
                                <p>
                                    <a onclick="location.href = 'menuDrajak?action=DemandeDevis_besoins'" class="btn btn-primary btn-ajoute" style="margin-right: 20px;">Réaliser un devis santé</a>
                                    <a onclick=" href = '#'" class="btn btn-primary btn-ajoute">Réaliser un devis assurance</a>
                                </p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-fitness" role="tabpanel" aria-labelledby="v-pills-fitness-tab">
                                <span class="icon mb-3 d-block flaticon-stethoscope"></span>
                                <h2 class="mb-4">Prise en charge</h2>
                                <p>Vous avez réalisé une dépense pour des soins et vous souhaitez vous faire rembourser, vous souhaiter faire une demande de prise en charge</p>
                                <p>Mu nissez vous de votre justificatif et nous nous occupons du reste.</p>
                                <p>
                                    <a onclick="location.href = 'menuDrajak?action=Assure_versDemandeDeSoins'" class="btn btn-primary btn-ajoute" style="margin-right: 20px;">Remboursements des soins</a>
                                    <a href="#" class="btn btn-primary btn-ajoute">Demande de prise en charge</a>
                                </p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-reception" role="tabpanel" aria-labelledby="v-pills-reception-tab">
                                <span><i style="font-size: 7em; color: #167ce9;margin-bottom: 20px;" class="fas fa-user"></i></span>
                                <h2 class="mb-4">Mon compte</h2>
                                <p>Retrouvez toutes vos informations personnelles</p>
                                <p><a onclick="location.href = 'menuDrajak?action=Assure_InformationsCompte'" class="btn btn-primary btn-ajoute">Mon compte</a></p>
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

</html>
