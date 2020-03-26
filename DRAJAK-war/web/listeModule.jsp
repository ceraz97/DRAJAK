<%-- 
    Document   : listeModule
    Created on : 26 mars 2020, 11:31:16
    Author     : A.JOURNET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Liste des modules</title>
          <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>
    <body>
        <script type="text/javascript">
            function getAjouterModule(libelleModule,idModule)  {
                List<Module> lesModules = listeModule;
o                    Module.add(idModule);
                    onclick="location.href"='menuDrajak?action=...'
                 
            }
            
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
                        <h1 class="mb-4">Sélectionner les modules</h1>                   
                    </div>
                    <div class="form-group">
                                
                            </div>

                </div>
            </div>
        </div>

        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="formulaire_devis">
             
                        <table>
                            <!-- here should go some titles... -->
                           
                            <tr style="border-bottom: 1px solid #167ce9;">
                                <th>Module</th>
                               
                                <th></th>
                            </tr>
                            <c:forEach items="${requestScope.listeModules}" var="document">
                                 
                                <tr>
                                    <td id="td1">
                                        <c:out value="${document.getLibelleModule()}" />
                                    </td>
                                    <td>
                                        <button onclick="getAjouterModule('${document.getLibelleModule()}', '${document.getId()}');">Ajouter</button>
                                        </td>
                                    </tr>
                           
                            </c:forEach>
                        </table>
                    </div>
                </div>
          
                 <button type="submit" class="btn btn-primary btn-block">Enregistrer</button>
                               
                 <button type="submit" class="btn btn-primary btn-block">Créer un module</button>
                                         

        </section>
        <%@include file="Shared/ElementFooter.jsp"%>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg></div>


        <%@include file="Shared/script_js.jsp"%>
    </body>

    <style>
        table{width: 100%;}
        table>tr{ margin-bottom: 20px;}
        th {color:#167ce9}
        table td {height: 4em; vertical-align: middle;}
        #td1,td2{width: 25%;}
    </style>
    
    
    </html>
 test commit