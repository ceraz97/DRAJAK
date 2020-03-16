<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Demande de devis</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="accueil.jsp"><i class="flaticon-pharmacy"></i><span>Dr</span>ajak</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="accueil.jsp" class="nav-link">Accueil</a></li>
                        <li class="nav-item"><a href="about.jsp" class="nav-link">Qui sommes-nous ?</a></li>
                        <li class="nav-item"><a href="offre.jsp" class="nav-link">Offres</a></li>
                        <li class="nav-item"><a href="particulier.jsp" class="nav-link">Particulier</a></li>
                        <li class="nav-item"><a href="entreprise.jsp" class="nav-link">Entreprise</a></li>
                        <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
                        <li class="nav-item cta"><a href="accueil.jsp" class="nav-link" data-toggle="modal" data-target="#modalAppointment"><span>Se connecter</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Modal -->
        <div class="modal fade" id="modalAppointment" tabindex="-1" role="dialog" aria-labelledby="modalAppointmentLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalAppointmentLabel">Connexion</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <ul class="nav navbar-nav">
                            <div class="row">
                                <div class="col-md-12">
                                    Vous êtes
                                    <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                                        <div class="social-buttons">
                                            <a id="btnParticlier" class="btn btn-primary btn-blockCo">Particulier</a>
                                            <a id="btnEntreprise" class="btn btn-primary btn-blockCo">Entreprise</a>
                                        </div>
                                        <div class="ensembleBooutonsRadio">
                                            <div class = "radioButtonStyle">
                                                <input class ="RadioButtonStyle" name="action" type="radio" id="AssureMenu" value="AssureAuthentification" checked="true"/>
                                                <label for="action">Particulier</label>
                                            </div>
                                            <div class="radioButtonStyle">
                                                <input class ="RadioButtonStyle" name="action" type="radio" id="EntrepriseMenu" value="EntrepriseAuthentification"/>
                                                <label for="action">Entreprise</label>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="sr-only" for="login">Adresse email</label>
                                            <input type="email" class="form-control" name="login" placeholder="Adresse email" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="mdp">Mot de passe</label>
                                            <input type="password" class="form-control" name="mdp" placeholder="Mot de passe" required>
                                            <div class="help-block text-right"><a href="">Mot de passe oublié ?</a></div>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-block" value="Valider">Connexion</button>
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Garder ma session active
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <div class="bottom text-center">
                                    Vous êtes nouveau ? <a href="#"><b>Rejoignez-nous</b></a>
                                </div>
                            </div>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
        <!-- END nav -->

        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Réaliser un devis santé</h1>                   
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="container_progressbar">
                        <ul class="progressbar">
                            <li><span>Vos besoins</span></li>
                            <li class="active_progressebar"><span>Vos infos</span></li>
                            <li><span>Votre tarif</span></li>
                            <li><span>Souscription</span></li>
                        </ul>
                    </div>
                    <div class="formulaire_devis">
                        <form role="form" method="post" action="menuDrajak">
                            <div class='partie_formulaire_devis'>
                                <p>Adultes à assurer :</p>
                                <section class="sectionFormulaireRadio">
                                    <div>
                                        <input type="radio" name="adulte" id="adulte1" value="1adulte" checked>
                                        <label for="adulte1">
                                            <p>1 adulte</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="adulte" id="adulte2" value="2adulte">
                                        <label for="adulte2">
                                            <p>2 adultes</p>
                                        </label>
                                    </div>

                                </section>
                            </div>
                            <div class='partie_formulaire_devis'>
                                <p>L'adulte le plus agé a :</p>
                                <section class="sectionFormulaireRadio">
                                    <div>
                                        <input type="radio" name="age" id="age1" value="age1" checked>
                                        <label for="age1">
                                            <p>Entre 18 et 34 ans</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="age" id="age2" value="age2">
                                        <label for="age2">
                                            <p>Entre 35 et 54 ans</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="age" id="age3" value="age3">
                                        <label for="age3">
                                            <p>Entre 55 et 70 ans</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="age" id="age4" value="age4">
                                        <label for="age4">
                                            <p>Entre 71 et 80 ans</p>
                                        </label>
                                    </div>
                                </section>
                            </div>

                            <div class='partie_formulaire_devis'>
                                <p>Enfants à assurer :</p>
                                <section class="sectionFormulaireRadio">
                                    <div>
                                        <input type="radio" name="enfant" id="sansEnfant" value="sansEnfant" checked>
                                        <label for="sansEnfant">
                                            <p>Aucun</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="enfant" id="avecEnfant" value="avecEnfant">
                                        <label for="avecEnfant">
                                            <p>Un ou plus</p>
                                        </label>
                                    </div>

                                </section>
                            </div>

                            <div class='partie_formulaire_devis'>
                                <p>Vous voulez être couvert en priorité pour :</p>
                                <section class="sectionFormulaireRadio">
                                    <div>
                                        <input type="radio" name="couverture" id="couverture1" value="couverture1" checked>
                                        <label for="couverture1">
                                            <p>Les gros pépins comme l'hospitalisation</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="couverture" id="couverture2" value="couverture2">
                                        <label for="couverture2">
                                            <p>les gros pépins mais aussi les soins courants</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="couverture" id="couverture3" value="couverture3">
                                        <label for="couverture3">
                                            <p>La majorité des vos dépenses de santé</p>
                                        </label>
                                    </div>
                                </section>
                            </div>

                            <div class='partie_formulaire_devis'>
                                <p>Pour vous, être bien remlboursé en optique et dentaire :</p>
                                <section class="sectionFormulaireRadio">
                                    <div>
                                        <input type="radio" name="optiqueDentaire" id="optiqueDentaire1" value="optiqueDentaire1" checked>
                                        <label for="optiqueDentaire1">
                                            <p>C'est important mais pas prioritaire</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="optiqueDentaire" id="optiqueDentaire2" value="optiqueDentaire2">
                                        <label for="optiqueDentaire2">
                                            <p>C'est indispensable</p>
                                        </label>
                                    </div>
                                </section>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block btn-formulaire" value="Valider">Obtenir tarifs</button>
                            </div>
                        </form>
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
