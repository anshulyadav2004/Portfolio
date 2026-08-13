<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Read All Contact Home Page</title>
</head>
<body>

<h1>Read All Contact Page</h1>

<!-- Navigation Links -->
<p>
    <a href="${pageContext.request.contextPath}/client/home">Client Home Page</a> |
    <a href="${pageContext.request.contextPath}/admin/adminhome">Admin Page</a>
</p>

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
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>