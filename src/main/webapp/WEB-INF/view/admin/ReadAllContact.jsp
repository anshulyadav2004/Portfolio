<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Read All Contacts</title>
    <style>
        .alert-success { color: green; font-weight: bold; margin-bottom: 15px; }
        .alert-error { color: red; font-weight: bold; margin-bottom: 15px; }
        .inline-form { display: inline; }
    </style>
</head>
<body>

<h1>Read All Contact Page</h1>

<!-- Navigation Links -->
<p>
    <a href="${pageContext.request.contextPath}/client/home">Client Home Page</a> |
    <a href="${pageContext.request.contextPath}/admin/home">Admin Page</a>
</p>

<!-- Global Flash Messages (Shown at top after redirect) -->
<c:if test="${not empty deleted}">
    <p class="alert-success"><c:out value="${deleted}"/></p>
</c:if>
<c:if test="${not empty error}">
    <p class="alert-error"><c:out value="${error}"/></p>
</c:if>

<h2>Read Contacts</h2>

<!-- Displaying contacts nicely in a table -->
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Subject</th>
        <th>Message</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="data" items="${ContactData}">
        <tr>
            <td><c:out value="${data.id}"/></td>
            <td><c:out value="${data.name}"/></td>
            <td><c:out value="${data.email}"/></td>
            <td><c:out value="${data.subject}"/></td>
            <td><c:out value="${data.message}"/></td>
            <td>
                <!-- Secure POST Request with Confirmation -->
                <form action="${pageContext.request.contextPath}/admin/deleteContact" method="post" class="inline-form" onsubmit="return confirm('Are you sure you want to delete this contact?');">
                    <input type="hidden" name="id" value="${data.id}" />
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>










































<!--

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Read All Contact Home Page</title>
</head>
<body>

<h1>Read All Contact Page</h1> -->

 <!-- Navigation Links -->
<!--
<p>
    <a href="${pageContext.request.contextPath}/client/home">Client Home Page</a> |
    <a href="${pageContext.request.contextPath}/admin/adminhome">Admin Page</a>
</p>

<h2>Read Contacts</h2>-->

<!-- Displaying contacts nicely in a table -->
<!--<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Subject</th>
        <th>Message</th>
        <th>Delete</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="data" items="${ContactData}">
        <tr>
            <td><c:out value="${data.id}"/></td>
            <td><c:out value="${data.name}"/></td>
            <td><c:out value="${data.email}"/></td>
            <td><c:out value="${data.subject}"/></td>
            <td><c:out value="${data.message}"/></td>
            <td> <a href="${pageContext.request.contextPath}/admin/deleteContact?id=${data.id}"> Delete </a></td>
            <td> ${deleted}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html> -->