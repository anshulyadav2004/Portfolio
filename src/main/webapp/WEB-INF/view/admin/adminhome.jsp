<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false" %>

<!doctype html>
<html lang="en" >
<head>
    <title>Admin Home Page</title>
</head>
<body><h1>Admin page</h1>

<a href="${pageContext.request.contextPath}/client/home">Client Home Page</a> |
<a href="${pageContext.request.contextPath}/admin/readAllContact">Read All Contacts</a> |
<a href="${pageContext.request.contextPath}/admin/addService">Add Service/Project</a> |
<a href="${pageContext.request.contextPath}/admin/readAllService">Read All Services</a> |
<a href="${pageContext.request.contextPath}/admin/upload">Upload Resume</a>

</body>
</html>