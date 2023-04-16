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
<form  action="/count" method="post">
    <label>Product Description:</label> <br/>
    <input type="text" name="ProductDescription" placeholder="..."/> <br/>
    <label>List Price:</label> <br/>
    <input type="text" name="ListPrice" placeholder="price"/> <br/>
    <label>Discount Percent:</label> <br/>
    <input type="text" name="DiscountPercent" placeholder="Discount Percent"/> <br/>
    <input type="submit" id="submit" value="Calculate Discount"/>
</form>
</body>
</html>