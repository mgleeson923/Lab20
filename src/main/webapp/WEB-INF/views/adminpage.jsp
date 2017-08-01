<%--
  Created by IntelliJ IDEA.
  User: michaelgleeson
  Date: 7/31/17
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        header{
            font-size: 200%;
            color: white;
            text-align: center;
        }

        body {
            background-size: 80px 60px;
            background: url("http://cdn.wallpapersafari.com/12/17/mKhbMr.jpg") no-repeat;
            background-size: 100%;
            text-align: center;
            color: white;

        }

        table {
            align-content: center;
        }

        a:link {
            color: orange;
            font-size: 125%;
        }

        a:visited {
            color: purple;
            font-size: 125%;
        }

        a:hover {
            color: hotpink;
            font-size: 125%;
        }

        a:active {
            color: green;
            font-size: 125%;
        }

    </style>
    <title>Admin Page</title>
</head>
<body>
<a href="/inventory">Inventory</a>
<br>
<a href="/listusers">Registered Users</a>

</body>
</html>
