package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constant {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/stokkarti";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
