package com.project.railwayreservation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    //create JDBC connection
    public static Connection getConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/TrainDB";
        String dbUsername = "root";
        String dbPass = "test1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, dbUsername, dbPass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
