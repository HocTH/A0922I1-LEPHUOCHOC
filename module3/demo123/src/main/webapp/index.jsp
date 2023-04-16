<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style type="text/css">
        .login {
            height:180px; width:230px;
            margin:0;
            padding:10px;
            border:1px #CCC solid;
        }
        .login input {
            padding:5px; margin:5px
        }
    </style>
</head>
<body>
<form method="post" action="/convert">
    <h2>Currency Converter</h2>
    <form>
        <label>Rate: </label><br/>
        <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
        <label>USD: </label><br/>
        <input type="text" name="usd" placeholder="USD" value="0"/><br/>
        <input type = "submit" id = "submit" value = "Converter"/>
    </form>
</form>
</body>
</html>