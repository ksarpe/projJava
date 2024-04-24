package model;

import database.DatabaseConfig;
import jakarta.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Recipe {
    private int id;
    private String name;
    private String description;
    private int userId;

    public Recipe(int id, String name, String description, int userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getOwnerName() throws SQLException {
    String ownerName = "Unknown"; // Default to "Unknown" if no user is found
    try (Connection conn = DatabaseConfig.getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT username FROM users WHERE id = ?")) {
        ps.setInt(1, this.userId); // Assuming this.userId is set to the user ID of the recipe owner
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                ownerName = rs.getString("username");
            }
        }
    } catch (SQLException e) {
        throw e; // Rethrow the exception or handle it as per your error-handling policy
    }
    return ownerName;
}

}
