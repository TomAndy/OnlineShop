package com.onlineshop.dao;

import com.onlineshop.model.Product;
import com.onlineshop.utils.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductDao extends GenericDao{

    private String productTable = "Product";

    @Override
    public Collection findAll() {
        int productId = 0;
        String productName = "";
        double productPrice = 0;
        String productColor = "";
        int categoryId = 0;
        List<Product> productList = new ArrayList<Product>();

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from \"" + productTable + "\"");
            if(!rs.next()) {
                System.out.println("No products in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    productId = Integer.valueOf(rs.getString("productId"));
                    productName = String.valueOf(rs.getString("productName"));
                    productPrice = Double.valueOf(rs.getString("productPrice"));
                    productColor = String.valueOf(rs.getString("productColor"));
                    categoryId = Integer.valueOf(rs.getString("categoryId"));
                    productList.add(new Product(productId, productName, productPrice, productColor, categoryId));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public Product findById(final int productID) {
        String productName = "";
        double productPrice = 0;
        String productColor = "";
        int categoryId = 0;

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from \"" + productTable + "\" where \"productId\" = " + productID);
            if(!rs.next()) {
                System.out.println("No such products in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    productName = String.valueOf(rs.getString("productName"));
                    productPrice = Double.valueOf(rs.getString("productPrice"));
                    productColor = String.valueOf(rs.getString("productColor"));
                    categoryId = Integer.valueOf(rs.getString("categoryId"));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Product(productID, productName, productPrice, productColor, categoryId);
    }
    public boolean saveProduct(final Product product) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "Insert into \"" + productTable + "\" values(" + product.getProductId() + ", '" + product.getProductName() +
                "', '" + product.getProductPrice() + "', '" + product.getProductColor() + "', '" + product.getCategoryId() + "');";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            int rowsInserted = st.executeUpdate();
            if(rowsInserted>=1) {
                st.close();
                return true;
            }
            else {
                st.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateProduct(final Product product) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "UPDATE \"" + productTable + "\"  SET \"productName\"='" + product.getProductName() + "', \"productPrice\"='" + product.getProductPrice() +
                "', \"productColor\"='" + product.getProductColor() + "', \"categoryId\"='" + product.getCategoryId() +"'  where \"productId\"=" + product.getProductId();

        try {
            PreparedStatement st = conn.prepareStatement(query);
            int rowsUpdated = st.executeUpdate();
            if(rowsUpdated>=1) {
                st.close();
                return true;
            }
            else {
                st.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProductById(final int productID) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "delete from \"" + productTable + "\" where \"productId\" = " + productID;
        try {
            PreparedStatement st = conn.prepareStatement(query);
            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted>=1) {
                st.close();
                return true;
            }
            else {
                st.close();
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
