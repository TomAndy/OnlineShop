package com.onlineshop.utils;

import com.onlineshop.dao.CategoryDao;
import com.onlineshop.dao.ProductDao;
import com.onlineshop.dao.UserDao;
import com.onlineshop.service.CategoryServiceImpl;
import com.onlineshop.service.ProductServiceImpl;
import com.onlineshop.service.UserServiceImpl;

import java.sql.SQLException;

public class Testing {
    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDao();
        UserServiceImpl usi = new UserServiceImpl(userDao);
//        usi.updateUser(new User(2,"Linkoln","linko","linkoln@ukr.net"));
//        for(User user : usi.findAll()) {
//            System.out.println(user);
//        }

        CategoryDao categoryDao = new CategoryDao();
        CategoryServiceImpl csi = new CategoryServiceImpl(categoryDao);
        System.out.println(csi.findAll());

        ProductDao productDao = new ProductDao();
        ProductServiceImpl psi = new ProductServiceImpl(productDao);
        System.out.println(psi.findAll());

    }
}
