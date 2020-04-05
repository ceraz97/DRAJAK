<%-- 
    Document   : creationGarantie
    Created on : 26 mars 2020, 10:56:29
    Author     : A.JOURNET
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>

        <title>Choix des actions en attente</title>
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
            <c:otherwise><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:otherwise>
        </c:choose>
        
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
       
        
                              <div class="formulaire_devis">
                              <input type="hidden" name="action" value="VoirContratIndiv"/>
                              <p><a onclick="location.href = 'menuDrajak?action=RechercherContratIndivAttenteGestionnaireListe'" class="btn btn-primary">Contrats individuels en attente</a></p>
                              </div>
        
                              <div class="formulaire_devis">
                              <input type="hidden" name="action" value="VoirContratIndivAdhesion"/>
                              <p><a onclick="location.href = 'menuDrajak?action=RechercherContratAdhesionAttenteGestionnaireListe'" class="btn btn-primary">Contrats d'adhesions en attente</a></p>
                              </div>
        
                              <div class="formulaire_devis">
                              <input type="hidden" name="action" value="VoirFichierAttente"/>
                              <p><a onclick="location.href = 'menuDrajak?action=RechercherRIBAttenteGestionnaireListe'" class="btn btn-primary">RIB en attente</a></p>
                              </div>
        
                              <div class="formulaire_devis">
                              <input type="hidden" name="action" value="VoirFichierAttente"/>
                              <p><a onclick="location.href = 'menuDrajak?action=RechercherChargeAttenteGestionnaireListe'" class="btn btn-primary">Demande de prise en charge en attente</a></p>
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
