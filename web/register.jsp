<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
    <div class="container">
        <h1>Rejestracja</h1>
        <% if (request.getAttribute("message") != null) { %>
            <p style="color:red;"><%= request.getAttribute("message").toString() %></p>
        <% } %>
        <form action="register" method="post">
            <div class="form-group">
                <label for="username">Login:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Hasło:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <button type="submit">Zarejestruj</button>
        </form>
        <p>Masz już konto? <a href="login.jsp">Zaloguj się.</a>.</p>
    </div>
</body>
</html>
