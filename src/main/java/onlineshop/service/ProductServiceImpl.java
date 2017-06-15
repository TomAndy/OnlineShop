package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.dao.ProductDao;
import onlineshop.model.Product;

import java.util.Collection;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao;

    @Override
    public Product findById(int productID) throws GenericException {
        return productDao.findById(productID);
    }

    @Override
    public boolean saveProduct(Product product) throws GenericException {
        return productDao.save(product);
    }

    @Override
    public boolean updateProduct(Product product) throws GenericException {
        return productDao.update(product);
    }

    @Override
    public boolean deleteProductById(int productID) throws GenericException {
        return productDao.deleteById(productID);
    }

    @Override
    public Collection<Product> findAll() throws GenericException {
        return productDao.findAll();
    }

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao=productDao;
    }
}
