<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

<h1>Name:${user.name}</h1>
<h1>Gender:${user.gender}</h1>
<h1>Is admin:${user.admin}</h1>
<h1>Hobbies:${user.hobbies}</h1>
<h1>Type:${user.type}</h1>
<h1>Country: ${user.country}</h1>
</body>
</html>
