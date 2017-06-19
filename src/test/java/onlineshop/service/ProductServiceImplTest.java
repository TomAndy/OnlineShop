package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.dao.ProductDao;
import onlineshop.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Collections;

public class ProductServiceImplTest {

    private ProductServiceImpl unit;

    private ProductDao productDaoMock;

    @Before
    public void setup() {
        productDaoMock = Mockito.mock(ProductDao.class);
        unit = new ProductServiceImpl(productDaoMock);
    }

    @Test
    public void findById() throws GenericException {
        int productId=1;
        Product productDB = new Product(productId, null, 0, null, 0);

        Mockito.when(productDaoMock.findById(productId)).thenReturn(productDB);

        Product product = unit.findById(productId);

        Assert.assertEquals(1, product.getProductId());

        Mockito.verify(productDaoMock, Mockito.times(1)).findById(productId);
        Mockito.verifyNoMoreInteractions(productDaoMock);
    }


    @Test
    public void saveProductTest() throws GenericException {
        Product productDB = new Product(1, null, 0, null, 0);

        Mockito.when(productDaoMock.save(productDB)).thenReturn(true);

        boolean res = unit.saveProduct(productDB);

        Assert.assertTrue(res);

        Mockito.verify(productDaoMock, Mockito.times(1)).save(productDB);
        Mockito.verifyNoMoreInteractions(productDaoMock);
    }


    @Test
    public void updateProductTest() throws GenericException {
        Product productDB = new Product(1, null, 0, null, 0);

        Mockito.when(productDaoMock.update(productDB)).thenReturn(true);

        boolean res = unit.updateProduct(productDB);

        Assert.assertTrue(res);

        Mockito.verify(productDaoMock, Mockito.times(1)).update(productDB);
        Mockito.verifyNoMoreInteractions(productDaoMock);
    }


    @Test
    public void deleteProductByIdTest() throws GenericException {
        int productId=1;

        Mockito.when(productDaoMock.deleteById(productId)).thenReturn(true);

        boolean res = unit.deleteProductById(productId);

        Assert.assertTrue(res);

        Mockito.verify(productDaoMock, Mockito.times(1)).deleteById(productId);
        Mockito.verifyNoMoreInteractions(productDaoMock);
    }


    @Test
    public void findAllTest() throws GenericException {
        Mockito.when(productDaoMock.findAll()).thenReturn(Collections.EMPTY_LIST);

        Collection res = unit.findAll();

        Assert.assertNotNull(res);

        Mockito.verify(productDaoMock, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(productDaoMock);
    }




}
