<%-- 
    Document   : accueil
    Created on : 10 mars 2020, 13:31:22
    Author     : Ilkayk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="accueil.jsp"><i class="flaticon-pharmacy"></i><span>Dr</span>ajak</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="accueil.jsp" class="nav-link">Accueil</a></li>
                        <li class="nav-item"><a href="about.jsp" class="nav-link">Qui sommes-nous ?</a></li>
                        <li class="nav-item"><a href="offre.jsp" class="nav-link">Offres</a></li>
                        <li class="nav-item"><a href="particulier.jsp" class="nav-link">Particulier</a></li>
                        <li class="nav-item"><a href="entreprise.jsp" class="nav-link">Entreprise</a></li>
                        <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
                        <li class="nav-item cta"><a href="accueil.jsp" class="nav-link" data-toggle="modal" data-target="#modalAppointment"><span>Se connecter</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END nav -->

        <div class="hero-wrap" style="background-image: url('remedic/images/bg_1.jpg'); background-attachment:fixed;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
                    <div class="col-md-8 ftco-animate text-center">
                        <h1 class="mb-4">Bienvenue</h1>
                        <p>Une mutuelle pour tous, adaptée aux besoins de chacun.</p>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-services">
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-md-4 ftco-animate py-5 nav-link-wrap">
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <a class="nav-link px-4 active" id="v-pills-master-tab" data-toggle="pill" href="#v-pills-master" role="tab" aria-controls="v-pills-master" aria-selected="true"><span class="mr-3 flaticon-cardiogram"></span> Cardiology</a>

                            <a class="nav-link px-4" id="v-pills-buffet-tab" data-toggle="pill" href="#v-pills-buffet" role="tab" aria-controls="v-pills-buffet" aria-selected="false"><span class="mr-3 flaticon-neurology"></span> Neurology</a>

                            <a class="nav-link px-4" id="v-pills-fitness-tab" data-toggle="pill" href="#v-pills-fitness" role="tab" aria-controls="v-pills-fitness" aria-selected="false"><span class="mr-3 flaticon-stethoscope"></span> Diagnostic</a>

                            <a class="nav-link px-4" id="v-pills-reception-tab" data-toggle="pill" href="#v-pills-reception" role="tab" aria-controls="v-pills-reception" aria-selected="false"><span class="mr-3 flaticon-tooth"></span> Dental</a>

                            <a class="nav-link px-4" id="v-pills-sea-tab" data-toggle="pill" href="#v-pills-sea" role="tab" aria-controls="v-pills-sea" aria-selected="false"><span class="mr-3 flaticon-vision"></span> Ophthalmology</a>

                            <a class="nav-link px-4" id="v-pills-spa-tab" data-toggle="pill" href="#v-pills-spa" role="tab" aria-controls="v-pills-spa" aria-selected="false"><span class="mr-3 flaticon-ambulance"></span> Emergency</a>
                        </div>
                    </div>
                    <div class="col-md-8 ftco-animate p-4 p-md-5 d-flex align-items-center">

                        <div class="tab-content pl-md-5" id="v-pills-tabContent">

                            <div class="tab-pane fade show active py-5" id="v-pills-master" role="tabpanel" aria-labelledby="v-pills-master-tab">
                                <span class="icon mb-3 d-block flaticon-cardiogram"></span>
                                <h2 class="mb-4">Cardiology Department</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
                                <p>Inventore fugit error iure nisi reiciendis fugiat illo pariatur quam sequi quod iusto facilis officiis nobis sit quis molestias asperiores rem, blanditiis! Commodi exercitationem vitae deserunt qui nihil ea, tempore et quam natus quaerat doloremque.</p>
                                <p><a href="#" class="btn btn-primary">Learn More</a></p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-buffet" role="tabpanel" aria-labelledby="v-pills-buffet-tab">
                                <span class="icon mb-3 d-block flaticon-neurology"></span>
                                <h2 class="mb-4">Neurogoly Department</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
                                <p>Inventore fugit error iure nisi reiciendis fugiat illo pariatur quam sequi quod iusto facilis officiis nobis sit quis molestias asperiores rem, blanditiis! Commodi exercitationem vitae deserunt qui nihil ea, tempore et quam natus quaerat doloremque.</p>
                                <p><a href="#" class="btn btn-primary">Learn More</a></p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-fitness" role="tabpanel" aria-labelledby="v-pills-fitness-tab">
                                <span class="icon mb-3 d-block flaticon-stethoscope"></span>
                                <h2 class="mb-4">Diagnostic Department</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
                                <p>Inventore fugit error iure nisi reiciendis fugiat illo pariatur quam sequi quod iusto facilis officiis nobis sit quis molestias asperiores rem, blanditiis! Commodi exercitationem vitae deserunt qui nihil ea, tempore et quam natus quaerat doloremque.</p>
                                <p><a href="#" class="btn btn-primary">Learn More</a></p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-reception" role="tabpanel" aria-labelledby="v-pills-reception-tab">
                                <span class="icon mb-3 d-block flaticon-tooth"></span>
                                <h2 class="mb-4">Dental Departments</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
                                <p>Inventore fugit error iure nisi reiciendis fugiat illo pariatur quam sequi quod iusto facilis officiis nobis sit quis molestias asperiores rem, blanditiis! Commodi exercitationem vitae deserunt qui nihil ea, tempore et quam natus quaerat doloremque.</p>
                                <p><a href="#" class="btn btn-primary">Learn More</a></p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-sea" role="tabpanel" aria-labelledby="v-pills-sea-tab">
                                <span class="icon mb-3 d-block flaticon-vision"></span>
                                <h2 class="mb-4">Ophthalmology Departments</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
                                <p>Inventore fugit error iure nisi reiciendis fugiat illo pariatur quam sequi quod iusto facilis officiis nobis sit quis molestias asperiores rem, blanditiis! Commodi exercitationem vitae deserunt qui nihil ea, tempore et quam natus quaerat doloremque.</p>
                                <p><a href="#" class="btn btn-primary">Learn More</a></p>
                            </div>

                            <div class="tab-pane fade py-5" id="v-pills-spa" role="tabpanel" aria-labelledby="v-pills-spa-tab">
                                <span class="icon mb-3 d-block flaticon-ambulance"></span>
                                <h2 class="mb-4">Emergency Departments</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt voluptate, quibusdam sunt iste dolores consequatur</p>
                                <p>Inventore fugit error iure nisi reiciendis fugiat illo pariatur quam sequi quod iusto facilis officiis nobis sit quis molestias asperiores rem, blanditiis! Commodi exercitationem vitae deserunt qui nihil ea, tempore et quam natus quaerat doloremque.</p>
                                <p><a href="#" class="btn btn-primary">Learn More</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section-2 img" style="background-image: url(remedic/images/bg_3.jpg);">
            <div class="container">
                <div class="row d-md-flex justify-content-end">
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12">
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>Laboratory Services</h2>
                                    <p>Even the all-powerful Pointing has no control about the blind.</p>
                                </a>
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>General Treatment</h2>
                                    <p>Even the all-powerful Pointing has no control about the blind.</p>
                                </a>
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>Emergency Service</h2>
                                    <p>Even the all-powerful Pointing has no control about the blind.</p>
                                </a>
                                <a href="#" class="services-wrap ftco-animate">
                                    <div class="icon d-flex justify-content-center align-items-center">
                                        <span class="ion-ios-arrow-back"></span>
                                        <span class="ion-ios-arrow-forward"></span>
                                    </div>
                                    <h2>24/7 Help &amp; Support</h2>
                                    <p>Even the all-powerful Pointing has no control about the blind.</p>
                                </a>
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
                </div>
                <div class="row">
                    <div class="col-md-9 ftco-animate">
                        <h4>We are well experienced doctors</h4>
                        <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url(remedic/images/bg_4.jpg);">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
                        <h2 class="mb-4">Some fun facts</h2>
                        <span class="subheading">Far far away, behind the word mountains, far from the countries</span>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-10">
                        <div class="row">
                            <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <strong class="number" data-number="60">0</strong>
                                        <span>Hospital</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <strong class="number" data-number="200">0</strong>
                                        <span>Doctors</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <strong class="number" data-number="100">0</strong>
                                        <span>Clinics</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                <div class="block-18 text-center">
                                    <div class="text">
                                        <strong class="number" data-number="200">0</strong>
                                        <span>Reviews</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section testimony-section">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Testimonials</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 ftco-animate">
                        <div class="carousel-testimony owl-carousel">
                            <div class="item">
                                <div class="testimony-wrap text-center">
                                    <div class="user-img mb-5" style="background-image: url(remedic/images/person_1.jpg)">
                                        <span class="quote d-flex align-items-center justify-content-center">
                                            <i class="icon-quote-left"></i>
                                        </span>
                                    </div>
                                    <div class="text">
                                        <p class="mb-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                                        <p class="name">Dennis Green</p>
                                        <span class="position">Patient</span>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="testimony-wrap text-center">
                                    <div class="user-img mb-5" style="background-image: url(remedic/images/person_2.jpg)">
                                        <span class="quote d-flex align-items-center justify-content-center">
                                            <i class="icon-quote-left"></i>
                                        </span>
                                    </div>
                                    <div class="text">
                                        <p class="mb-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                                        <p class="name">Dennis Green</p>
                                        <span class="position">Patient</span>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="testimony-wrap text-center">
                                    <div class="user-img mb-5" style="background-image: url(remedic/images/person_3.jpg)">
                                        <span class="quote d-flex align-items-center justify-content-center">
                                            <i class="icon-quote-left"></i>
                                        </span>
                                    </div>
                                    <div class="text">
                                        <p class="mb-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                                        <p class="name">Dennis Green</p>
                                        <span class="position">Patient</span>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="testimony-wrap text-center">
                                    <div class="user-img mb-5" style="background-image: url(remedic/images/person_3.jpg)">
                                        <span class="quote d-flex align-items-center justify-content-center">
                                            <i class="icon-quote-left"></i>
                                        </span>
                                    </div>
                                    <div class="text">
                                        <p class="mb-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                                        <p class="name">Dennis Green</p>
                                        <span class="position">Doctor</span>
                                    </div>
                                </div>
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
                </div>
            </div>
        </section>

        <%@include file="Shared/ElementFooter.jsp" %>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg></div>

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