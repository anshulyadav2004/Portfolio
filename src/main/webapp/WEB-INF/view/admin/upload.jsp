<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload Resume - Admin Panel</title>
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
        .success-msg {
            color: green;
            font-size: 14px;
            display: block;
            margin-bottom: 10px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"], input[type="file"], textarea {
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

<h1>Admin - Upload Resume</h1>

<!-- Navigation Links -->
<nav>
    <a href="${pageContext.request.contextPath}/admin/home">Admin Dashboard</a> |
    <a href="${pageContext.request.contextPath}/client/home">Client Home Page</a>
</nav>

<hr>
<br>

<!-- Success / Error Messages -->
<c:if test="${not empty message}">
    <span class="success-msg">${message}</span>
</c:if>
<c:if test="${not empty errorMessage}">
    <span class="error-msg">${errorMessage}</span>
</c:if>
<c:if test="${not empty errors}">
    <span class="error-msg">${errors}</span>
</c:if>

<!-- File Upload Form: Must use enctype="multipart/form-data" for file uploads -->
<form action="${pageContext.request.contextPath}/admin/upload" method="post" enctype="multipart/form-data">

    <!-- Candidate/Title Info -->
    <div class="form-group">
        <label for="title">Resume Title / Version:</label><br>
        <input type="text" id="title" name="resumeTitle" value="${resumeDto.resumeTitle}" placeholder="e.g. Anshul_Yadav_Java_Developer_Resume" required>
        <c:forEach var="err" items="${error}">
            <c:if test="${err.field eq 'resumeTitle'}">
                <span class="error-msg">${err.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </div>

    <!-- Description / Key Skills Overview -->
    <div class="form-group">
        <label for="description">Summary / Notes:</label><br>
        <textarea id="description" name="resumeDescription" placeholder="Brief notes or key highlights regarding this version..." rows="4" cols="50">${resumeDto.resumeDescription}</textarea>
        <c:forEach var="err" items="${error}">
            <c:if test="${err.field eq 'resumeDescription'}">
                <span class="error-msg">${err.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </div>

    <!-- File Input -->
    <div class="form-group">
        <label for="resumeFile">Select Resume File (PDF / DOCX):</label><br>
        <input type="file" id="resumeFile" name="resumeFile" accept=".pdf,.doc,.docx" required>
        <c:forEach var="err" items="${error}">
            <c:if test="${err.field eq 'resumeFile'}">
                <span class="error-msg">${err.defaultMessage}</span>
            </c:if>
        </c:forEach>
    </div>

    <button type="submit">Upload Resume</button>
</form>

</body>
</html>