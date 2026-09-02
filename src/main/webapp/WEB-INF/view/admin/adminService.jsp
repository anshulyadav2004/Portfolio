<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Service Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .error-msg {
            color: red;
            font-size: 14px;
            display: block;
            margin-top: 4px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"], input[type="url"], input[type="file"], textarea {
            margin-top: 5px;
            padding: 8px;
            width: 350px;
        }
        button {
            padding: 8px 16px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h1>Admin Service / Project</h1>

<!-- Navigation Links -->
<nav>
    <a href="${pageContext.request.contextPath}/admin/home">Admin Dashboard</a> |
    <a href="${pageContext.request.contextPath}/admin/readAllService">Read All Services</a> |
    <a href="${pageContext.request.contextPath}/admin/readAllContact">Read All Contacts</a> |
    <a href="${pageContext.request.contextPath}/client/home">Client Home Page</a>
</nav>

<hr>
<br>
${errors} ${result}
<!-- Success / Result Message -->
<c:if test="${not empty result}">
    <div style="color: green; font-weight: bold; margin-bottom: 15px;">
        ${result}
    </div>
</c:if>

<!-- Upload Form -->
<form action="${pageContext.request.contextPath}/admin/adminService" method="post" enctype="multipart/form-data">

    <!-- Title Field -->
    <div class="form-group">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" value="${serviceDto.title}" placeholder="Enter the title for Service">
        <c:forEach var="err" items="${error}">
            <c:if test="${err.field eq 'title'}">
                <span class="error-msg">${err.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </div>

    <!-- Description Field -->
    <div class="form-group">
        <label for="description">Description:</label><br>
        <textarea id="description" name="description" placeholder="Enter the description" rows="4" cols="50">${serviceDto.description}</textarea>
        <c:forEach var="err" items="${error}">
            <c:if test="${err.field eq 'description'}">
                <span class="error-msg">${err.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </div>

    <!-- File Upload Field -->
    <div class="form-group">
        <label for="serviceFile">Service File:</label><br>
        ${FileError}
        <input type="file" id="serviceFile" name="serviceFile">
        <c:forEach var="err" items="${error}">
            <c:if test="${err.field eq 'serviceFile'}">
                <span class="error-msg">${err.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </div>
    <div class="form-group">
        <label for="link">Project Link / URL:</label><br>
        <input type="url" id="link" name="link" value="${serviceDto.link}" placeholder="https://..." required>
        <c:forEach var="err" items="${error}">
            <c:if test="${err.field eq 'link'}">
                <span class="error-msg">${err.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </div>

    <button type="submit">Submit</button>
</form>




</body>
</html>