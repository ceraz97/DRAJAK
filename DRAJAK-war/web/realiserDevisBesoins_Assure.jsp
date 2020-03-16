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
        <!-- Menu Assure -->
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="accueil.jsp"><i class="flaticon-pharmacy"></i><span>Dr</span>ajak</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="accueil.jsp" class="nav-link">Accueil</a></li>
                        <li class="nav-item"><a href="about.jsp" class="nav-link">Gérer mes contrats</a></li>
                        <li class="nav-item"><a href="offre.jsp" class="nav-link">Simulation</a></li>
                        <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
                        <li class="nav-item"><a class="nav-link">Mon espace</a>

                        <li class="nav-item"><a href="particulier.jsp" class="nav-link">Mes infos</a></li>
                        <li class="nav-item cta"><a onclick="location.href = 'menuDrajak?action=Deconnexion&typeConnexion=AssureMenu'" class="nav-link"><span>Se déconnecter</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Fin Menu Assure -->

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
                            <li class="active_progressebar"><span>Vos besoins</span></li>
                            <li><span>Vos infos</span></li>
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
                                        <input type="radio" name="adulte" id="adulte1" value="adulte1" checked>
                                        <label for="adulte1">
                                            <p>1 adulte</p>
                                        </label>
                                    </div>
                                    <div>
                                        <input type="radio" name="adulte" id="adulte2" value="adulte2">
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
                                <input type="button" value="Obtenir tarifs" onclick="location.href='menuDrajak?action=DemandeDevis_infos'">
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
