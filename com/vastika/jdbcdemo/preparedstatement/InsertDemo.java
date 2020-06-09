package com.vastika.jdbcdemo.preparedstatement;

import com.vastika.jdbcdemo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
    public static final String SQL ="insert into user_tbl(id,user_name,age)values(?,?,?)";

    public static void main(String[] args) {
        try(PreparedStatement ps = DBUtil.getConnection().prepareStatement(SQL)){
            ps.setInt(1,3);
            ps.setString(2,"krishna giri");
            ps.setInt(3,41);
            ps.executeUpdate();
            System.out.println("Values inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }

}
