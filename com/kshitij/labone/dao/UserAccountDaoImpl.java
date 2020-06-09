package com.kshitij.labone.dao;

import com.kshitij.labone.model.UserAccount;
import com.kshitij.labone.util.Query;
import com.kshitij.labone.util.DB;
import com.vastika.jdbcdemo.util.DBUtil;
import com.vastika.jdbcdemo.util.QueryUtil;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDaoImpl implements UserAccountDao {
    @Override
    public void createuserAccountInfo(UserAccount useraccount) {
        try(PreparedStatement ps = DB.getConnection().prepareStatement(Query.INSERT_SQL)){

            ps.setInt(1,useraccount.getAccountnumber());
            ps.setString(2,useraccount.getUsername());
            ps.setDouble(3, useraccount.getBalance());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }

    @Override
    public List<UserAccount> allaccount() {
        List <UserAccount> userList = new ArrayList<>();

        try(PreparedStatement st = DB.getConnection().prepareStatement(Query.READ_SQL)){
            ResultSet rs = st.executeQuery();
            while(rs.next() ){
                UserAccount userAccount = new UserAccount();

                userAccount.setAccountnumber(rs.getInt("accountnumber"));
                userAccount.setUsername(rs.getString("user_name"));
                userAccount.setBalance(rs.getDouble("balance"));
                userList.add(userAccount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
        return userList;
    }

    @Override
    public void withdraw_deposit_Balance(UserAccount useraccount) {

        try(PreparedStatement ps = DB.getConnection().prepareStatement(Query.UPDATE_AFTER_WITHDRAW_DEPOSIT_SQL)){

            ps.setDouble(1,useraccount.getBalance());
            ps.setInt(2,useraccount.getAccountnumber());

            ps.executeUpdate();
            System.out.println("Balance is withdrawn");

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }

    @Override
    public void deleteAccount(UserAccount userAccount) {
        try(PreparedStatement ps = DB.getConnection().prepareStatement(Query.DELETE_SQL)){
            ps.setInt(1,userAccount.getAccountnumber());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }


}

