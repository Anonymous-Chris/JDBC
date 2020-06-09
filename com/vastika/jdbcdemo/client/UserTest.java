package com.vastika.jdbcdemo.client;

import com.vastika.jdbcdemo.dao.UserDao;
import com.vastika.jdbcdemo.dao.UserDaoImpl;
import com.vastika.jdbcdemo.model.User;

import java.util.List;
import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        User user = new User();
        Scanner input = new Scanner(System.in);




        String decision="";
        do {
            System.out.println("Which db operation do you want to perform");
            String choice = input.next();
            switch(choice){
                case "save":
                    System.out.println("Enter user id");
                    int id = input.nextInt();
                    System.out.println("Enter user name");
                    String name = input.next();

                    System.out.println("Enter age");
                    int age = input.nextInt();

                    user.setId(id);
                    user.setUserName(name);
                    user.setAge(age);
                    userDao.saveUserInfo(user);
                    break;

                case "list":
                    List<User> userList = userDao.getAllUserInfo();
                    userList.forEach(u-> {
                        System.out.println("User Id is " + u.getId());
                        System.out.println("User Name is " + u.getUserName());
                        System.out.println("User age is " + u.getAge());

                    });
                    break;

                case "update":

                    System.out.println("Enter user name");
                     name = input.next();

                    System.out.println("Enter age");
                     age = input.nextInt();
                    System.out.println("Enter user id");
                     id = input.nextInt();
                    user.setId(id);
                    user.setUserName(name);
                    user.setAge(age);
                    userDao.updateUserInfo(user);

                    break;

                case "delete":
                    System.out.println("Enter id to delete");
                    id = input.nextInt();
                    user.setId(id);
                    int saved=userDao.deleteUserInfo(user);
                    if(saved>=1){
                        System.out.println("User data is deleted");
                    }else{
                        System.out.println("Error in database");
                    }
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println("Do you want to perform next operation? Enter 'yes' or 'no'");
            decision=input.next();
        } while (decision.equalsIgnoreCase("yes"));
        System.out.println("Thank you...visit next time");

    }
}
