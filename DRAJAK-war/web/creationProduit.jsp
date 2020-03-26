<%-- 
    Document   : creationProduit
    Created on : 25 mars 2020, 16:30:39
    Author     : A.JOURNET
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>

        <title>Créer produit</title>
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
        
        <div class="modal-content">
            <div class="modal-body">
                
                    <div class="col-md-3">
                        <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                            <div class="form-group">                                
                                <label class="sr-only" for="Libelle">Libelle</label>
                                <input type="text" class="form-control"placeholder="Libelle" required>
                                <label class="sr-only" for="Fiscalite">Fiscalite</label></p>
                                <input type="text" class="form-control"placeholder="fiscalite" required>
                                <p>Type produit :</p>
                                <div>
                                    <input type="radio" id="homme" name="type produit" value="individuel" checked>
                                    <label for="individuel">individuel </label>
                                    <input type="radio" id="femme" name="genre" value="femme">
                                    <label for="collectif"> collectif </label>
                                </div>
                            </div>    
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Enregistrer</button>
                            </div>
                            
                            
                            <a href="listeModule.jsp" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>Affecter des modules au produit</h2>
                                    <p></p>
                            
                        </form>
                    
                </div>
            </div>          
        </div>
         <%@include file="Shared/script_js.jsp" %>
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
        </style>
        
    </body>
</html>

test commit