<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a style="cursor: pointer" class="navbar-brand" href="accueil.jsp"><i class="flaticon-pharmacy"></i><span>Dr</span>ajak</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a style="cursor: pointer" onclick="location.href = 'menuDrajak?action=EntrepriseMenu'" class="nav-link">Accueil</a></li>
                <li class="nav-item"><a style="cursor: pointer" href="about.jsp" class="nav-link">Simulation</a></li>
                <li class="nav-item"><a style="cursor: pointer" onclick="location.href = 'menuDrajak?action=Morale_GestionContrat_ListeContrat'" class="nav-link">Mes contrats</a></li>
                <li class="nav-item"><a style="cursor: pointer" href="particulier.jsp" class="nav-link">Mes infos</a></li>
                <li class="nav-item"><a style="cursor: pointer" href="contact.jsp" class="nav-link">Contact</a></li>
                <li class="nav-item cta"><a style="cursor: pointer" onclick="location.href = 'menuDrajak?action=Deconnexion&typeConnexion=EntrepriseMenu'" class="nav-link"><span>Se déconnecter</span></a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->