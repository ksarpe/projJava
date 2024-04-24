<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%
    // Sprawdź, czy użytkownik jest zalogowany
    User currentUser = (User) session.getAttribute("currentUser");
    if (currentUser == null) {
        // Nie jest zalogowany, przekieruj na stronę logowania
        response.sendRedirect("login.jsp");
        return; // Zakończ wykonanie strony
    }
%>
<html>
<head>
    <title>Nowy przepis</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Dodaj nowy przepis</h1>
        <form action="recipe" method="post">
            <div class="form-group">
                <label for="name">Nazwa przepisu:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="description">Opis:</label>
                <textarea id="description" name="description" rows="5" required></textarea>
            </div>
            <button type="submit">Dodaj przepis</button>
        </form>
        <a href="dashboard">Powrót do strony głównej.</a>
    </div>
</body>
</html>
