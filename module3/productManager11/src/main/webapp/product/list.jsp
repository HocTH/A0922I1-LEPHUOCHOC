<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/12/2023
  Time: 06:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="2">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Manufacturer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
<c:forEach items='${"products"}' var="product">
    <td><a href="/products?action=view&id=${product.getId()}"> ${product.getName()}</a></td>
    <td>${product.getPrice()}</td>
    <td>${product.getDescription()}</td>
    <td>${product.getManufacturer()}</td>
    <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
    <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
</c:forEach>
    </table>
</body>
</html>
