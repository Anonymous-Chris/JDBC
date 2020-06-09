package com.kshitij.labone.client;

import com.kshitij.labone.dao.UserAccountDao;
import com.kshitij.labone.dao.UserAccountDaoImpl;
import com.kshitij.labone.model.UserAccount;

import java.util.List;
import java.util.Scanner;

public class UserAccountTest {
    public static void main(String[] args) {
        UserAccountDao userAccountDao = new UserAccountDaoImpl();

        UserAccount userAccount = new UserAccount();
        Scanner input = new Scanner(System.in);
        String decision = "";

        do {
            System.out.println("Enter the choice? Choose ' create' ,'read ', 'withdraw ' ,'deposit ', 'delete'");
            String choice = input.next();
            switch (choice){
                case "create":
                    System.out.println("Enter account number");
                    int id = input.nextInt();
                    userAccount.setAccountnumber(id);
                    System.out.println("Enter your name");
                    String name = input.next();
                    System.out.println("Enter the balance you would like to deposit");
                    double balance =input.nextDouble();


                    userAccount.setBalance(balance);
                    userAccount.setUsername(name);
                    userAccountDao.createuserAccountInfo(userAccount);
                    break;

                case "read":
                    List<UserAccount> userList = userAccountDao.allaccount();
                    userList.forEach(u-> {
                        System.out.println("User account number is " + u.getAccountnumber());
                        System.out.println("User Name is " + u.getUsername());
                        System.out.println("User balance is " + u.getBalance());
                        System.out.println();
                    });
                    break;

                case "withdraw":

                    System.out.println("Enter the account number");
                    int account_Number = input.nextInt();

                    List<UserAccount> userList1 = userAccountDao.allaccount();

                    userList1.forEach(u-> {
                        if (account_Number==u.getAccountnumber()) {
                            System.out.println("User account number is " + u.getAccountnumber());
                            System.out.println("User Name is " + u.getUsername());
                            System.out.println("User balance is " + u.getBalance());
                            System.out.println();

                            System.out.println("Enter the balance you would like to withdraw?");
                            double withdrawBalance=input.nextDouble();

                            double newBalance =u.getBalance()-withdrawBalance;

                            userAccount.setBalance(newBalance);
                            userAccount.setAccountnumber(account_Number);
                            userAccountDao.withdraw_deposit_Balance(userAccount);


                        }
                    });

                    List<UserAccount> userList2 = userAccountDao.allaccount();
                    userList2.forEach(v-> {
                        if (account_Number == v.getAccountnumber()) {
                            System.out.println("User account number is " + v.getAccountnumber());
                            System.out.println("User Name is " + v.getUsername());
                            System.out.println("User balance is " + v.getBalance());
                            System.out.println();
                        }
                    });
                    break;

                case "deposit":
                    System.out.println("Enter the account number");
                    int account_Number1 = input.nextInt();

                    List<UserAccount> userList3 = userAccountDao.allaccount();

                    userList3.forEach(u1-> {
                        if (account_Number1==u1.getAccountnumber()) {
                            System.out.println("User account number is " + u1.getAccountnumber());
                            System.out.println("User Name is " + u1.getUsername());
                            System.out.println("User balance is " + u1.getBalance());
                            System.out.println();

                            System.out.println("Enter the balance you would like to deposit?");
                            double withdrawBalance1=input.nextDouble();

                            double newBalance1 =u1.getBalance()+withdrawBalance1;

                            userAccount.setBalance(newBalance1);
                            userAccount.setAccountnumber(account_Number1);
                            userAccountDao.withdraw_deposit_Balance(userAccount);




                        }
                    });

                    List<UserAccount> userList4 = userAccountDao.allaccount();
                    userList4.forEach(v1-> {
                        if (account_Number1 == v1.getAccountnumber()) {
                            System.out.println("User account number is " + v1.getAccountnumber());
                            System.out.println("User Name is " + v1.getUsername());
                            System.out.println("User balance is " + v1.getBalance());
                            System.out.println();
                        }
                    });
                    break;
                case "delete":
                    System.out.println("Enter account number to delete");
                    id = input.nextInt();
                    userAccount.setAccountnumber(id);
                   userAccountDao.deleteAccount(userAccount);
                    break;
                default:
                    System.out.println("Wrong input");
            }

            System.out.println("Do you like to continue! Enter 'yes' or 'no'");
            decision=input.next();
        }while (decision.equalsIgnoreCase("yes"));
    }
}
