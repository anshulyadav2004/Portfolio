<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!doctype html>
<html lang="en" >
<head>
    <title>Service Read</title>
</head>



<body>
<a href="${pageContext.request.contextPath}/client/home">Client Home Page</a> |
<a href="${pageContext.request.contextPath}/admin/home">Admin Page</a> |
<a href="${pageContext.request.contextPath}/admin/addService">Add New Service</a>

<c:if test="${not empty result}">
    <p style="color: green; font-weight: bold;">${result}</p>
</c:if>

<c:forEach var="service" items="${listofservices}">
    <div class="row feature_inner" style="margin-bottom: 20px; border-bottom: 1px solid #ccc; padding-bottom: 10px;">
        <div class="col-lg-3 col-md-6">
            <div class="feature_item">
                <c:if test="${not empty service.fileName}">
                    <img style="width: 120px; height: auto;" src="${pageContext.request.contextPath}/img/services/${service.fileName}" alt="${service.title}">
                </c:if>
                <h4>${service.title}</h4>
                <p>${service.description}</p>
                <c:if test="${not empty service.link}">
                    <p><a href="${service.link}" target="_blank">Visit Link</a></p>
                </c:if>
                <a href="${pageContext.request.contextPath}/admin/deleteService?id=${service.id}&fileName=${service.fileName}" onclick="return confirm('Are you sure you want to delete this service?');">Delete</a> |
                <a href="${pageContext.request.contextPath}/admin/updateService?id=${service.id}">Update</a>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>