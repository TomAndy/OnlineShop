package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.model.User;

import java.util.Collection;

public interface UserService {
    public User findById(final int userID) throws GenericException;
    public boolean saveUser(final User user) throws GenericException;
    public boolean updateUser(final User user) throws GenericException;
    public boolean deleteUserById(final int userID) throws GenericException;
    public Collection<User> findAll() throws GenericException;

}
