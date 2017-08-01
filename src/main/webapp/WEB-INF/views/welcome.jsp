<%--
  Created by IntelliJ IDEA.
  User: michaelgleeson
  Date: 7/21/17
  Time: 11:04 AM
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
    <title>Lab20</title>
</head>
<header>Welcome to Michael's Coffee Shop</header>
<br>
<a href="/form">Click here to Register</a>
<br>
<a href="/listitems">Menu</a>
<br>
<a href="/adminpage">Admin Tools</a>
<body>

<table border="1">
    <c:forEach var="myVar" items="${cList}">
        <tr>
            <td>${myVar.name}</td>
            <td>${myVar.quantity}</td>
            <td>${myVar.description}</td>
            <td>${myVar.price}</td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
