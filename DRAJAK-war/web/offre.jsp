<%-- 
    Document   : offre
    Created on : 10 mars 2020, 14:17:51
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
                        <p class="breadcrumbs"><span class="mr-2"><a href="accueil.jsp">Accueil</a></span> <span>Offres</span></p>
                        <h1 class="mb-3 bread">Offres</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-section">
            <div class="container">
                <div class="row d-flex">
                    <div class="col-lg-6 d-flex ftco-animate">
                        <div class="dept d-md-flex">
                            <a href="department-single.html" class="img" style="background-image: url(remedic/images/dept-1.jpg);"></a>
                            <div class="text p-4">
                                <h3><a href="department-single.html">Dental Department</a></h3>
                                <p><span class="loc">203 Fake St. California, USA</span></p>
                                <p><span class="doc">22 Doctors</span></p>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                <ul>
                                    <li><span class="ion-ios-checkmark"></span>Emergency</li>
                                    <li><span class="ion-ios-checkmark"></span>Laboratory</li>
                                    <li><span class="ion-ios-checkmark"></span>Dental</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 d-flex ftco-animate">
                        <div class="dept d-md-flex">
                            <a href="department-single.html" class="img" style="background-image: url(remedic/images/dept-2.jpg);"></a>
                            <div class="text p-4">
                                <h3><a href="department-single.html">Surgical Department</a></h3>
                                <p><span class="loc">203 Fake St. California, USA</span></p>
                                <p><span class="doc">22 Doctors</span></p>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                <ul>
                                    <li><span class="ion-ios-checkmark"></span>Emergency</li>
                                    <li><span class="ion-ios-checkmark"></span>Laboratory</li>
                                    <li><span class="ion-ios-checkmark"></span>Dental</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 d-flex ftco-animate">
                        <div class="dept d-md-flex">
                            <a href="department-single.html" class="img" style="background-image: url(remedic/images/dept-3.jpg);"></a>
                            <div class="text p-4">
                                <h3><a href="department-single.html">Neurological Department</a></h3>
                                <p><span class="loc">203 Fake St. California, USA</span></p>
                                <p><span class="doc">22 Doctors</span></p>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                <ul>
                                    <li><span class="ion-ios-checkmark"></span>Emergency</li>
                                    <li><span class="ion-ios-checkmark"></span>Laboratory</li>
                                    <li><span class="ion-ios-checkmark"></span>Dental</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 d-flex ftco-animate">
                        <div class="dept d-md-flex">
                            <a href="department-single.html" class="img" style="background-image: url(remedic/images/dept-4.jpg);"></a>
                            <div class="text p-4">
                                <h3><a href="department-single.html">Ophthalmological Department</a></h3>
                                <p><span class="loc">203 Fake St. California, USA</span></p>
                                <p><span class="doc">22 Doctors</span></p>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                                <ul>
                                    <li><span class="ion-ios-checkmark"></span>Emergency</li>
                                    <li><span class="ion-ios-checkmark"></span>Laboratory</li>
                                    <li><span class="ion-ios-checkmark"></span>Dental</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section bg-light">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Laboratory Test</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 ftco-animate">
                        <div id="accordion">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"  href="#menuone" aria-expanded="true" aria-controls="menuone">Tummy Tuck <small>$99.00</small><span class="collapsed"><i class="icon-plus-circle"></i></span><span class="expanded"><i class="icon-minus-circle"></i></span></a>
                                        </div>
                                        <div id="menuone" class="collapse show">
                                            <div class="card-body">
                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"  href="#menutwo" aria-expanded="false" aria-controls="menutwo">Liposuction <small>$99.00</small> <span class="collapsed"><i class="icon-plus-circle"></i></span><span class="expanded"><i class="icon-minus-circle"></i></span></a>
                                        </div>
                                        <div id="menutwo" class="collapse">
                                            <div class="card-body">
                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"  href="#menu3" aria-expanded="false" aria-controls="menu3">Cosmetic Surgery <small>$99.00</small> <span class="collapsed"><i class="icon-plus-circle"></i></span><span class="expanded"><i class="icon-minus-circle"></i></span></a>
                                        </div>
                                        <div id="menu3" class="collapse">
                                            <div class="card-body">
                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"  href="#menu4" aria-expanded="false" aria-controls="menu4">Facial Reconstruciton <small>$99.00</small> <span class="collapsed"><i class="icon-plus-circle"></i></span><span class="expanded"><i class="icon-minus-circle"></i></span></a>
                                        </div>
                                        <div id="menu4" class="collapse">
                                            <div class="card-body">
                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"  href="#menu5" aria-expanded="false" aria-controls="menu5">Breast implants <small>$99.00</small><span class="collapsed"><i class="icon-plus-circle"></i></span><span class="expanded"><i class="icon-minus-circle"></i></span></a>
                                        </div>
                                        <div id="menu5" class="collapse">
                                            <div class="card-body">
                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse"  href="#menu6" aria-expanded="false" aria-controls="menu6">Ear Pinning <small>$99.00</small><span class="collapsed"><i class="icon-plus-circle"></i></span><span class="expanded"><i class="icon-minus-circle"></i></span></a>
                                        </div>
                                        <div id="menu6" class="collapse">
                                            <div class="card-body">
                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Our Experienced Doctors</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-1.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Neurologist</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-1.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Neurologist</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-2.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Pediatrician</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-2.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Pediatrician</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-3.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Ophthalmologist</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-3.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Ophthalmologist</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-4.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Pulmonologist</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-4.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Pulmonologist</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
                    </div>

                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-1.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Neurologist</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-1.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Neurologist</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-2.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Pediatrician</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-2.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Pediatrician</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-3.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Ophthalmologist</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-3.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Ophthalmologist</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
                    </div>
                    <div class="col-md-6 col-lg-3 ftco-animate">
                        <div class="block-2">
                            <div class="flipper">
                                <div class="front" style="background-image: url(remedic/images/doctor-4.jpg);">
                                    <div class="box">
                                        <h2>Aldin Powell</h2>
                                        <p>Pulmonologist</p>
                                    </div>
                                </div>
                                <div class="back">
                                    <!-- back content -->
                                    <blockquote>
                                        <p>&ldquo;Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem&rdquo;</p>
                                    </blockquote>
                                    <div class="author d-flex">
                                        <div class="image mr-3 align-self-center">
                                            <div class="img" style="background-image: url(remedic/images/doctor-4.jpg);"></div>
                                        </div>
                                        <div class="name align-self-center">Aldin Powell <span class="position">Pulmonologist</span></div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- .flip-container -->
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


        <%@include file="Shared/script_js.jsp" %>
    </body>
</html>
