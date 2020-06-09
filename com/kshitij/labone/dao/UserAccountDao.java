package com.kshitij.labone.dao;

import com.kshitij.labone.model.UserAccount;


import java.util.ArrayList;
import java.util.List;

public interface UserAccountDao {
    void createuserAccountInfo(UserAccount useraccount);

    List<UserAccount> allaccount();

    void withdraw_deposit_Balance(UserAccount userAccount);

    void deleteAccount(UserAccount userAccount);
}
