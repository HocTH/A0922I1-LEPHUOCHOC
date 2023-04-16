<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/14/2023
  Time: 05:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<p><a href="/products"> Back to product list</a></p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product Information</legend>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" id="name" value="${requestScope["product"].getId() }"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" id="description" value="${requestScope["product"].getDescription()}"></td>
        </tr>
        <tr>
            <td>Maker</td>
            <td><input type="text" name="maker" id="maker" value="${requestScope["product"].getMaker()}" ></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Delete product"></td>
        </tr>
    </fieldset>
</form>
</body>
</html>
