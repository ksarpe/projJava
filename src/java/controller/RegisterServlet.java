package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.DatabaseConfig;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // Hasło powinno być hashowane przed zapisaniem
        String email = request.getParameter("email");

        if (username == null || password == null || email == null ||
            username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            request.setAttribute("message", "All input fields must be filled.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Łączenie z bazą danych i dodanie użytkownika
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)")) {
            ps.setString(1, username);
            ps.setString(2, password); // W prawdziwej aplikacji użyj zahashowanego hasła
            ps.setString(3, email);

            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("login.jsp"); // Przekieruj do strony logowania po udanej rejestracji
            } else {
                request.setAttribute("message", "User registration failed.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("message", "Database error: " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
