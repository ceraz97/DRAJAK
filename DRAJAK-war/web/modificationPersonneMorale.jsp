<%-- 
    Document   : modificationPersonneMorale
    Created on : 17 mars 2020, 15:00:55
    Author     : Ilkayk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier personne Morale</title>
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
                                <label class="sr-only" for="raisonSociale">Raison sociale</label>
                                <input type="text" class="form-control"placeholder="Raison sociale" required>
                                <label class="sr-only" for="siret">Siret</label>
                                <input type="number" class="form-control" placeholder="Siret" required>
                                <label class="sr-only" for="siren">Siren</label>
                                <input type="number" class="form-control" placeholder="Siren" required>
                                <label class="sr-only" for="adresse">Adresse</label>
                                <input type="text" class="form-control"placeholder="Adresse" required>
                            </div>    
                            <div class="form-group">    
                                <label class="sr-only" for="mail">Adresse email</label>
                                <input type="email" class="form-control" placeholder="Adresse email" required>
                                <label class="sr-only" for="mdp">Mot de passe</label>
                                <input type="password" class="form-control" placeholder="Mot de passe" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Modifier</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>          
        </div>
        <%@include file="Shared/script_js.jsp" %>
    </body>
</html>
