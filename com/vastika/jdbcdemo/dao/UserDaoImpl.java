package com.vastika.jdbcdemo.dao;

import com.vastika.jdbcdemo.model.User;
import com.vastika.jdbcdemo.util.DBUtil;
import com.vastika.jdbcdemo.util.QueryUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements  UserDao{


    @Override
    public void saveUserInfo(User user) {
        try(PreparedStatement ps = DBUtil.getConnection().prepareStatement(QueryUtil.INSERT_SQL)){
            ps.setInt(1,user.getId());
            ps.setString(2,user.getUserName());
            ps.setInt(3,user.getAge());
            ps.executeUpdate();
          

        } catch (SQLException e) {
            e.printStackTrace();
        } ;

    }

    @Override
    public List<User> getAllUserInfo() {
        List <User> userList = new ArrayList<>();
        try(PreparedStatement st = DBUtil.getConnection().prepareStatement(QueryUtil.LIST_SQL)){
            ResultSet rs = st.executeQuery();
            while(rs.next() ){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setAge(rs.getInt("age"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
        return userList;
    }

    @Override
    public void updateUserInfo(User user) {
        try(PreparedStatement ps = DBUtil.getConnection().prepareStatement(QueryUtil.UPDATE_SQL)){

            ps.setString(1,user.getUserName());
            ps.setInt(2,user.getAge());
            ps.setInt(3,user.getId());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }

    @Override
    public int deleteUserInfo(User user) {
        int saved=0;
        try(PreparedStatement ps = DBUtil.getConnection().prepareStatement(QueryUtil.DELETE_SQL)){
            ps.setInt(1,user.getId());

            saved=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } ;
        return saved;
    }
}
