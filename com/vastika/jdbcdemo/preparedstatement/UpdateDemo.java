package com.vastika.jdbcdemo.preparedstatement;

import com.vastika.jdbcdemo.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {
    public static final String SQL ="update user_tbl set user_name= ?, age=? where id =?";

    public static void main(String[] args) {
        try(PreparedStatement ps = DBUtil.getConnection().prepareStatement(SQL)){

            ps.setString(1,"krishna nepal");
            ps.setInt(2,31);
            ps.setInt(3,3);
            ps.executeUpdate();
            System.out.println("Data updated");

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }
}
