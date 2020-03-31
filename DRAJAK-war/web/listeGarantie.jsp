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
        <title>Vos Contrats</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>

    <body>
        <script type="text/javascript">
            function getCreerGarantie(LibelleGarantie,CleTypeRemboursement)  {
                var result = confirm("Voulez vous quitter la page ?");
                if(result)  {
                    location.href = "menuDrajak?action=Redirection_CreationGarantie";
                } 
            }
            
      </script>    

        <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:otherwise>
        </c:choose>


        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed; height: 200px;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true" style="height: 200px;">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Selectionner des garanties</h1>                   
                    </div>
                </div>
            </div>
        </div>

           <script type="text/javascript">
            function getConfirmCreationModule(libelleModule,libelleTypeModule)  {
                var result = confirm("Voulez vous enregistrer le module "+libelleModule+"?");
                if(result)  {
                    location.href = "menuDrajak?action=CreerModule&idc=";
                } 
            }
      </script>  
      
      <%  
            String attribut=(String)request.getAttribute("message");
            boolean b = attribut.toLowerCase().contains("erreur");
            if (b==true){%>
                <span class="message_erreur">
                    <%out.println(attribut);%>
                </span>
            <% } else {%>
                <span class="message_normal">
                    <%out.println(attribut);%>
                </span>
            <% }
        %>

        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="formulaire_devis">
                                 
                        <table>
                            <!-- here should go some titles... -->
                            <tr style="border-bottom: 1px solid #167ce9;">
                                <th>libelle</th>
                                <th>Type remboursement</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${requestScope.listeGarantie}" var="document">
                              <c:forEach items="${requestScope.listeObjetGarantie}" var="doc">
                                <tr>
                                    <td id="td1">
                                        <c:out value="${document.getLibelleGarantie()}" />
                                    </td>
                                     <td id="td2">
                                        <c:out value="${doc.getLibelleTypeRemboursement()}" /> 
                                    </td>
                                    </tr>
                               </c:forEach>
                            </c:forEach>
                        </table>
                    </div>  
                              <button onclick="getConfirmResiliation('${document.getLibelleGarantie()}', '${doc.getLibelleTypeRemboursement()}');">Valider le Module</button>
                </div>
                              <a onclick="location.href='menuDrajak?action=Redirection_CreationGarantie'" class="btn btn-primary btn-ajoute">Créer une garantie</a>
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
