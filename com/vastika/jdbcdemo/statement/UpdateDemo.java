package com.vastika.jdbcdemo.statement;

import com.vastika.jdbcdemo.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {

        public static final String SQL ="update user_tbl set user_name='chris' where id =1";

        public static void main(String[] args) {
            try(Connection con = DBUtil.getConnection();
                Statement st = con.createStatement();){
                st.executeUpdate(SQL);
                System.out.println("Values updated");

            } catch (SQLException e) {
                e.printStackTrace();
            } ;
        }



}
