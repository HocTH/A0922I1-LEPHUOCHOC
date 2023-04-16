<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/09/2023
  Time: 06:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student list</h1>
<table class="table">
    <thead>
    <tr>ID</tr>
    <tr>Name</tr>
    <tr>Gender</tr>
    <tr>Point</tr>
    <tr>Result</tr>
    <tr>Image</tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>
                <c:choose>
                    <c:when test="${student.gender == 1}"> Male</c:when>
                    <c:when test="${student.gender == 0}"> Female</c:when>
                </c:choose>
            </td>
            <td>${student.point}</td>
            <td><img src="src/main/webapp/static/img/${student.image}"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
