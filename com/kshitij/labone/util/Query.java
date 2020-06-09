package com.kshitij.labone.util;

public class Query {
    public static final String INSERT_SQL ="insert into user_account(accountnumber,user_name,balance)values(?,?,?)";
    public static final String READ_SQL ="select * from user_account";
    public static final String UPDATE_AFTER_WITHDRAW_DEPOSIT_SQL ="update user_account set balance =? where accountnumber=?";
    public static final String UPDATE_AFTER_DEPOSIT_SQL ="update user_account set balance =? where accountnumber=?";
    public static final String DELETE_SQL ="delete from user_account where accountnumber=?";

    //public static final String UPDATE_SQL ="update user_account set user_name= ?, age=? where id =?";
  //  public static final String DELETE_SQL ="delete from user_account where id=?";
}
