<%-- 
    Document   : menuAdministrateur
    Created on : 12 mars 2020, 16:31:28
    Author     : Ilkayk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="menuAdministrateur.jsp"><i class="flaticon-pharmacy"></i><span>Dr</span>ajak</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="menuAdministrateur.jsp" class="nav-link">Gestion personnel</a></li>
                        <li class="nav-item"><a href="gestionPersonne.jsp" class="nav-link">Gestion personne</a></li>
                        <li class="nav-item"><a href="offre.jsp" class="nav-link">Gestion contrats</a></li>
                        <li class="nav-item"><a href="particulier.jsp" class="nav-link">Gestion produits</a></li>
                        <li class="nav-item"><a href="contact.jsp" class="nav-link">Gestion adhésion</a></li>
                        <li class="nav-item cta"><a href="accueilEmploye.jsp" class="nav-link"><span>Se déconnecter</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END nav -->

        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Admin</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-md-4 ftco-animate py-5 nav-link-wrap">
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <a class="nav-link px-4 active" id="v-pills-master-tab" data-toggle="pill" href="#v-pills-master" role="tab" aria-controls="v-pills-master" aria-selected="true"><span class="mr-3 flaticon-cardiogram"></span> Créer gestionnaire</a>

                            <a class="nav-link px-4" id="v-pills-buffet-tab" data-toggle="pill" href="#v-pills-buffet" role="tab" aria-controls="v-pills-buffet" aria-selected="false"><span class="mr-3 flaticon-neurology"></span> Modifier gestionnaire</a>

                            <a class="nav-link px-4" id="v-pills-fitness-tab" data-toggle="pill" href="#v-pills-fitness" role="tab" aria-controls="v-pills-fitness" aria-selected="false"><span class="mr-3 flaticon-stethoscope"></span> Liste des gestionnaires</a>

                        </div>
                    </div>
                    <div class="col-md-8 ftco-animate p-4 p-md-5 d-flex align-items-center">

                        <div class="tab-content pl-md-5" id="v-pills-tabContent">

                            <div class="tab-pane fade show active py-5" id="v-pills-master" role="tabpanel" aria-labelledby="v-pills-master-tab">
                                <span class="icon mb-3 d-block flaticon-cardiogram"></span>
                                <h2 class="mb-4">Création d'un gestionnaire</h2>
                                <p>Compléter le formulaire et créer un gestionnaire.</p>
                                <p><a href="creationGestionnaire.jsp" class="btn btn-primary">Cliquez ici</a></p>
                            </div>

                            <div class="tab-pane fade show active py-5" id="v-pills-master" role="tabpanel" aria-labelledby="v-pills-master-tab">
                                <span class="icon mb-3 d-block flaticon-cardiogram"></span>
                                <h2 class="mb-4">Modification d'un gestionnaire</h2>
                                <p>Choisissez un gestionnaire puis modifier certaines de ses informations.</p>
                                <p><a href="modificationGestionnaire.jsp" class="btn btn-primary">Cliquez ici</a></p>
                            </div>

                            <div class="tab-pane fade show active py-5" id="v-pills-master" role="tabpanel" aria-labelledby="v-pills-master-tab">
                                <span class="icon mb-3 d-block flaticon-cardiogram"></span>
                                <h2 class="mb-4">Afficher la liste des gestionnaires</h2>
                                <p>Permet de visualier la liste de tous les gestionnaires.</p>
                                <p><a href="listeGestionnaire.jsp" class="btn btn-primary">Cliquez ici</a></p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg></div>

        <%@include file="Shared/script_js.jsp" %>
    </body>

</html>
