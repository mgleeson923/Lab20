<%--
  Created by IntelliJ IDEA.
  User: michaelgleeson
  Date: 7/21/17
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        form {
            font-size: 120%;
            color: white;
            text-align: center;
        }

        h1 {
            align-content: center;
            color: white;
            text-align: center;
        }

        body {
            background-size: 80px 60px;
            background: url("http://cdn.wallpapersafari.com/12/17/mKhbMr.jpg") no-repeat;
            background-size: 100%;

        }

        form {

            align-content: center;
            margin: auto;
            width: 50%;
        }


    </style>
    <title>Lab 20</title>
</head>
<body>
<form method="post" action="/success">
    First name: <input type="text" name="c_name" required>
    <br>
    Last Name: <input type="text" name="c_lastname" required>
    <br>
    Email: <input type="email" name="c_email" required>
    <br>
    Phone Number: <input type="tel" name="c_phone" required>
    <br>
    Password: <input type="password" name="c_password" required>
    <br>
    <input type="submit" value="Submit Info">
    <input type="reset" value="Reset">
</form>


</body>
</html>
