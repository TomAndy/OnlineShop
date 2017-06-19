package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.dao.CategoryDao;
import onlineshop.model.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Collections;

public class CategoryServiceImplTest {

    private CategoryServiceImpl unit;

    private CategoryDao categoryDaoMock;

    @Before
    public void setup() {
        categoryDaoMock = Mockito.mock(CategoryDao.class);

        unit = new CategoryServiceImpl(categoryDaoMock);
    }


    @Test
    public void findById() throws GenericException {
        int categoryId=1;
        Category categoryDB = new Category(categoryId, null);

        Mockito.when(categoryDaoMock.findById(categoryId)).thenReturn(categoryDB);

        Category category = unit.findById(categoryId);

        Assert.assertEquals(1, category.getCategoryId());

        Mockito.verify(categoryDaoMock, Mockito.times(1)).findById(categoryId);
        Mockito.verifyNoMoreInteractions(categoryDaoMock);
    }


    @Test
    public void saveCategoryTest() throws GenericException {
        Category categoryDB = new Category(1, null);

        Mockito.when(categoryDaoMock.save(categoryDB)).thenReturn(true);

        boolean res = unit.saveCategory(categoryDB);

        Assert.assertTrue(res);

        Mockito.verify(categoryDaoMock, Mockito.times(1)).save(categoryDB);
        Mockito.verifyNoMoreInteractions(categoryDaoMock);
    }


    @Test
    public void updateCategoryTest() throws GenericException {
        Category categoryDB = new Category(1, null);

        Mockito.when(categoryDaoMock.update(categoryDB)).thenReturn(true);

        boolean res = unit.updateCategory(categoryDB);

        Assert.assertTrue(res);

        Mockito.verify(categoryDaoMock, Mockito.times(1)).update(categoryDB);
        Mockito.verifyNoMoreInteractions(categoryDaoMock);
    }


    @Test
    public void deleteCategoryByIdTest() throws GenericException {
        int categoryId=1;

        Mockito.when(categoryDaoMock.deleteById(categoryId)).thenReturn(true);

        boolean res = unit.deleteCategoryById(categoryId);

        Assert.assertTrue(res);

        Mockito.verify(categoryDaoMock, Mockito.times(1)).deleteById(categoryId);
        Mockito.verifyNoMoreInteractions(categoryDaoMock);
    }


    @Test
    public void findAllTest() throws GenericException {
        Mockito.when(categoryDaoMock.findAll()).thenReturn(Collections.EMPTY_LIST);

        Collection res = unit.findAll();

        Assert.assertNotNull(res);

        Mockito.verify(categoryDaoMock, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(categoryDaoMock);
    }


}
