package com.vastika.jdbcdemo.statement;

import com.vastika.jdbcdemo.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo {
    public static final String SQL ="select * from user_tbl";

    public static void main(String[] args) {
        try(Statement st = DBUtil.getConnection().createStatement()){
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                System.out.println("id is" + rs.getInt("id"));
                System.out.println("username is:" + rs.getString("user_name"));
                System.out.println("age is :" + rs.getInt("age"));
                System.out.println("==============");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }
}
