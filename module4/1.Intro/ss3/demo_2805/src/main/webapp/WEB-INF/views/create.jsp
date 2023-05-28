<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/28/2023
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="user" action="create-user" method="post">
    Name:<form:input path="name"/><br>
    Gender:<form:radiobuttons path="gender" items="${gendersArray}"/><br>
    Is admin:<form:checkbox path="admin"/><br>
    Hobbies:<form:checkboxes path="hobbies" items="${hobbiesArray}"/><br>
    Type:<form:checkboxes path="type" items="${typesArray}"/>
    Country: <form:select path="country" items="${countriesArray}"/>
    <button type="submit">Create User</button>
</form:form>
</body>
</html>
