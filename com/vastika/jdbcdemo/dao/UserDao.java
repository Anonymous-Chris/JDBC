package com.vastika.jdbcdemo.dao;

import com.vastika.jdbcdemo.model.User;

import java.util.List;

public interface UserDao {
    void saveUserInfo(User user);

    List<User> getAllUserInfo();

    void updateUserInfo(User user);

    //an example of delete so that we know it is deleted and we get a certain value back
    int deleteUserInfo(User user);

}
