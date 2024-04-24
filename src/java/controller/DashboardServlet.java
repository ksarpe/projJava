package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Recipe;
//import model.User;
import database.DatabaseConfig;

public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User currentUser = (User) session.getAttribute("currentUser");
//        if (currentUser == null) {
//            response.sendRedirect("login.jsp");
//            return;
//        }

        List<Recipe> recipes = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM recipes")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Recipe recipe = new Recipe(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("user_id")
                    );
                    System.out.println("Dodano przepis");
                    recipes.add(recipe);
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Problem z baza danych", e);
        }

        request.setAttribute("recipes", recipes);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
