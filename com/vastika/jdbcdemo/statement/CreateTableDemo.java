package com.vastika.jdbcdemo.statement;

import com.vastika.jdbcdemo.util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTableDemo {
    public static final String SQL ="create table user_tbl(id int not null, user_name varchar(30), age int, primary key(id))";

    public static void main(String[] args) {
        try(Connection con = DBUtil.getConnection();
            Statement st = con.createStatement();){
            st.executeUpdate(SQL);
            System.out.println("Table created");

        } catch (SQLException e) {
            e.printStackTrace();
        } ;

    }
}
