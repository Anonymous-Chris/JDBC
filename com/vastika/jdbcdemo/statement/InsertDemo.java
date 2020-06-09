package com.vastika.jdbcdemo.statement;
import com.vastika.jdbcdemo.util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class InsertDemo {

    public static final String SQL ="insert into user_tbl(id,user_name,age)values(1,'kshitj',24)";

    public static void main(String[] args) {
        try(Connection con = DBUtil.getConnection();
            Statement st = con.createStatement();){
            st.executeUpdate(SQL);
            System.out.println("Values inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }

}
