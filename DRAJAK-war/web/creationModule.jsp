<%-- 
    Document   : creationModule
    Created on : 27 mars 2020, 16:58:24
    Author     : djabri
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>

        <title>Créer un module</title>
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

        <div class="modal-content">
            <div class="modal-body">
                <div class="col-md-3">
                    <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                        <div class="form-group">                                
                            <label class="sr-only" for="libelle">Libelle</label>
                            <input name="libelle" type="text" class="form-control"placeholder="Libelle Module" required>

                            <p>Type Module :</p>
                            <div>
                                <input type="radio" id="Facultatif" name="typeModule" value="Facultatif" checked>
                                <label for="Facultatif">Facultatif </label>
                                <input type="radio" id="Base" name="typeModule" value="Base">
                                <label for="Base"> Base </label>
                            </div>
                        </div>    


                        <div class="formulaire_devis">
                            <c:forEach items="${requestScope.listeGarantie}" var="elementGarantie">
                                <div>
                                    <input type="checkbox" id="listeGarantie" name="checkbox" value="${elementGarantie.getId()}"/>
                                    <label for="checkbox"><c:out value="${elementGarantie.getLibelleGarantie()}"/></label>
                                </div>
                            </c:forEach>
                            <input type="hidden" name="action" value="CreerModule"/>
                            <button type="submit" class="btn btn-primary btn-co">Créer Module</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>    
        <%@include file="Shared/script_js.jsp" %>
        <script>
            function changeColor(s) {
                if (s.options[s.selectedIndex].value === "") {
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
        <style>
            select option:first-child{color:grey; display: none;}
            select option {color:black;}
            table{width: 100%;}
            table>tr{ margin-bottom: 20px;}
            th {color:#167ce9}
            table td {height: 4em; vertical-align: middle;}
            #td1,td2{width: 25%;}
        </style>
    </body>
</html>
