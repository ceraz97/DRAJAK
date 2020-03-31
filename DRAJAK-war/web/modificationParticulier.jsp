<%-- 
    Document   : modificationParticulier
    Created on : 17 mars 2020, 14:39:09
    Author     : Ilkayk
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Créer gestionnaire</title>
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
            <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
        </c:choose>


        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Modifier un particulier</h1>                   
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
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-8" style="position: relative; margin: auto;">
                                    <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                                        <div class="form-group">                                
                                            <label for="modif">Personne à modifier :</label>
                                            <SELECT class="form-control" name="modif" onchange="changeColor(this);">
                                                <OPTION value ="">A recup de la BD...</option>
                                                <OPTION value ="X">X</option>
                                                <OPTION value ="XX">XX</option>
                                            </SELECT>
                                            <label class="sr-only" for="adresse">Adresse</label>
                                            <input type="text" class="form-control" name="adresse" placeholder="Adresse" required>
                                            <label class="sr-only" for="numero">Numéro</label>
                                            <input type="tel" class="form-control" name="numero" placeholder="Numéro" required>

                                        </div>    
                                        <div class="form-group">    
                                            <label class="sr-only" for="mail">Adresse email</label>
                                            <input type="email" class="form-control" name="mail" placeholder="Adresse email" required>
                                            <label class="sr-only" for="mdp">Mot de passe</label>
                                            <input type="password" class="form-control" name="mdp" placeholder="Mot de passe" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="hidden" name="action" value="CreerGestionnaire"/>
                                            <button type="submit" class="btn btn-primary btn-block">Modifier</button>
                                        </div>
                                    </form>
                                </div>
                            </div>        
                        </div>
                    </div>
                </div>

        </section>
        <%@include file="Shared/ElementFooter.jsp" %>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen">
            <svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
        </div>
        <script>
            function changeColor(s) {
                if (s.options[s.selectedIndex].value == "") {
                    s.style.color = "#a9a9a9";
                } else {
                    s.style.color = "black";
                }
            }
        </script>
        <style>
            select option:first-child{color:grey; display: none;}
            select option {color:black;}
            input { margin-bottom: 1em;}
        </style>

        <%@include file="Shared/script_js.jsp" %>
    </body>

</html>

