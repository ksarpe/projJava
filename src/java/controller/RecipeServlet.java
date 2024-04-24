package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import database.DatabaseConfig;
import model.User;
import java.sql.*;

public class RecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Możesz tu implementować logikę do wyświetlania szczegółów przepisu
        // int recipeId = Integer.parseInt(request.getParameter("id"));
        // Pobierz przepis z bazy danych używając recipeId
        // Ustaw przepis jako atrybut żądania
        // Przekieruj do JSP wyświetlającego szczegóły przepisu
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    // Załóżmy, że użytkownik jest już zalogowany i jego ID jest przechowywane w sesji
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    int userId = currentUser.getId();

    try (Connection connection = DatabaseConfig.getConnection()) {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO recipes (name, description, user_id) VALUES (?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, description);
        ps.setInt(3, userId);
        ps.executeUpdate();
        response.sendRedirect("dashboard"); // Przekieruj użytkownika z powrotem do dashboardu
        System.out.println("Dodano przepis do bazy");
    } catch (SQLException e) {
        throw new ServletException("Database error: " + e.getMessage());
    }
}

}
