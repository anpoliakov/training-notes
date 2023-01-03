<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="logic.Cart" %>
<html>
<head>
    <title>YOUR CART</title>
</head>
<body>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
    %>

    <p> <%= "NAME - " + cart.getName() %> </p>
    <p> <%= "COST - " + cart.getCost() %> </p>
</html>
