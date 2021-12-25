package com.modules.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {
    public static Connection connectDB() throws SQLException {
        final String JDBC_DRIVER = "org.postgresql.Driver";
        final String DB_URL = "jdbc:postgresql://localhost:5432/variant3";
        final String USER = "postgres";
        final String PASS = "aibek1213";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException var2) {
            System.out.println("PostgreSQL JDBC Driver is not found.");
            var2.printStackTrace();
        }
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        return  conn;
    }
}
