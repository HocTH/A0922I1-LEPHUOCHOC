<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/28/2023
  Time: 09:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Languages</th>
        <th>Page Size: </th>
        <th>Spams filter: </th>
        <th>Signature: </th>
        <th>Action</th>
    </tr>
    <c:forEach var="mail" items="${mails}">
        <tr>
            <td>
                    ${mail.language}
            </td>
            <td>
                    ${mail.sizePage}
            </td>
            <td>
                    ${mail.spam}
            </td>
            <td>
                    ${mail.content}
            </td>
            <td><a href="/update?id=${mail.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
