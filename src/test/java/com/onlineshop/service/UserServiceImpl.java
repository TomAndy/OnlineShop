package com.onlineshop.service;

import com.onlineshop.Exceptions.GenericException;
import com.onlineshop.dao.UserDao;
import com.onlineshop.model.User;

import java.util.Collection;

public class UserServiceImpl implements UserService{

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(int userID) throws GenericException {
        return userDao.findById(userID);
    }

    @Override
    public boolean saveUser(User user) throws GenericException {
        return userDao.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) throws GenericException {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUserById(int userID) throws GenericException {
        return userDao.deleteUserById(userID);
    }

    @Override
    public Collection<User> findAll() throws GenericException {
        return userDao.findAll();
    }
}
