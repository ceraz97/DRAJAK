<%-- 
    Document   : creationProduit
    Created on : 25 mars 2020, 16:30:39
    Author     : A.JOURNET
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Modules"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeDesModules" scope="request" class="java.util.List"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer produit</title>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>
    <body>
        <div class="modal-content">
            <div class="modal-body">
                
                    
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
                                			
                                   <table border width="50%">
<tr>
    <td>ID</td>
    <td>Libelle</td>
    
</tr>
  <% List<Modules> lesModules = listeDesModules;
                    for (Modules cp : lesModules) {%> 
<tr onclick="document.getElementById('id_input').value = '1';">
<tr> <td> <%cp.getLibelleModule();%> </td>

 
                                   </table> <hr>
 
<form action="" method="post">
    <input type="text" name="id_input" id="id_input" />
</form>
                                
                            </div>    
                            
                   
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Enregistrer</button>
                            </div>
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
