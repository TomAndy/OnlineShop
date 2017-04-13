package com.onlineshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDb {
    private final String DRIVER = "org.postgresql.Driver";
    private final String HOST = "localhost";
    private final String PORT = "5432";
    private final String DATABASE = "OnlineShopDb";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    public Connection getConnection() {
        Connection conn = null;
        String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);
//            if(conn != null) {
//                System.out.println("Connected to db");
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
