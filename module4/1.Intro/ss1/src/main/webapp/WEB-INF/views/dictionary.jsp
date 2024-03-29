<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/14/2023
  Time: 06:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<form class="row g-3" action="translate" method="get">
    <div class="col-md-3">
        <label for="inputWord" class="form-label">Input Word</label>
        <input type="text" name="inputWord" class="form-control" id="inputWord"  placeholder="Input word to translate "value="${inputWord}" >
    </div>
    <div class="col-3">
        <label for="inputResult" class="form-label">Search</label>
        <input type="text" class="form-control" id="inputResult" value="${result}" disabled>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>
