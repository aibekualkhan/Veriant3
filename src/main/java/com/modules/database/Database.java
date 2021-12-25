package com.modules.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void main (String args[]) throws SQLException {
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
        // STEP 2: DROP
        /*stmt = conn.createStatement();
        String drop = "DROP TABLE IF EXISTS users";
        stmt.executeUpdate(drop);
        System.out.println("Table was droped");*/
        // STEP 3: CREATE
        //CREATE City
        String createCity =
                "CREATE TABLE IF NOT EXISTS  city " +
                        "(id SERIAL , " +
                        " category VARCHAR(255),"+
                        " PRIMARY KEY ( id ))";
        stmt = conn.createStatement();
        stmt.executeUpdate(createCity);

        // CREATE USERS
        String createUser =
                "CREATE TABLE IF NOT EXISTS  users " +
                        "(id SERIAL , " +
                        " username VARCHAR(255),"+
                        " password VARCHAR(255), " +
                        " usertype VARCHAR(255)," +
                        " PRIMARY KEY ( id ))";
        stmt = conn.createStatement();
        stmt.executeUpdate(createUser);
        //CREATE STUDENTS
        String createStudent =
                "CREATE TABLE IF NOT EXISTS  students " +
                        "(id SERIAL , " +
                        " ECname VARCHAR(255),"+
                        " address VARCHAR(255), " +
                        " phone VARCHAR(255)," +
                        " email VARCHAR(255)," +
                        " ECtype VARCHAR(255)," +
                        " cityid INT,"+
                        " CONSTRAINT cityId FOREIGN KEY(id) REFERENCES city(id), "+
                        " PRIMARY KEY ( id ))";
        stmt = conn.createStatement();
        stmt.executeUpdate(createStudent);

        //CREATE STUDENTS
        String createTourPlace =
                "CREATE TABLE IF NOT EXISTS tourists " +
                        "(id SERIAL , " +
                        " placeName VARCHAR(255),"+
                        " address VARCHAR(255), " +
                        " phone VARCHAR(255)," +
                        " placeType VARCHAR(255)," +
                        " cityid INT,"+
                        " CONSTRAINT cityId FOREIGN KEY(id) REFERENCES city(id), "+
                        " PRIMARY KEY ( id ))";
        stmt = conn.createStatement();
        stmt.executeUpdate(createTourPlace);
        // CREATE TYPES " typeId INT FOREIGN KEY(typeId) REFERENCES types(typeId), "+

        System.out.println("Table was created");
        stmt.close();
        conn.close();
    }
}
