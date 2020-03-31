 <%-- 
    Document   : creationProduit
    Created on : 25 mars 2020, 16:30:39
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

        <title>Créer produit</title>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>
    <body>
         <script type="text/javascript">
            function getAjouterModule(id)  {
              var result = confirm("Voulez vous ajouter de nouveau module ? Une réponse négative entrainera la création du produit ");
                listemodule.push(id); 
                if(result)  {
                   
               } 
                else
                {
                return listemodule;
                
               //location.href = "menuDrajak?action=CreerProduit&idc="+listemodule;
             
                //} 
            
      </script>    
        
        <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
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
        
        <div class="modal-content">
            <div class="modal-body">
                
                    <div class="col-md-3">
                        <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                            <div class="form-group">                                
                                <label class="sr-only" for="libelle">Libelle</label>
                                <input name="libelle" type="text" class="form-control"placeholder="Libelle" required>
                                <label class="sr-only" for="fiscalite">Fiscalite</label></p>
                                <input name="fiscalite" type="text" class="form-control"placeholder="fiscalite" required>
                                <p>Type produit :</p>
                                <div>
                                    <input type="radio" id="individuel" name="typeproduit" value="individuel" checked>
                                    <label for="individuel">individuel </label>
                                    <input type="radio" id="collectif" name="typeproduit" value="collectif">
                                    <label for="collectif"> collectif </label>
                                </div>
                                <p>Domaine produit :</p>
                                  <div>
                                    <input type="radio" id="sante" name="libelledomaineproduit" value="sante" checked>
                                    <label for="sante">sante</label>
                                  </div>
                            </div>    
                             
                          
                                   <div class="formulaire_devis">
                       
                        <c:forEach items="${requestScope.listeModules}" var="elementModules">
                         <div>
                        <input type="checkbox" id="listemodule" name="checkbox" value="${elementModules.getId()}"/>
                             <label for="checkbox"><c:out value="${elementModules.getLibelleModule()}"/></label>
                        </div>
                         </c:forEach>
                                           

                            <input type="hidden" name="action" value="CreerProduit"/>
                            <button type="submit" class="btn btn-primary btn-co">Créer produit</button>
                        
                    </div>
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
             
        table{width: 100%;}
        table>tr{ margin-bottom: 20px;}
        th {color:#167ce9}
        table td {height: 4em; vertical-align: middle;}
        #td1,td2{width: 25%;}
  
    
        </style>
        
    </body>
</html>
 
