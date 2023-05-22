<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/14/2023
  Time: 07:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <meta charset="utf-8">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
   <h2>
        <a href="/users?action=sort">Sort Name</a>
    </h2>
    <h2>
        <a href="/users?action=test-without-tran">test-without-tran</a>
    </h2>

    <form action="/users" method="get">
        <div class="input-group mb-3">
            <input type="hidden" name="action" value="search">
            <input type="text" name="country" class="form-control" placeholder="Search country user..." aria-describedby="helpId">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2 align="center">List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>