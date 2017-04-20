package com.onlineshop.dao;

import com.onlineshop.Exceptions.GenericException;

import java.util.Collection;

public abstract class GenericDao <T> {
    public abstract Collection <T> findAll() throws GenericException;

}
