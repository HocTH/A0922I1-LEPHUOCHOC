<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/09/2023
  Time: 09:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">Danh Sách Khách Hàng</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa Chỉ</th>
            <th>Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td >${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>${customer.address}</td>
                <td><img src="image/${customer.image}" width="50px"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
