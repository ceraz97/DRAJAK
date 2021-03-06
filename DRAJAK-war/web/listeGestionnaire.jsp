<%-- 
    Document   : listeGestionnaire
    Created on : 16 mars 2020, 11:47:06
    Author     : Ilkayk
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.CompteEmploye"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="listeGestionnaire" scope="request" class="java.util.List"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste gestionnaire</title>
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
            <c:otherwise><%@include file="Menus/NavBar_administrateur.jsp" %></c:otherwise>
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
        </p>
        
        <h1>Afficher gestionnaires</h1>
        <TABLE border width=50%>
            <tr><td>Id</td> 
                <td>Nom</td> 
                <td>Prenom</TD>
                <td>Date de naissance</td>
                <td>Numero</td>
                <td>Role</td></tr>
                <% List<CompteEmploye> lesCompte = listeGestionnaire;
                    for (CompteEmploye cp : lesCompte) {%> 
            <tr> <td Width=15%><%=cp.getId()%></td>
                <td Width=30%><%=cp.getNom()%></td>
                <td Width=30%><%=cp.getPrenom()%></td>
                <td Width=30%><%=cp.getDateNaissance()%></td>
                <td Width=30%><%=cp.getnTelephone()%></td>
                <td Width=30%><%=cp.getRoleEmploye()%></td>

            </tr><%}%>
        </table><hr>
    <td Width=25%><a href="menuAdministrateur.jsp"> Retour Menu </a></td>
    <hr>       
    <%@include file="Shared/script_js.jsp" %>
</body>
</html>
