<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Recipe" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Szczegóły przepisu</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Szczegóły przepisu</h1>
        <% 
        Recipe recipe = (Recipe) request.getAttribute("recipe");
        if (recipe != null) {
            %>
            <h2><%= recipe.getName() %></h2>
            <p><strong>Opis:</strong> <%= recipe.getDescription() %></p>
            <p><strong>Autor:</strong> <%= recipe.getOwnerName() %></p>
            <%
        } else {
            %>
            <p>Nie znaleziono przepisu.</p>
            <%
        }
        %>
        <a href="dashboard">Wróc na stronę główną</a>
    </div>
</body>
</html>
