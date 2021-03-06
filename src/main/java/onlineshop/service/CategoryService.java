package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.model.Category;

import java.util.Collection;

public interface CategoryService {
    public Category findById(final int categoryID) throws GenericException;
    public boolean saveCategory(final Category category) throws GenericException;
    public boolean updateCategory(final Category category) throws GenericException;
    public boolean deleteCategoryById(final int categoryID) throws GenericException;
    public Collection<Category> findAll() throws GenericException;
}
