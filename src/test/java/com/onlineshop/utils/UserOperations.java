package com.onlineshop.utils;

import com.onlineshop.model.User;
import com.onlineshop.service.UserServiceImpl;

import java.util.Scanner;

public class UserOperations {
    public static void operations(UserServiceImpl usi) {
        Scanner ss = new Scanner(System.in);
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("Select:");
            System.out.println("1 - Find user by id");
            System.out.println("2 - Create new user");
            System.out.println("3 - Update user");
            System.out.println("4 - Delete user by id");
            System.out.println("5 - Select all users");
            System.out.println("0 - Exit");
            choice = Integer.parseInt(ss.next());

            switch(choice)
            {
                case 1:
                    Scanner s1= new Scanner(System.in);
                    System.out.println("Enter user id:");
                    int id = Integer.parseInt(s1.next());
                    System.out.println(usi.findById(id));
                    System.out.println("###################################");
                    break;
                case 2:
                    Scanner s2 = new Scanner(System.in);
                    System.out.println("Enter user id:");
                    int userId = Integer.parseInt(s2.next());
                    System.out.println("Enter user name:");
                    String userName = s2.next();
                    System.out.println("Enter user login:");
                    String login = s2.next();
                    System.out.println("Enter user email:");
                    String email = s2.next();
                    usi.saveUser(new User(userId, userName, login, email));
                    System.out.println("###################################");
                    break;
                case 3:
                    Scanner s3 = new Scanner(System.in);
                    System.out.println("Enter user id:");
                    int userIdUpdated = Integer.parseInt(s3.next());
                    System.out.println("Enter user name:");
                    String userNameUpdated = s3.next();
                    System.out.println("Enter user login:");
                    String loginUpdated = s3.next();
                    System.out.println("Enter user email:");
                    String emailUpdated = s3.next();
                    usi.updateUser(new User(userIdUpdated, userNameUpdated, loginUpdated, emailUpdated));
                    System.out.println("###################################");
                    break;
                case 4:
                    Scanner s4 = new Scanner(System.in);
                    System.out.println("Enter user id:");
                    int userIdToDelete = Integer.parseInt(s4.next());
                    usi.deleteUserById(userIdToDelete);
                    System.out.println("###################################");
                    break;
                case 5:
                    for(User user : usi.findAll()) {
                        System.out.println(user);
                    }
                    System.out.println("###################################");
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }
}