<%-- 
    Document   : creationParticulier
    Created on : 17 mars 2020, 14:38:32
    Author     : Ilkayk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer particulier</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>
    <body>
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-3">
                        <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                            <div class="form-group">                                
                                <label class="sr-only" for="nom">Nom</label>
                                <input type="text" class="form-control"placeholder="Nom" required>
                                <label class="sr-only" for="prenom">Prénom</label>
                                <input type="text" class="form-control" placeholder="Prénom" required>
                                <label class="sr-only" for="dateNaissance">Date de naissance</label>
                                <input type="date" class="form-control" placeholder="Date de naissance" required>
                                <label class="sr-only" for="adresse">Adresse</label>
                                <input type="text" class="form-control"placeholder="Adresse" required>
                                <label class="sr-only" for="numero">Numéro</label>
                                <input type="tel" class="form-control"placeholder="Numéro" required>
                                <p>Genre :</p>
                                <div>
                                    <input type="radio" id="homme" name="genre" value="homme" checked>
                                    <label for="homme">Homme </label>
                                    <input type="radio" id="femme" name="genre" value="femme">
                                    <label for="femme"> Femme </label>
                                    <input type="radio" id="autre" name="genre" value="autre">
                                    <label for="autre"> Autre</label>
                                </div>
                                <label for="statutPersonne">Statut personne :</label>
                                <SELECT class="form-control" name="statut" onchange="changeColor(this);">
                                    <OPTION value ="">Choisissez...</option>
                                    <OPTION value ="gestionnaire">Gestionnaire</option>
                                    <OPTION value ="administrateur">Administrateur</option>
                                </SELECT>
                                <label class="sr-only" for="numeroSS">Numéro sécurité sociale</label>
                                <input type="text" class="form-control"placeholder="NuméroSS" required>
                            </div>    
                            <div class="form-group">    
                                <label class="sr-only" for="mail">Adresse email</label>
                                <input type="email" class="form-control" placeholder="Adresse email" required>
                                <label class="sr-only" for="mdp">Mot de passe</label>
                                <input type="password" class="form-control" placeholder="Mot de passe" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Enregistrer</button>
                            </div>
                        </form>
                    </div>
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
