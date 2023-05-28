<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/28/2023
  Time: 09:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Configuration</title>
</head>
<body>
<form:form modelAttribute="mail" action="save" method="post">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Languages</td>
            <td><form:select path="language" items="${languages}"/></td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>show <form:select path="sizePage" items="${sizes}"/>email per page</td>
        </tr>
        <tr>
            <td>spamFilter</td>
            <td><form:checkbox path="spam"/>enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="content"/></td>
        </tr>
        <tr>
            <td><button type="submit" value="Submit">Submit</button> </td>
            <td><button type="reset" value="Back"><A href="home">Back</A></button> </td>
        </tr>

    </table>
</form:form>
</body>
</html>
