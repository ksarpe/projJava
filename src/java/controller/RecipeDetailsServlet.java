package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import model.Recipe;
import database.DatabaseConfig;

public class RecipeDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int recipeId = Integer.parseInt(request.getParameter("id"));
        Recipe recipe = null;
        System.out.println(recipeId);

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM recipes WHERE id = ?")) {
            ps.setInt(1, recipeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                recipe = new Recipe(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("user_id")
                );
                recipe.setUserId(rs.getInt("user_id")); // Set the user to the recipe
            }
        } catch (SQLException e) {
            throw new ServletException("Database error while retrieving recipe details", e);
        }

        if (recipe != null) {
            request.setAttribute("recipe", recipe);
            request.getRequestDispatcher("/recipeDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("dashboard"); // Redirect if no recipe found
        }
    }
}
