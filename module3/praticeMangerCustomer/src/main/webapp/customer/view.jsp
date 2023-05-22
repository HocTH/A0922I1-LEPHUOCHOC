<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/10/2023
  Time: 08:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>View customer</title>
</head>
<body>
<h1>View customer</h1>
<a href="/customers">Back to customer list</a>
<fieldset>
<legend>Customer information</legend>
<table border="1">
    <tr>
        <td>Name: </td>
        <td>${requestScope["customer"].getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["customer"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["customer"].getAddress()}</td>
    </tr>
</table>
</fieldset>

</body>
</html>
