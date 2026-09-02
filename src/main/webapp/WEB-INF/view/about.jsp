<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/png">
    <title>About Us</title>
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

<!--================ Start Header Area =================-->
<%@include file="header.jsp" %>
<!--================ End Header Area =================-->

<!--================ Start Banner Area =================-->
<section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
        <div class="container">
            <div class="banner_content text-center">
                <h2>About Us</h2>
                <div class="page_link">
                    <a href="${pageContext.request.contextPath}/client/home">Home</a>

                </div>
            </div>
        </div>
    </div>
</section>
<!--================ End Banner Area =================-->

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
                        <br>
                        I’m a Computer Science graduate From DR.APJ ABDUL KALAM TECHNICAL UNIVERSITY LUCKNOW.
                        and I am an JAVA Full Stack Developer. You can check My Project on clicking on above links.


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

<!--================ Start Testimonial Area =================-->
<div class="testimonial_area section_gap_bottom">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8 text-center">
                <div class="main_title">
                    <h2>Planning to Learn</h2>

                </div>
            </div>
        </div>
        <div class="row">
            <div class="testi_slider owl-carousel">
                <div class="testi_item">
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="testi_text">
                                <h4>CyberSecurity</h4>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="testi_item">
                    <div class="row">

                        <div class="col-lg-8">
                            <div class="testi_text">
                                <h4>App Development</h4>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="testi_item">
                    <div class="row">

                        <div class="col-lg-8">
                            <div class="testi_text">
                                <h4>Machine Learning</h4>
                                <p>   </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="testi_item">
                    <div class="row">
                        <div class="col-lg-4">

                        </div>
                        <div class="col-lg-8">
                            <div class="testi_text">
                                <h4>AI</h4>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
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