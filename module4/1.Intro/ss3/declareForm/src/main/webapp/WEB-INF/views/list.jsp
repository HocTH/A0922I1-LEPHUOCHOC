<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/29/2023
  Time: 06:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
</head>
<body>
<div class="row">
    <div class="col-11 ps-5"><h2>List Heath Declare</h2></div>
    <div class="col-1"><a class="btn btn-success" href="/create">Add new</a></div>
</div>
<table class="table">
    <thead>
    <th>Ho va ten</th>
    <th>Nam sinh</th>
    <th>Dien thoai </th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="e" items="${res}">
        <tr>
            <td>${e.fullName}</td>
            <td>${e.yearBirthday}</td>
            <td>${e.phone}</td>
            <td>
                <a href="/form/ + ${e.id}" >Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
