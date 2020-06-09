package com.vastika.jdbcdemo.util;

public class QueryUtil {
    public static final String INSERT_SQL ="insert into user_tbl(id,user_name,age)values(?,?,?)";
    public static final String LIST_SQL ="select * from user_tbl";
    public static final String UPDATE_SQL ="update user_tbl set user_name= ?, age=? where id =?";
    public static final String DELETE_SQL ="delete from user_tbl where id=?";
}
