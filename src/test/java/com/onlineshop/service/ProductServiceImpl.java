package com.onlineshop.service;

import com.onlineshop.dao.ProductDao;
import com.onlineshop.model.Product;

import java.util.Collection;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao;

    @Override
    public Product findById(int productID) {
        return productDao.findById(productID);
    }

    @Override
    public boolean saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public boolean deleteProductById(int productID) {
        return productDao.deleteProductById(productID);
    }

    @Override
    public Collection<Product> findAll() {
        return productDao.findAll();
    }

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao=productDao;
    }
}
