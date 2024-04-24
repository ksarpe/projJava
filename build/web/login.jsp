<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
    <% if (request.getAttribute("loginError") != null) { %>
        <p style="color:red;"><%= request.getAttribute("loginError") %></p>
    <% } %>
    <form action="login" method="post">
        <label for="username">Login:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Hasło:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Zaloguj</button>
    </form
