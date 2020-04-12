<%-- 
    Document   : menuEntreprise
    Created on : 12 mars 2020, 13:51:13
    Author     : Ilkayk
--%>

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
    </head>

    <body>

        <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_entreprise.jsp" %></c:otherwise>
        </c:choose>

        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Bonjour, </h1>
                        <p><c:out value="${sessionScope.sessionEntreprise.getRaisonSociale()}"/></p>
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
                    <div class="col-md-4 ftco-animate py-5 nav-link-wrap">
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <a class="nav-link px-4 active" id="v-pills-master-tab" data-toggle="pill" href="#v-pills-master" role="tab" aria-controls="v-pills-master" aria-selected="true"><span class="mr-3 flaticon-cardiogram"></span> Cardiology</a>

                            <a class="nav-link px-4" id="v-pills-buffet-tab" data-toggle="pill" href="#v-pills-buffet" role="tab" aria-controls="v-pills-buffet" aria-selected="false"><span class="mr-3 flaticon-neurology"></span> Neurology</a>

                            <a class="nav-link px-4" id="v-pills-fitness-tab" data-toggle="pill" href="#v-pills-fitness" role="tab" aria-controls="v-pills-fitness" aria-selected="false"><span class="mr-3 flaticon-stethoscope"></span> Diagnostic</a>

                            <a class="nav-link px-4" id="v-pills-reception-tab" data-toggle="pill" href="#v-pills-reception" role="tab" aria-controls="v-pills-reception" aria-selected="false"><span class="mr-3 flaticon-tooth"></span> Dental</a>

                            <a class="nav-link px-4" id="v-pills-sea-tab" data-toggle="pill" href="#v-pills-sea" role="tab" aria-controls="v-pills-sea" aria-selected="false"><span class="mr-3 flaticon-vision"></span> Ophthalmology</a>

                            <a class="nav-link px-4" id="v-pills-spa-tab" data-toggle="pill" href="#v-pills-spa" role="tab" aria-controls="v-pills-spa" aria-selected="false"><span class="mr-3 flaticon-ambulance"></span> Emergency</a>
                        </div>
                    </div>
                    <div class="col-md-8 ftco-animate p-4 p-md-5 d-flex align-items-center">

                        <div class="tab-content pl-md-5" id="v-pills-tabContent">

                           <div class="tab-pane fade show active py-5" id="v-pills-master" role="tabpanel" aria-labelledby="v-pills-master-tab">
                                <span><i style="font-size: 7em; color: #167ce9;margin-bottom: 20px;" class="far fa-file-alt"></i></span>
                                <h2 class="mb-4">Gérer mes contrats</h2>
                                <p>Accédez à vos contrats simplement.</p>
                                <p>Consulter la totalité de vos contrats ainsi que les personnes qui y sont rattachées.</p>
                                <p><a onclick="location.href = 'menuDrajak?action=Morale_GestionContrat_ListeContrat'" class="btn btn-primary">Accéder aux contrats</a></p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section-2 img" style="background-image: url(remedic/images/bg_3.jpg);">
            <div class="container">
                <div class="row d-md-flex justify-content-end">
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12">
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>PlaceHolder</h2>
                                    <p>Text PlaceHolder</p>
                                </a>
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>PlaceHolder</h2>
                                    <p>Text PlaceHolder</p>
                                </a>
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>PlaceHolder</h2>
                                    <p>Text PlaceHolder</p>
                                </a>
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>PlaceHolder</h2>
                                    <p>Text PlaceHolder</p>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-section-parallax">
            <div class="parallax-img d-flex align-items-center">
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
                            <h2>Souscrivez à notre Newsletter</h2>
                            <div class="row d-flex justify-content-center mt-5">
                                <div class="col-md-8">
                                    <form action="#" class="subscribe-form">
                                        <div class="form-group d-flex">
                                            <input type="text" class="form-control" placeholder="Entez votre adresse email">
                                            <input type="submit" value="Souscrire" class="submit px-3">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <footer class="ftco-footer ftco-bg-dark ftco-section img" style="background-image: url(remedic/images/bg_5.jpg);">
            <div class="overlay"></div>
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Drajak</h2>
                            <p>Une mutuelle pour tous, adaptée aux besoins de chacun.</p>
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4 ml-md-5">
                            <h2 class="ftco-heading-2">Information</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Devis</a></li>
                                <li><a href="#" class="py-2 d-block">Contrat</a></li>
                                <li><a href="#" class="py-2 d-block">Pourquoi nous choisir</a></li>
                                <li><a href="#" class="py-2 d-block">Services</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Navigation</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Accueil</a></li>
                                <li><a href="#" class="py-2 d-block">Qui sommes-nous ?</a></li>
                                <li><a href="#" class="py-2 d-block">Offres</a></li>
                                <li><a href="#" class="py-2 d-block">Particulier</a></li>
                                <li><a href="#" class="py-2 d-block">Entreprise</a></li>
                                <li><a href="#" class="py-2 d-block">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Vous avez des questions ?</h2>
                            <div class="block-23 mb-3">
                                <ul>
                                    <li><span class="icon icon-map-marker"></span><span class="text">1 avenue des Frères Lumière, 69008 Lyon, France</span></li>
                                    <li><a href="#"><span class="icon icon-phone"></span><span class="text">+3 4 99 98 97 96</span></a></li>
                                    <li><a href="#"><span class="icon icon-envelope"></span><span class="text">drajak@hardis-group.com</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>
                                document.write(new Date().getFullYear());

                            </script> Tous droits réservés | Site web Drajak <i class="icon-heart" aria-hidden="true"></i> 
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                </div>
            </div>
        </footer>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg></div>

        <%@include file="Shared/script_js.jsp" %>
    </body>

</html>
