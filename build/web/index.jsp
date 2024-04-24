<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Recipe" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Zarządzanie Przepisami</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header>
        <h1>Dashboard</h1>
        <% 
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) { %>
            <p>Cześć <%= currentUser.getUsername() %>!</p>
            <a href="logout">Wyloguj</a>
        <% } else { %>
            <p>Nie jesteś zalogowany! <a href="login.jsp">Zaloguj</a> albo <a href="register.jsp">Zarejestruj się!</a></p>
        <% }
        %>
    </header>

    <div class="container">
        <h2>Dostępne przepisy</h2>
        <% 
        List<Recipe> recipes = (List<Recipe>) request.getAttribute("recipes");
        if (recipes != null && !recipes.isEmpty()) { %>
            <ul>
            <% for (Recipe recipe : recipes) { %>
                <li>
                    <%= recipe.getName() %> - 
                    <a href="recipeDetails?id=<%= recipe.getId() %>">Pokaż</a>
                </li>
            <% } %>
            </ul>
        <% } else { %>
            <p>Brak przepisów...</p>
        <% } %>
        <br>
        <a href="dashboard">Odśwież</a><br>
        <a href="addRecipe.jsp">Dodaj przepis</a>
        
    </div>
</body>
</html>
