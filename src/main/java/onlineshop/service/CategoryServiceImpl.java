package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.dao.CategoryDao;
import onlineshop.model.Category;

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
        return categoryDao.save(category);
    }

    @Override
    public boolean updateCategory(Category category) throws GenericException {
        return categoryDao.update(category);
    }

    @Override
    public boolean deleteCategoryById(int categoryID) throws GenericException {
        return categoryDao.deleteById(categoryID);
    }

    @Override
    public Collection<Category> findAll() throws GenericException {
        return categoryDao.findAll();
    }
}
