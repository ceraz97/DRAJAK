<%-- 
    Document   : listePersonne
    Created on : 17 mars 2020, 15:09:18
    Author     : Ilkayk
--%>
<%@page import="Entity.PersonneMorale"%>
<%@page import="Entity.Particulier"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeParticulier" scope="request" class="java.util.List"></jsp:useBean>
<jsp:useBean id="listePersMorale" scope="request" class="java.util.List"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Liste personnes</title>
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
        
        <h1>Afficher particulier</h1>
        <TABLE border width=50%>
            <tr><td>Id</td> 
                <td>Nom</td> 
                <td>Prenom</TD>
                <td>Date de naissance</td>
                <td>Numero</td>
                <td>Adresse</td>
                <td>Sexe</td>
                <td>Numéro SS</td></tr>
                <% List<Particulier> lesParticulier = listeParticulier;
                for (Particulier cp : lesParticulier) {%> 
            <tr> <td Width=15%><%=cp.getId()%></td>
                <td Width=30%><%=cp.getNom()%></td>
                <td Width=30%><%=cp.getPrenom()%></td>
                <td Width=30%><%=cp.getDateNaissance()%></td>
                <td Width=30%><%=cp.getnTelephone()%></td>
                <td Width=30%><%=cp.getAdresse()%></td>
                <td Width=30%><%=cp.getGenre()%></td>
                <td Width=30%><%=cp.getnSecuriteSocial()%></td>

            </tr><%}%>
        </table><hr>

        <h1>Afficher personne morale</h1>
        <TABLE border width=50%>
            <tr><td>Id</td> 
                <td>Raison sociale</td> 
                <td>Siret</TD>
                <td>Siren</td>
                <td>Email</td></tr>
                <% List<PersonneMorale> lesMorale = listePersMorale;
                for (PersonneMorale pm : lesMorale) {%> 
            <tr> <td Width=15%><%=pm.getId()%></td>
                <td Width=30%><%=pm.getRaisonSociale()%></td>
                <td Width=30%><%=pm.getnSiret()%></td>
                <td Width=30%><%=pm.getnSiren()%></td>
                <td Width=30%><%=pm.getEmail()%></td>

            </tr><%}%>
        </table><hr>

    <td Width=25%><a href="menuAdministrateur.jsp"> Retour Menu </a></td>
    <hr>       
    <%@include file="Shared/script_js.jsp" %>
</body>
</html>
