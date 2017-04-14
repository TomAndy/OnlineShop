package com.onlineshop.dao;

import java.util.Collection;

public abstract class GenericDao <T> {
    public abstract Collection <T> findAll();

}
