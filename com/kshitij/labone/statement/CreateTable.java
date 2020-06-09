package com.kshitij.labone.statement;

import com.kshitij.labone.util.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static final String SQL ="create table user_account(accountnumber int not null auto_increment, user_name varchar(30), balance double, primary key(accountnumber))";

    public static void main(String[] args) {
        try(Connection con = DB.getConnection();
            Statement st = con.createStatement();){
            st.executeUpdate(SQL);
            System.out.println("Table created");

        } catch (SQLException e) {
            e.printStackTrace();
        } ;

    }
}
