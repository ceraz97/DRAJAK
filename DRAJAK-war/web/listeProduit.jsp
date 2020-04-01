<%-- 
    Document   : Liste produit 
    Created on : 26 mars 2020, 08:50:17
    Author     : djabri
--%>




<%@page import="Entity.Produit"%>
<%@page import="java.util.List"%>
<%@page import="Session.GestionSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeProduits" scope="request" class="java.util.List"></jsp:useBean>
    <title>Les Produits</title>
       
    </head>
    <body>
        
         <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
        </c:choose>
        <h1>Liste des produits</h1>
        
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

            <Table border width="50%">
                
                <tr> 
                    
                    <td>Numéro produit</td>
                    <td>Libellé produit</td>
                    <td>Type produit</td>
                    <td>Fiscalité</td>
                
                </tr>
                
                <% List<Produit>lesProd = listeProduits;
                   for(Produit cp:lesProd){%>
                   
                   <tr>
                       <td Width="15"><%=cp.getId()%></td>
                       <td Width="15"><%=cp.getLibelleProduit()%></td>
                       <td Width="15"><%=cp.getTypeProduit()%></td>
                       <td Width="15"><%=cp.getFiscalite()%></td>
                       
                   </tr><%}%>
                   
            </table><hr>
                   
<td Width="25%"> <A href="menuGestionnaire.jsp">Retour Menu</td>
<hr>

    </body>
</html>
