package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11701573?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "sql11701573";
    private static final String PASS = "EQpK3jx2fG";

    static {
        try {
            Class.forName(JDBC_DRIVER); // Explicitly load the JDBC driver
        } catch (ClassNotFoundException e) {
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
