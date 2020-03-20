<%-- 
    Document   : menuAssure
    Created on : 12 mars 2020, 13:46:20
    Author     : Ilkayk
--%>
<%@ page import="Entity.CompteAssure"%>
<%@ page import="Enum.Genre"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <c:choose>
        <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
        <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
        <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
        <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
        <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
    </c:choose>
    <fmt:formatDate var="fmtDate" value="${sessionScope.sessionAssure.getCleParticulier().getDateNaissance()}" pattern="yyyy-MM-dd"/>
    <c:set var="adresseFromBD" value="${sessionScope.sessionAssure.getCleParticulier().getAdresse()}"/>
    <c:set var="adresseSplit" value="${fn:split(adresseFromBD, ',')}"/>
    <script>
        window.onload = function() {
            document.getElementById('formulaireEnfant2').style.display = 'none';
            document.getElementById('formulaireEnfant3').style.display = 'none';
        };

        function functionNbEnfant()
        {
            var liste = document.getElementById('enfantSelectId');
            var nbenfants = liste.options[liste.selectedIndex].text;

            if (nbenfants === '1 enfant') {
                document.getElementById('formulaireEnfant2').style.display = 'none';
                document.getElementById('formulaireEnfant3').style.display = 'none';
            } else if (nbenfants === '2 enfants') {
                document.getElementById('formulaireEnfant2').style.display = 'block';
                document.getElementById('formulaireEnfant3').style.display = 'none';
            } else {
                document.getElementById('formulaireEnfant2').style.display = 'block';
                document.getElementById('formulaireEnfant3').style.display = 'block';
            }

        }
        ;
    </script>
    <body>
        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4"><c:out value="Réaliser un devis santé"/></h1>                   
                    </div>
                </div>
            </div>
        </div>


        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="container_progressbar">
                        <ul class="progressbar">
                            <li class="active_progressebar"><a href="javascript:history.go(-1)"><span>Vos besoins</span></a></li>
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
                                                <input type="radio" name="genre" id="genre1" value="adulte1g1" <c:choose><c:when test="${sessionScope.sessionAssure.getCleParticulier().getGenre() eq 'Homme'}">checked</c:when><c:otherwise>checked</c:otherwise></c:choose>>
                                                        <label for="genre1">Homme</label>
                                                    </div>
                                                    <div style="flex:0">
                                                            <input type="radio" name="genre" id="genre2" value="adulte1g2" <c:if test="${sessionScope.sessionAssure.getCleParticulier().getGenre() eq 'Femme'}">checked</c:if>>
                                                    <label for="genre2">Femme</label>
                                                </div>
                                                <div style="flex:0">
                                                    <input type="radio" name="genre" id="genre3" value="adulte1g3" <c:if test="${sessionScope.sessionAssure.getCleParticulier().getGenre() eq 'Neutre'}">checked</c:if>>
                                                    <label for="genre3">Neutre</label>
                                                </div>
                                            </section>
                                            <section>
                                                <div>
                                                    <label for="bday">Date de naissance :</label>

                                                    <input type="date" id="bday" name="bday" value="${fmtDate}" required>
                                            </div>
                                            <div>
                                                <label for="selectRegime">Régime :</label>
                                                <select name="selectRegime" required>
                                                    <option value="SS" <c:choose><c:when test="${sessionScope.sessionAssure.getCleRegimeSocial().getLibelle() eq 'Régime Général'}">selected</c:when><c:otherwise>checked</c:otherwise></c:choose>>Sécurité sociale</option>
                                                    <option value="AM" <c:if test="${sessionScope.sessionAssure.getCleRegimeSocial().getLibelle() eq 'Alsace Moselle'}">selected</c:if>>Alsace Moselle</option>
                                                </select>
                                            </div>
                                            <c:out value="${param.selectRegime}"/>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                                <c:if test="${requestScope.nbAdulte == 2}">
                                    <tr class="ligneGeneraleTableauLigneImpaire">
                                        <td width rowspan="2"class="colonneEnteteLigneImpaire"></td>
                                        <td class="colonne2Lignehaut">Deuxième adulte</td>
                                    </tr>
                                    <tr class="ligneGeneraleTableau">
                                        <td class="colonne2LigneBas">
                                            <section class="sectionFormulaireRadio" style="background-color: transparent">
                                                <div style="flex:0">
                                                    <input type="radio" name="genre2" id="genre1A2" value="adulte2g1" checked>
                                                    <label for="genre1A2">Homme</label>
                                                </div>
                                                <div style="flex:0">
                                                    <input type="radio" name="genre2" id="genre2A2" value="adulte2g2" >
                                                    <label for="genre2A2">Femme</label>
                                                </div>
                                                <div style="flex:0">
                                                    <input type="radio" name="genre2" id="genre3A2" value="adulte2g3">
                                                    <label for="genre3A2">Neutre</label>
                                                </div>
                                            </section>
                                            <section>
                                                <div>
                                                    <label for="bdayA2">Date de naissance :</label>
                                                    <input type="date" id="bdayA2" name="bdayA2" required>
                                                </div>
                                                <div>
                                                    <label for="selectRegimeA2">Régime :</label>
                                                    <select name="selectRegimeA2">
                                                        <option value="SS" required>Sécurité sociale</option>
                                                        <option value="AM">Alsace Moselle</option>
                                                    </select>
                                                </div>
                                            </section>
                                        </td>
                                    </tr>
                                </c:if>

                                <c:if test="${requestScope.enfant eq 'avec'}">
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
                                                    <select name="enfantSelect" id="enfantSelectId" onchange="functionNbEnfant()" required>
                                                        <option selected>1 enfant</option>
                                                        <option>2 enfants</option>
                                                        <option>3 enfants</option>
                                                    </select>
                                                </div>
                                            </section>

                                            <section class="formulaireEnfant" id="formulaireEnfant1">
                                                <div>
                                                    <section class="sectionFormulaireRadio" style="background-color: transparent" selected>
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE1" id="genre1E1" value="genre1E1" checked> 

                                                            <label for="genre1E1">Garcon</label>
                                                        </div>
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE1" id="genre2E1" value="genre2E1">
                                                            <label for="genre2E1">Fille</label>
                                                        </div>
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE1" id="genre3E1" value="genre3E1">
                                                            <label for="genre3E1">Neutre</label>
                                                        </div>
                                                    </section>
                                                    <div>
                                                        <label for="bdayE1">Date de naissance :</label>
                                                        <input type="date" id="bdayE1" name="bdayE1" required>
                                                    </div>
                                                </div>
                                            </section>
                                            <section class="formulaireEnfant" id="formulaireEnfant2">
                                                <div style="margin: 50px auto;">
                                                    <section class="sectionFormulaireRadio" style="background-color: transparent">
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE2" id="genre1E2" value="genre1E1" checked> 

                                                            <label for="genre1E2">Garcon</label>
                                                        </div>
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE2" id="genre2E2" value="genre2E1">
                                                            <label for="genre2E2">Fille</label>
                                                        </div>
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE2" id="genre3E2" value="genre3E1">
                                                            <label for="genre3E2">Neutre</label>
                                                        </div>
                                                    </section>
                                                    <div>
                                                        <label for="bdayE2">Date de naissance :</label>
                                                        <input type="date" id="bdayE2" name="bdayE2" required>
                                                    </div>
                                                </div>
                                            </section>
                                            <section class="formulaireEnfant" id="formulaireEnfant3">
                                                <div>
                                                    <section class="sectionFormulaireRadio" style="background-color: transparent">
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE3" id="genre1E3" value="genre1E3" checked> 

                                                            <label for="genre1E3">Garcon</label>
                                                        </div>
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE3" id="genre2E3" value="genre2E3">
                                                            <label for="genre2E3">Fille</label>
                                                        </div>
                                                        <div style="flex:0">
                                                            <input type="radio" name="genreE3" id="genre3E3" value="genre3E3">
                                                            <label for="genre3E3">Neutre</label>
                                                        </div>
                                                    </section>
                                                    <div>
                                                        <label for="bdayE">Date de naissance :</label>
                                                        <input type="date" id="bdayE3" name="bdayE3" required>
                                                    </div>
                                                </div>
                                            </section>
                                        </td>
                                    </tr>
                                    <!-- fin ligne tableau devis -->
                                </c:if>
                                <!-- ligne tableau devis -->
                                <tr class="ligneGeneraleTableauLigneImpaire">
                                    <td width rowspan="2"class="colonneEnteteLigneImpaire">3</td>
                                    <td class="colonne2Lignehaut">Votre adresse principale :</td>
                                </tr>
                                <tr class="ligneGeneraleTableau">
                                    <td class="colonne2LigneBas">
                                        <section>
                                            <div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrNum" name="adrNum" placeholder="Numéro de rue" value="${adresseSplit[0]}" required></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrNomRue" name="adrNomRue" placeholder="Nom de rue" value="${adresseSplit[1]}" required></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrCP" name="adrCP" placeholder="Code Postal" value="${adresseSplit[2]}" required></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrVille" name="adrVille" placeholder="Ville" value="${adresseSplit[3]}" required></div>
                                                <div class="champsAdresseDevis"><input type="text" id="adrPays" name="adrPays" placeholder="Pays" value="${adresseSplit[4]}" required></div>
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
                                                <div class="champsAdresseDevis"><input type="mail" id="adrMail" name="adrMail" placeholder="email@exemple.com" value="${sessionScope.sessionAssure.getLogin()}" required></div>
                                            </div>
                                        </section>
                                    </td>
                                </tr>
                                <!-- fin ligne tableau devis -->
                            </table>
                            <div class="form-group">
                                <input type="hidden" name="action" value="DemandeDevis_tarif"/>

                                <input type="hidden" name="adulteHidden" value="${requestScope.nbAdulte}"/>
                                <input type="hidden" name="ageHidden" value="${requestScope.trancheAge}"/>
                                <input type="hidden" name="enfantHidden" value="${requestScope.enfant}"/>
                                <input type="hidden" name="couvertureHidden" value="${requestScope.couverture}"/>
                                <input type="hidden" name="optiqueDentaireHidden" value="${requestScope.optiqueDentaire}"/>

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
