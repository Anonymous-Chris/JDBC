package com.vastika.jdbcdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static final String URL = "jdbc:mysql://localhost:3306/user_db";
    public static final String USER_NAME="root";
    public static final String PASSWORD="me@Hero1";
    public static final String DRIVER_NAME ="com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }


}
