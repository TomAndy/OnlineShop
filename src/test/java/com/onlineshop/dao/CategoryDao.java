package com.onlineshop.dao;

import com.onlineshop.model.Category;
import com.onlineshop.utils.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryDao extends GenericDao {

    private String categoryTable = "Category";

    @Override
    public Collection<Category> findAll() {
        int categoryId;
        String categoryName;

        List<Category> categoryList = new ArrayList<Category>();

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from \"" + categoryTable + "\"");
            if(!rs.next()) {
                System.out.println("No categories in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    categoryId = Integer.valueOf(rs.getString("categoryId"));
                    categoryName = String.valueOf(rs.getString("categoryName"));
                    categoryList.add(new Category(categoryId, categoryName));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }


    public boolean saveCategory(final Category category) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "Insert into \"" + categoryTable + "\" values(" + category.getCategoryId() + ", '" + category.getCategoryName() + "');";
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

    public Category findById(final int categoryID) {
        String categoryName = "";

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from \"" + categoryTable + "\" where \"categoryId\" = " + categoryID);
            if(!rs.next()) {
                System.out.println("No such category in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    categoryName = String.valueOf(rs.getString("categoryName"));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Category(categoryID, categoryName);
    }

    public boolean updateCategory(final Category category){
        Connection conn = new ConnectToDb().getConnection();
        String query = "UPDATE \"" + categoryTable + "\"  SET \"categoryName\"='" + category.getCategoryName() + "'  where \"categoryId\"=" + category.getCategoryId();

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

    public boolean deleteCategoryById(final int categoryID) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "delete from \"" + categoryTable + "\" where \"categoryId\" = " + categoryID;
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
