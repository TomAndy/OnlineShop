package com.onlineshop.service;

import com.onlineshop.Exceptions.GenericException;
import com.onlineshop.dao.CategoryDao;
import com.onlineshop.model.Category;

import java.util.Collection;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {this.categoryDao=categoryDao;}

    @Override
    public Category findById(int categoryID) throws GenericException {
        return categoryDao.findById(categoryID);
    }

    @Override
    public boolean saveCategory(Category category) throws GenericException {
        return categoryDao.saveCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) throws GenericException {
        return categoryDao.updateCategory(category);
    }

    @Override
    public boolean deleteCategoryById(int categoryID) throws GenericException {
        return categoryDao.deleteCategoryById(categoryID);
    }

    @Override
    public Collection<Category> findAll() throws GenericException {
        return categoryDao.findAll();
    }
}
