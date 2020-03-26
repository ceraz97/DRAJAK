<%-- 
    Document   : creationGarantie
    Created on : 26 mars 2020, 10:56:29
    Author     : A.JOURNET
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="modal-content">
            <div class="modal-body">
                
                    <div class="col-md-3">
                        <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                            <div class="form-group">                                
                                <label class="sr-only" for="Libelle">Libelle</label>
                                <input type="text" class="form-control"placeholder="Libelle" required>
                                <label class="sr-only" for="Type">Type de module</label></p>
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
