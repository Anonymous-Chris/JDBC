package com.vastika.jdbcdemo.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBDemo {

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USER_NAME="root";
    public static final String PASSWORD="me@Hero1";
    public static final String DRIVER_NAME ="com.mysql.jdbc.Driver";
    public static final String SQL ="create database user_db";

    public static void main(String[] args){
        Connection con = null;
        Statement st = null;

        try{
            //1.register the driver
            Class.forName(DRIVER_NAME);
            //2.get the object of connection using driver manager
            con = DriverManager.getConnection(URL, USER_NAME,PASSWORD);
            // 3.get statement object using connection
            st = con.createStatement();
            //4.execute the query
            st.executeUpdate(SQL);
            System.out.println("Database created");

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                //5. close the connection
                con.close();
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }




    }
}
