//package com.modules.database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class CreateDatabaseUser {
//    public static void main (String args[]) throws SQLException {
//        final String JDBC_DRIVER = "org.postgresql.Driver";
//        final String DB_URL = "jdbc:postgresql://localhost:5432/variant3";
//        final String USER = "postgres";
//        final String PASS = "aibek1213";
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            Class.forName(JDBC_DRIVER);
//        } catch (ClassNotFoundException var2) {
//            System.out.println("PostgreSQL JDBC Driver is not found.");
//            var2.printStackTrace();
//            return;
//        }
//        conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        System.out.println("Connected database successfully...");
//
//        // STEP 2: DROP
//        /*stmt = conn.createStatement();
//        String drop = "DROP TABLE IF EXISTS users";
//        stmt.executeUpdate(drop);
//        System.out.println("Table was droped");*/
//        // STEP 3: CREATE
//        String create =
//                "CREATE TABLE  users " +
//                "(id SERIAL , " +
//                " username VARCHAR(255), " +
//                " password VARCHAR(255), " +
//                " fname VARCHAR(255), " +
//                " lname VARCHAR(255), " +
//                " PRIMARY KEY ( id ))";
//
//        // STEP 4: Execute a query
//        stmt = conn.createStatement();
//        stmt.executeUpdate(create);
//        System.out.println("Table was created");
//        stmt.close();
//        conn.close();
//    }
//}
