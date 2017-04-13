package com.onlineshop.service;

import com.onlineshop.model.Product;

import java.util.Collection;

public interface ProductService {
    public Product findById(final int productID);
    public boolean saveProduct(final Product product);
    public boolean updateProduct(final Product product);
    public boolean deleteProductById(final int productID);
    public Collection<Product> findAll();
}
