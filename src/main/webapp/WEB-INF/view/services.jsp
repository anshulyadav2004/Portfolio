<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/png">
    <title>Services</title>
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
                <h2>Projects</h2>
                <div class="page_link">
                    <a href="${pageContext.request.contextPath}/client/home">Home</a>

                </div>
            </div>
        </div>
    </div>
</section>
<!--================ End Banner Area =================-->

<!--================ Start Features Area =================-->
<%@include file="Project.jsp" %>
<!--================ End Features Area =================-->

 


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