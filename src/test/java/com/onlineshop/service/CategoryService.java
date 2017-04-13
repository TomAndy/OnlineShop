package com.onlineshop.service;

import com.onlineshop.model.Category;

import java.util.Collection;

public interface CategoryService {
    public Category findById(final int categoryID);
    public boolean saveCategory(final Category category);
    public boolean updateCategory(final Category category);
    public boolean deleteCategoryById(final int categoryID);
    public Collection<Category> findAll();
}
