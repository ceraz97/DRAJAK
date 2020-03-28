<%-- 
    Document   : entreprise
    Created on : 10 mars 2020, 14:45:50
    Author     : Ilkayk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>PFE</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
        <link href="remedic/css/login.css">
        <%@include file="Shared/link_head.jsp" %>
    </head>
    <body>

        <c:choose>
            <c:when test="${ !empty sessionScope.sessionAssure }"><%@include file="Menus/NavBar_assure.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionGestionnaire }"><%@include file="Menus/NavBar_gestionnaire.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionEntreprise }"><%@include file="Menus/NavBar_entreprise.jsp" %></c:when>
            <c:when test="${ !empty sessionScope.sessionAdministrateur }"><%@include file="Menus/NavBar_administrateur.jsp" %></c:when>
            <c:otherwise><%@include file="Menus/NavBar_public.jsp" %></c:otherwise>
        </c:choose>

        <div class="hero-wrap" style="background-image: url('remedic/images/bg_6.jpg'); background-attachment:fixed;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
                    <div class="col-md-8 ftco-animate text-center">
                        <p class="breadcrumbs"><span class="mr-2"><a href="accueil.jsp">Accueil</a></span> <span>Entreprise</span></p>
                        <h1 class="mb-3 bread">Entreprise</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Recent from blog</h2>
                    </div>
                </div>
                <div class="row d-flex">
                    <div class="col-md-6 ftco-animate">
                        <div class="blog-entry align-self-stretch d-flex">
                            <a href="blog-single.html" class="block-20 order-md-last" style="background-image: url('remedic/images/image_1.jpg');">
                            </a>
                            <div class="text p-4 d-block">
                                <div class="meta mb-3">
                                    <div><a href="#">August 12, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-3"><a href="#">New technology facilities</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 ftco-animate">
                        <div class="blog-entry align-self-stretch d-flex">
                            <a href="blog-single.html" class="block-20 order-md-last" style="background-image: url('remedic/images/image_2.jpg');">
                            </a>
                            <div class="text p-4 d-block">
                                <div class="meta mb-3">
                                    <div><a href="#">August 12, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-3"><a href="#">New technology facilities</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 ftco-animate">
                        <div class="blog-entry align-self-stretch d-flex">
                            <a href="blog-single.html" class="block-20" style="background-image: url('remedic/images/image_3.jpg');">
                            </a>
                            <div class="text p-4 d-block">
                                <div class="meta mb-3">
                                    <div><a href="#">August 12, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-3"><a href="#">New technology facilities</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 ftco-animate">
                        <div class="blog-entry align-self-stretch d-flex">
                            <a href="blog-single.html" class="block-20" style="background-image: url('remedic/images/image_4.jpg');">
                            </a>
                            <div class="text p-4 d-block">
                                <div class="meta mb-3">
                                    <div><a href="#">August 12, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-3"><a href="#">New technology facilities</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 ftco-animate">
                        <div class="blog-entry align-self-stretch d-flex">
                            <a href="blog-single.html" class="block-20 order-md-last" style="background-image: url('remedic/images/image_5.jpg');">
                            </a>
                            <div class="text p-4 d-block">
                                <div class="meta mb-3">
                                    <div><a href="#">August 12, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-3"><a href="#">New technology facilities</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 ftco-animate">
                        <div class="blog-entry align-self-stretch d-flex">
                            <a href="blog-single.html" class="block-20 order-md-last" style="background-image: url('remedic/images/image_6.jpg');">
                            </a>
                            <div class="text p-4 d-block">
                                <div class="meta mb-3">
                                    <div><a href="#">August 12, 2018</a></div>
                                    <div><a href="#">Admin</a></div>
                                    <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                                </div>
                                <h3 class="heading mt-3"><a href="#">New technology facilities</a></h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-5">
                    <div class="col text-center">
                        <div class="block-27">
                            <ul>
                                <li><a href="#">&lt;</a></li>
                                <li class="active"><span>1</span></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">&gt;</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section-parallax">
            <div class="parallax-img d-flex align-items-center">
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
                            <h2>Souscrivez à notre Newsletter</h2>
                            <div class="row d-flex justify-content-center mt-5">
                                <div class="col-md-8">
                                    <form action="#" class="subscribe-form">
                                        <div class="form-group d-flex">
                                            <input type="text" class="form-control" placeholder="Entez votre adresse email">
                                            <input type="submit" value="Souscrire" class="submit px-3">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    <footer class="ftco-footer ftco-bg-dark ftco-section img" style="background-image: url(remedic/images/bg_5.jpg);">
        <div class="overlay"></div>
        <div class="container">
            <div class="row mb-5">
                <div class="col-md">
                    <div class="ftco-footer-widget mb-4">
                        <h2 class="ftco-heading-2">Drajak</h2>
                        <p>Une mutuelle pour tous, adaptée aux besoins de chacun.</p>
                        <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                            <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                            <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                            <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md">
                    <div class="ftco-footer-widget mb-4 ml-md-5">
                        <h2 class="ftco-heading-2">Information</h2>
                        <ul class="list-unstyled">
                            <li><a href="#" class="py-2 d-block">Devis</a></li>
                            <li><a href="#" class="py-2 d-block">Contrat</a></li>
                            <li><a href="#" class="py-2 d-block">Pourquoi nous choisir</a></li>
                            <li><a href="#" class="py-2 d-block">Services</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md">
                    <div class="ftco-footer-widget mb-4">
                        <h2 class="ftco-heading-2">Navigation</h2>
                        <ul class="list-unstyled">
                            <li><a href="#" class="py-2 d-block">Accueil</a></li>
                            <li><a href="#" class="py-2 d-block">Qui sommes-nous ?</a></li>
                            <li><a href="#" class="py-2 d-block">Offres</a></li>
                            <li><a href="#" class="py-2 d-block">Particulier</a></li>
                            <li><a href="#" class="py-2 d-block">Entreprise</a></li>
                            <li><a href="#" class="py-2 d-block">Contact</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md">
                    <div class="ftco-footer-widget mb-4">
                        <h2 class="ftco-heading-2">Vous avez des questions ?</h2>
                        <div class="block-23 mb-3">
                            <ul>
                                <li><span class="icon icon-map-marker"></span><span class="text">1 avenue des Frères Lumière, 69008 Lyon, France</span></li>
                                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+3 4 99 98 97 96</span></a></li>
                                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">drajak@hardis-group.com</span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">

                    <p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>
                            document.write(new Date().getFullYear());

                        </script> Tous droits réservés | Site web Drajak <i class="icon-heart" aria-hidden="true"></i> 
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>
            </div>
        </div>
    </footer>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

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
                                    <div class="social-buttons">
                                        <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Particulier</a>
                                        <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Entreprise</a>
                                    </div>
                                    <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
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
        <%@include file="Shared/script_js.jsp" %>

    </body>
</html>