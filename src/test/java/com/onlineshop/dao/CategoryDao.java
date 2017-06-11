package com.onlineshop.dao;

import com.onlineshop.Exceptions.GenericException;
import com.onlineshop.consts.ErrorCodes;
import com.onlineshop.model.Category;
import com.onlineshop.utils.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryDao extends GenericDao {

    private String categoryTable = "Category";

    @Override
    public Collection<Category> findAll() throws GenericException {
        List<Category> categoryList = new ArrayList<Category>();
        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(Category.FIND_ALL_QUERY);
            if(!rs.next()) {
                System.out.println("No categories in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    int categoryId = Integer.valueOf(rs.getString("categoryId"));
                    String categoryName = String.valueOf(rs.getString("categoryName"));
                    categoryList.add(new Category(categoryId, categoryName));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return categoryList;
    }


    public boolean saveCategory(final Category category) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Category.SAVE_CATEGORY_QUERY, Category.TABLE_NAME,
                    category.getCategoryId(), category.getCategoryName()));
            int rowsInserted = st.executeUpdate();
            if(rowsInserted>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No categories were saved");
                st.close();
                return false;
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    public Category findById(final int categoryID) throws GenericException {
        String categoryName = "";

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(String.format(Category.FIND_BY_ID_QUERY, Category.TABLE_NAME, categoryID));
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
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return new Category(categoryID, categoryName);
    }


    public boolean updateCategory(final Category category) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Category.UPDATE_CATEGORY_QUERY, Category.TABLE_NAME,
                    category.getCategoryName(), category.getCategoryId()));

            int rowsUpdated = st.executeUpdate();
            if(rowsUpdated>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No categories were updated");
                st.close();
                return false;
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    public boolean deleteCategoryById(final int categoryID) throws GenericException {
        Connection conn = new ConnectToDb().getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(Category.DELETE_CATEGORY_BY_ID_QUERY,
                    Category.TABLE_NAME, categoryID));

            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted>=1) {
                st.close();
                return true;
            }
            else {
                System.out.println("No categories were deleted");
                st.close();
                return false;
            }
        }
        catch (SQLException e) {
//            e.printStackTrace();
            throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

}
