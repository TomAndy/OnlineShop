package com.onlineshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDb {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String DATABASE = "OnlineShopDb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() {
        Connection conn = null;
        String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER, PASSWORD);
//            if(conn != null) {
//                System.out.println("Connected to db");
//            }
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
//            throw new MyNewException(ErrorCode.DB_CONNECTION_ERROR);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
