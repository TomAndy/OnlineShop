package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.model.Product;

import java.util.Collection;

public interface ProductService {
    public Product findById(final int productID) throws GenericException;
    public boolean saveProduct(final Product product) throws GenericException;
    public boolean updateProduct(final Product product) throws GenericException;
    public boolean deleteProductById(final int productID) throws GenericException;
    public Collection findAll() throws GenericException;
}
