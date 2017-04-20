package com.onlineshop.service;

import com.onlineshop.Exceptions.GenericException;
import com.onlineshop.model.Product;

import java.util.Collection;

public interface ProductService {
    public Product findById(final int productID) throws GenericException;
    public boolean saveProduct(final Product product) throws GenericException;
    public boolean updateProduct(final Product product) throws GenericException;
    public boolean deleteProductById(final int productID) throws GenericException;
    public Collection findAll() throws GenericException;
}
