package com.onlineshop.dao;

import com.onlineshop.Exceptions.GenericException;
import com.onlineshop.consts.ErrorCodes;
import com.onlineshop.model.Product;
import com.onlineshop.utils.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class ProductDao extends GenericDao <Product>{

    private String productTable = "Product";

    @Override
    public Collection <Product> findAll() throws GenericException {
        List<Product> productList = new ArrayList<Product>();

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(Product.FIND_ALL_QUERY);
            if(!rs.next()) {
                System.out.println("No products in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    int productId = Integer.valueOf(rs.getString("productId"));
                    String productName = String.valueOf(rs.getString("productName"));
                    double productPrice = Double.valueOf(rs.getString("productPrice"));
                    String productColor = String.valueOf(rs.getString("productColor"));
                    int categoryId = Integer.valueOf(rs.getString("categoryId"));
                    productList.add(new Product(productId, productName, productPrice, productColor, categoryId));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }

        return productList;
    }


    public Product findById(final int productID) throws GenericException {
        Product product = null;

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(String.format(Product.FIND_BY_ID_QUERY, Product.TABLE_NAME, productID));
            if(!rs.next()) {
                System.out.println("No such products in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    String productName = String.valueOf(rs.getString("productName"));
                    double productPrice = Double.valueOf(rs.getString("productPrice"));
                    String productColor = String.valueOf(rs.getString("productColor"));
                    int categoryId = Integer.valueOf(rs.getString("categoryId"));
                    product = new Product(productID, productName, productPrice, productColor, categoryId);
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return product;
    }


    public boolean save(final Product product) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Locale.ROOT,Product.SAVE_PRODUCT_QUERY, Product.TABLE_NAME,
                    product.getProductName(), product.getProductPrice(), product.getProductColor(), product.getCategoryId()));

            int rowsInserted = st.executeUpdate();
            if(rowsInserted>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No products were saved");
                st.close();
                return false;
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }


    public boolean update(final Product product) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Locale.ROOT, Product.UPDATE_PRODUCT_QUERY, Product.TABLE_NAME,
                    product.getProductName(), product.getProductPrice(), product.getProductColor(), product.getCategoryId(), product.getProductId()));
            int rowsUpdated = st.executeUpdate();
            if(rowsUpdated>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No products were updated");
                st.close();
                return false;
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }


    public boolean deleteById(final int productID) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Product.DELETE_PRODUCT_BY_ID_QUERY, Product.TABLE_NAME, productID));
            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No products were deleted");
                st.close();
                return false;
            }
        }
        catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_SQL_ERR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }
}
