package onlineshop.dao;

import onlineshop.Exceptions.GenericException;

import java.util.Collection;

public abstract class GenericDao <T> {
    public abstract Collection<T> findAll() throws GenericException;
    public abstract boolean save(T k) throws GenericException;
    public abstract T findById(int a) throws GenericException;
    public abstract boolean update(T k) throws GenericException;
    public abstract boolean deleteById(int id) throws GenericException;

}
