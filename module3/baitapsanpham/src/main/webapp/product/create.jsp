<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/12/2023
  Time: 09:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Create new product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p><a href="/products"> Back </a></p>
<form method="post">
    <fieldset>
        <legend>
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
               <tr>
                   <td>Price</td>
                   <td><input type="text" name="price" id="price"></td>
               </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" id="description"></td>
                </tr>
                <tr>
                    <td>Maker</td>
                    <td><input type="text" name="maker" id="maker"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create customer"></td>
                </tr>
            </table>
        </legend>
    </fieldset>

</form>
</body>
</html>
