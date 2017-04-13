package com.onlineshop.service;

import com.onlineshop.model.User;

import java.util.Collection;

public interface UserService {
    public User findById(final int userID);
    public boolean saveUser(final User user);
    public boolean updateUser(final User user);
    public boolean deleteUserById(final int userID);
    public Collection<User> findAll();

}
