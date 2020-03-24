<%-- 
    Document   : accueilEmploye
    Created on : 12 mars 2020, 16:02:02
    Author     : Ilkayk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employé</title>        
        <link href="remedic/css/login.css">
    </head>
    <body>
        <h1>Authentification employé</h1>
        <div class="modal fade" id="modalAppointment" tabindex="-1" role="dialog" aria-labelledby="modalAppointmentLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <ul class="nav navbar-nav">
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                         <div class="ensembleBooutonsRadio">
                                            <div class = "radioButtonStyle">
                                                <input class ="RadioButtonStyle" name="action" type="radio" id="GestionnaireMenu" value="GestionnaireAuthentification" checked="true"/>
                                                <label for="action">Gestionnaire</label>
                                            </div>
                                            <div class="radioButtonStyle">
                                                <input class ="RadioButtonStyle" name="action" type="radio" id="AdministrateurMenu" value="AdministrateurAuthentification"/>
                                                <label for="action">Administrateur</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputEmail2">Adresse email</label>
                                            <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Adresse email" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputPassword2">Mot de passe</label>
                                            <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Mot de passe" required>
                                            <div class="help-block text-right"><a href="">Mot de passe oublié ?</a></div>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-block">Connexion</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>      
        <%@include file="Shared/script_js.jsp" %>
    </body>
    <style>
        body{
            background-color: #84CAF1
        }
    </style>
</html>
