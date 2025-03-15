package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=LibSystemDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connected to database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connection conn = DBContext.getConnection();
        if (conn != null) {
            System.out.println("Connect successfully!");
            closeConnection(conn);
        } else {
            System.out.println("Connect failure!");
        }
    }
}