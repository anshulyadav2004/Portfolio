<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/png">
    <title>Anshul's Portfolio</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/linericon/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/nice-select/css/nice-select.css">
    <!-- main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

 <!-- Start Header Area -->
<%@include file="header.jsp" %>
<!--================ End Header Area =================-->

<!--================ Start Home Banner Area =================-->
<section class="home_banner_area">
    <div class="banner_inner">
        <div class="container">
            <div class="row">
                <div class="col-lg-7">
                    <div class="banner_content">
                        <h3 class="text-uppercase">Hell0</h3>
                        <h1 class="text-uppercase">I am Anshul Yadav</h1>
                        <h5 class="text-uppercase">JAVA BACKEND DEVELOPER</h5>
                        <div class="d-flex align-items-center">
                            <a class="primary_btn" href="${pageContext.request.contextPath}/client/contact"><span>Hire Me</span></a>
                            <a class="primary_btn tr-bg" href="${pageContext.request.contextPath}/client/downloadResume" target="_blank"><span>Get CV</span></a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="home_right_img">
                        <img class="" src="${pageContext.request.contextPath}/img/banner/home-right.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================ End Home Banner Area =================-->

<!--================ Start About Us Area =================-->
<section class="about_area section_gap">
    <div class="container">
        <div class="row justify-content-start align-items-center">
            <div class="col-lg-5">
                <div class="about_img">
                    <img class="" src="${pageContext.request.contextPath}/img/about-us.png" alt="">
                </div>
            </div>

            <div class="offset-lg-1 col-lg-5">
                <div class="main_title text-left">
                    <h2>let’s <br>
                        Introduce about <br>
                        myself</h2>
                    <p>
                        Hello! I'm Anshul.
                        I’m a Computer Science graduate and Full-Stack Developer
                        with a deep focus on <strong class="highlight"> Java Ecosystems & Enterprise Backend Web Applications.</strong>
                    </p>
                    <p>
                        I specialize in crafting clean, scalable backend systems using <strong class="highlight"> Java, Spring Boot, Spring Data JPA, Hibernate, and Servlets, paired with modern relational databases like MySQL </strong>. From designing MVC architectures to optimizing database queries, I enjoy turning complex business requirements into seamless, production-ready software.

                        Whether it’s architecting an e-commerce backend, managing real-time data flows, or writing clean OOP code, I’m always focused on performance, security, and developer best practices.
                    </p>
                    <a class="primary_btn" href="${pageContext.request.contextPath}/client/downloadResume" target="_blank"><span>Download CV</span></a>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================ End About Us Area =================-->

<!--================ Srart Brand Area =================-->

 <%@include file="Brand.jsp" %>

<!--================ End Brand Area =================-->

<!--================ Start Features Area =================-->
 <!--================ Start Projects Area =================-->
 <div class="container pt-5">
     <div class="row justify-content-center">
         <div class="col-lg-8 text-center">
             <div class="main_title mb-0">
                 <h2>PROJECTS</h2>
             </div>
         </div>
     </div>
 </div>

 <%@include file="Project.jsp" %>
 <!--================ End Projects Area =================-->
 <!--================ End Features Area =================-->




<!--================ End Testimonial Area =================-->

<!--================Footer Area =================-->
<%@include file="footer.jsp" %>

<!--================End Footer Area =================-->

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/stellar.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/nice-select/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/isotope/imagesloaded.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/isotope/isotope-min.js"></script>
<script src="${pageContext.request.contextPath}/vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mail-script.js"></script>
<!--gmaps Js-->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
<script src="${pageContext.request.contextPath}/js/gmaps.min.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
</body>

</html>