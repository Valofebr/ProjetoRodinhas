package com.login.registro.Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/agenda";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ifg";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do PostgreSQL não encontrado!", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
