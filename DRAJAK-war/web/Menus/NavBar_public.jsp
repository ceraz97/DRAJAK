<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" onclick="location.href = 'menuDrajak?action=accueilPublic'" style="cursor: pointer"><i class="flaticon-pharmacy"></i><span>Dr</span>ajak</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a onclick="location.href = 'menuDrajak?action=accueilPublic'" style="cursor: pointer" class="nav-link">Accueil</a></li>
                        <li class="nav-item"><a href="about.jsp" class="nav-link" style="cursor: pointer">Qui sommes-nous ?</a></li>
                        <li class="nav-item"><a href="offre.jsp" class="nav-link" style="cursor: pointer">Offres</a></li>
                        <li class="nav-item"><a href="particulier.jsp" class="nav-link" style="cursor: pointer">Particulier</a></li>
                        <li class="nav-item"><a href="entreprise.jsp" class="nav-link" style="cursor: pointer">Entreprise</a></li>
                        <li class="nav-item"><a href="contact.jsp" class="nav-link" style="cursor: pointer">Contact</a></li>
                        <li class="nav-item cta"><a style="cursor: pointer" class="nav-link" data-toggle="modal" data-target="#modalAppointment"><span>Se connecter</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Modal -->
        <div class="modal fade" id="modalAppointment" tabindex="-1" role="dialog" aria-labelledby="modalAppointmentLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalAppointmentLabel">Connexion</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <ul class="nav navbar-nav">
                            <div class="row">
                                <div class="col-md-12">
                                    Vous êtes
                                    <form class="form" role="form" method="post" action="menuDrajak" accept-charset="UTF-8" id="login-nav">
                                        <div class="ensembleBooutonsRadio">
                                            <div class = "radioButtonStyle">
                                                <input class ="RadioButtonStyle" name="action" type="radio" id="AssureMenu" value="AssureAuthentification" checked="true"/>
                                                <label for="action">Particulier</label>
                                            </div>
                                            <div class="radioButtonStyle">
                                                <input class ="RadioButtonStyle" name="action" type="radio" id="EntrepriseMenu" value="EntrepriseAuthentification"/>
                                                <label for="action">Entreprise</label>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="sr-only" for="login">Adresse email</label>
                                            <input type="email" class="form-control" name="login" placeholder="Adresse email" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="mdp">Mot de passe</label>
                                            <input type="password" class="form-control" name="mdp" placeholder="Mot de passe" required>
                                            <div class="help-block text-right"><a href="">Mot de passe oublié ?</a></div>
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary btn-block" value="Valider">Connexion</button>
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Garder ma session active
                                            </label>
                                        </div>
                                    </form>
                                </div>
                                <div class="bottom text-center">
                                    Vous êtes nouveau ? <a href="#"><b>Rejoignez-nous</b></a>
                                </div>
                            </div>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
        <!-- END nav -->