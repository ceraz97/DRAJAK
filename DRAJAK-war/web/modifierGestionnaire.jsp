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
        <title>Modifier le gestionnaire</title>
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
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Modifier un gestionniare</h1>                   
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
                    <div class="formulaire_devis">
                        <div>
                            <p style="color:#167ce9;font-size: 18px"><i class="fas fa-info-circle"></i> Informations gestionnaire</p>
                            <div style="padding-left: 40px; margin-bottom: 30px;">
                                <p>Numéro : <c:out value="${requestScope.gest.getId()}"/></p>
                                <p>Nom  : <c:out value="${requestScope.gest.getNom()}"/></p>
                                <p>Prenom : <c:out value="${requestScope.gest.getPrenom()}"/></p>
                                <p>Genre: <c:out value="${requestScope.gest.getGenre()}"/></p>
                                <fmt:formatDate var="fmtDobAssure" value="${requestScope.gest.getDateNaissance()}" pattern="dd/MM/yyyy"/>
                                <p>Date Naissance : <c:out value="${fmtDobAssure}"/></p>
                                <p>Adresse : <c:out value="${requestScope.gest.getAdresse()}"/></p>
                                <p>Num téléphone : <c:out value="${requestScope.gest.getnTelephone()}"/></p>
                                
                                <p>Mail : <c:out value="${requestScope.gest.getEmail()}"/></p>
                                
                                <div>
                                            <div class="champsAdresseDevis"><label for="adrNum">Numéro :</label><input type="text" id="adrNum" name="adrNum" placeholder="${adresseSplit[0]}" value=""></div>
                                            <div class="champsAdresseDevis"><label for="adrNomRue">Rue :</label><input type="text" id="adrNomRue" name="adrNomRue" placeholder="${adresseSplit[1]}" value="" ></div>
                                            <div class="champsAdresseDevis"><label for="adrCP">Code Postal :</label><input type="text" id="adrCP" name="adrCP" placeholder="${adresseSplit[2]}" value=""></div>
                                            <div class="champsAdresseDevis"><label for="adrVille">Ville :</label><input type="text" id="adrVille" name="adrVille" placeholder="${adresseSplit[3]}" value=""></div>
                                            <div class="champsAdresseDevis"><label for="adrPays">Pays :</label><input type="text" id="adrPays" name="adrPays" placeholder="${adresseSplit[4]}" value=""></div>
                                </div>
                                
                                 <div>
                                            <div class="champsAdresseDevis"><label for="adrNumtel">Numéro Téléphone :</label><input type="text" id="adrNum" name="adrNumtel" placeholder="" value=""></div>
                                          
                                </div>
                                
                            
                                
                                  <button class="btn btn-primary btn-co" onclick="location.href = 'menuDrajak?action=ModificationGestionnaireAdresseTel&&idc=${requestScope.gest.getId()}'">Modifier ( ne fonctionne pas)</button>
                                  
                                 
                                
                                  
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
