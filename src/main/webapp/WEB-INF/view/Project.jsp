<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<section class="features_area pb-5">
    <br>
    <div class="container">
        <div class="row feature_inner">
            <c:forEach var="service" items="${listofservices}">
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="feature_item">
                        <c:if test="${not empty service.fileName}">
                            <img style="width: 100%; height: auto; max-height: 180px; object-fit: cover;" src="${pageContext.request.contextPath}/img/services/${service.fileName}" alt="${service.title}">
                        </c:if>
                        <h4>${service.title}</h4>
                        <p>${service.description}</p>
                        <c:if test="${not empty service.link}">
                            <p><a href="${service.link}" target="_blank" rel="noopener noreferrer">Visit Project &rarr;</a></p>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>