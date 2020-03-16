<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@page import="Entity.CompteAssure"%>
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
        <jsp:useBean id="sessionAssure" scope="session" class="CompteAssure"></jsp:useBean>
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
                                <li class="active_progressebar"><span>Vos infos</span></li>
                                <li><span>Votre tarif</span></li>
                                <li><span>Souscription</span></li>
                            </ul>
                        </div>
                        <div class="formulaire_devis">
                            <form role="form" method="post" action="menuDrajak">

                                <table class="devisPartieInfos">
                                <!-- ligne tableau devis -->
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td width rowspan="2"class="colonneEnteteLigneImpaire">1</td>
                                        <td class="colonne2Lignehaut">Premier adulte</td>
                                    </tr>
                                    <tr class="ligneGeneraleTableau">
                                        <td class="colonne2LigneBas">
                                            <section class="sectionFormulaireRadio" style="background-color: transparent">
                                                <div style="flex:0">
                                                    <input type="radio" name="genre" id="genre1" value="adulte1" checked>
                                                    <label for="genre1">Homme</label>
                                                </div>
                                                <div style="flex:0">
                                                    <input type="radio" name="genre" id="genre2" value="adulte2">
                                                    <label for="genre2">Femme</label>
                                                </div>
                                            </section>
                                            <section>
                                                <div>
                                                    <label for="bday">Date de naissance :</label>
                                                    <input type="date" id="bday" name="bday">
                                                </div>
                                                <div>
                                                    <label for="selectRegime">Régime :</label>
                                                    <select name="selectRegime">
                                                        <option value="SS">Sécurité sociale</option>
                                                        <option value="AM">Alsace Moselle</option>
                                                    </select>
                                                </div>
                                            </section>
                                        </td>
                                    </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td rowspan="2"class="colonneEnteteLignePaire">1</td>
                                        <td class="colonne2Lignehaut">Vos enfants :</td>
                                    </tr>
                                    <tr class="ligneGeneraleTableau">
                                        <td class="colonne2LigneBas">
                                            <section>
                                                <div>
                                                    <label for="enfantSelect">Combien d'enfants souhaitez-vous assurer ?</label>
                                                    <select name="enfantSelect">
                                                        <option>1 enfants</option>
                                                        <option>2 enfants</option>
                                                        <option>3 enfants</option>
                                                        <option>4 enfants</option>
                                                        <option>5 enfants</option>
                                                        <option>6 enfants</option>
                                                        <option>7 enfants</option>
                                                        <option>8 enfants</option>
                                                        <option>9 enfants</option>
                                                        <option>10 enfants</option>
                                                    </select>
                                                </div>
                                            </section>
                                            <script>
                                                function functionNbEnfant(){
                                                    var liste, nbenfants;
                                                    liste = document.getElementById("enfantSelect");
                                                    nbenfants = (liste.options[liste.selectedIndex].text).slice(0,-8);
                                                    return nbenfants;
                                                };
                                            </script>
                                                
                                        </td>
                                    </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td rowspan="2"class="colonneEnteteLigneImpaire">1</td>
                                        <td class="colonne2Lignehaut">1a</td>
                                    </tr>
                                    <tr class="ligneGeneraleTableau">
                                        <td class="colonne2LigneBas">1b</td>
                                    </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                    <tr class="ligneGeneraleTableauLignePaire">
                                        <td rowspan="2"class="colonneEnteteLignePaire">1</td>
                                        <td class="colonne2Lignehaut">1a</td>
                                    </tr>
                                    <tr class="ligneGeneraleTableau">
                                        <td class="colonne2LigneBas">1b</td>
                                    </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td rowspan="2"class="colonneEnteteLigneImpaire">1</td>
                                        <td class="colonne2Lignehaut">1a</td>
                                    </tr>
                                    <tr class="ligneGeneraleTableau">
                                        <td class="colonne2LigneBas">1b</td>
                                    </tr>
                                <!-- fin ligne tableau devis -->
                                </table>
                            </form>
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
