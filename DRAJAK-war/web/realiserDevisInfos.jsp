<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@page import="Entity.CompteAssure"%>
<%@page import="Enum.Genre"%>
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



    <!-- Affichage du menu suivant l'utilisateur-->
    <%String attributSession = (String) request.getAttribute("typeSession");
            if (attributSession.equalsIgnoreCase("sessionAssure")) {%>
    <%@include file="Menus/NavBar_assure.jsp" %>
    <jsp:useBean id="sessionAssure" scope="session" class="CompteAssure"></jsp:useBean>
    <%  Genre genreAssure = sessionAssure.getCleParticulier().getGenre();

        } else if (attributSession.equalsIgnoreCase("sessionPublic")) {%>
    <%@include file="Menus/NavBar_public.jsp" %>
    <%} else if (attributSession.equalsIgnoreCase("sessionGestionnaire")) {%>
    <%@include file="Menus/NavBar_gestionnaire.jsp" %>
    <%} else if (attributSession.equalsIgnoreCase("sessionEntreprise")) {%>
    <%@include file="Menus/NavBar_entreprise.jsp" %>
    <%} else if (attributSession.equalsIgnoreCase("sessionAdministrateur")) {%>
    <%@include file="Menus/NavBar_administrateur.jsp" %>
    <%}
    %>

    <%
        int nbAdulte = (Integer) request.getAttribute("nbAdulte");
        int trancheAge = (Integer) request.getAttribute("trancheAge");
        String enfant = (String) request.getAttribute("enfant");
        int couverture = (Integer) request.getAttribute("couverture");
        int optiqueDentaire = (Integer) request.getAttribute("optiqueDentaire");

    %>

    <script language="JavaScript">
        function checkedOne(genreAssure)
        {
            if (genreAssure == "Homme")
            {
                document.formulaireDevis2.genre[0].checked = true;
            } else if (genreAssure == "Femme")
            {
                document.formulaireDevis2.genre[1].checked = true;
            } else if (genreAssure == "Neutre")
            {
                document.formulaireDevis2.genre[2].checked = true;
            }
        }
    </script>
    <body>
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
                        <form role="form" method="post" action="menuDrajak" name="formulaireDevis2">

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
                                                <input type="radio" name="genre" id="genre1" value="adulte1g1" >
                                                <label for="genre1">Homme</label>
                                            </div>
                                            <div style="flex:0">
                                                <input type="radio" name="genre" id="genre2" value="adulte1g2" >
                                                <label for="genre2">Femme</label>
                                            </div>
                                            <div style="flex:0">
                                                <input type="radio" name="genre" id="genre3" value="adulte1g3">
                                                <label for="genre3">Neutre</label>
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
                                    <td rowspan="2"class="colonneEnteteLignePaire">2</td>
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
                                            function functionNbEnfant() {
                                                var liste, nbenfants;
                                                liste = document.getElementById("enfantSelect");
                                                nbenfants = (liste.options[liste.selectedIndex].text).slice(0, -8);
                                                return nbenfants;
                                            }
                                            ;
                                        </script>
                                        <section class="formulaireEnfant">
                                            <div>
                                                <section class="sectionFormulaireRadio" style="background-color: transparent">
                                                    <div style="flex:0">
                                                        <input type="radio" name="genreE" id="genre1E1" value="genre1E1" checked> 

                                                        <label for="genre1E1">Garcon</label>
                                                    </div>
                                                    <div style="flex:0">
                                                        <input type="radio" name="genreE" id="genre2E1" value="genre2E1">
                                                        <label for="genre2E1">Fille</label>
                                                    </div>
                                                    <div style="flex:0">
                                                        <input type="radio" name="genreE" id="genre3E1" value="genre3E1">
                                                        <label for="genre3E1">Neutre</label>
                                                    </div>
                                                </section>
                                                <div>
                                                    <label for="bday">Date de naissance :</label>
                                                    <input type="date" id="bday" name="bday">
                                                </div>
                                            </div>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLigneImpaire">3</td>
                                    <td class="colonne2Lignehaut">Votre adresse principale :</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <section>
                                            <div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrNum" name="adrNum" placeholder="Numéro de rue"></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrNomRue" name="adrNomRue" placeholder="Nom de rue"></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrCP" name="adrCP" placeholder="Code Postal"></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrVille" name="adrVille" placeholder="Ville"></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrPays" name="adrPays" placeholder="Pays"></div>
                                            </div>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td rowspan="2"class="colonneEnteteLigneImpaire">4</td>
                                    <td class="colonne2Lignehaut">Votre adresse email :</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <section>
                                            <div>
                                                <div class="champsAdresseDevis"><input type="mail" id="adrMail" name="adrMail" placeholder="email@exemple.com"></div>
                                            </div>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                            </table>
                            <div class="form-group">
                                <input type="button" value="Obtenir tarifs" onclick="location.href = 'menuDrajak?action=DemandeDevis_infos'">
                                <button type="submit" class="btn btn-primary btn-block btn-formulaire" value="Valider">Obtenir tarifs</button>
                            </div>
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
