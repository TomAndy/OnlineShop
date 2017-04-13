package com.onlineshop.service;

import com.onlineshop.dao.CategoryDao;
import com.onlineshop.model.Category;

import java.util.Collection;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {this.categoryDao=categoryDao;}

    @Override
    public Category findById(int categoryID) {
        return categoryDao.findById(categoryID);
    }

    @Override
    public boolean saveCategory(Category category) {
        return categoryDao.saveCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    @Override
    public boolean deleteCategoryById(int categoryID) {
        return categoryDao.deleteCategoryById(categoryID);
    }

    @Override
    public Collection<Category> findAll() {
        return categoryDao.findAll();
    }
}
