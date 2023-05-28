<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/26/2023
  Time: 09:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="save" modelAttribute="mail">
    <table>
        <tr>
             <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Languages</td>
            <td><form:select path="language" items="${languagesList}"/></td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>show <form:select path="sizePage" items="${pageSize}"/>email per page</td>
        </tr>
        <tr>
            <td>spamFilter</td>
            <td><form:checkbox path="spam"/>enable spams filter</td>
        </tr>
        <tr>
            <td>signature</td>
            <td><form:textarea path="content"/></td>
        </tr>
        <tr>
            <td><form:button>Update</form:button></td>
            <td><form:button>back</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
