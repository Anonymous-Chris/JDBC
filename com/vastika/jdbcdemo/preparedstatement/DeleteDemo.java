package com.vastika.jdbcdemo.preparedstatement;

import com.vastika.jdbcdemo.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDemo {
    public static final String SQL ="delete from user_tbl where id=?";

    public static void main(String[] args) {
        try(PreparedStatement ps = DBUtil.getConnection().prepareStatement(SQL)){
            ps.setInt(1,3);

            ps.executeUpdate();
            System.out.println("Values deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }
}
