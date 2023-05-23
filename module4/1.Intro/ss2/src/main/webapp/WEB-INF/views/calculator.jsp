<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/24/2023
  Time: 05:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="calculate" method="get">
    <input type="number" name="num1" placeholder="first number" value="${num1}">
    <input type="number" name="num2" placeholder="second number" value="${num1}">
    <br><br>

    <div class="row">
        <div class="col-3">
            <button type="submit" name="action" value="cong" class="btn btn-primary">Addition(+)</button>
        </div>
        <div class="col-3">
            <button type="submit" name="action" value="tru" class="btn btn-success">Subtraction(-)</button>
        </div>
        <div class="col-3">
            <button type="submit" name="action" value="nhan" class="btn btn-danger">Multiplication(X)</button>
        </div>
        <div class="col-3">
            <button type="submit" name="action" value="chia" class="btn btn-info">Division(/)</button>
        </div>
    </div>
<%--    <input type="submit" value="cong" name="action">--%>
<%--    <input type="submit" value="tru" name="action">--%>
<%--    <input type="submit" value="nhan" name="action">--%>
<%--    <input type="submit" value="chia" name="action">--%>
    <br><br>
    <input type="text" value="${result}" disabled>
</form>
</body>
</html>
