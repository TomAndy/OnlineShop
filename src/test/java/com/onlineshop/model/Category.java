package com.onlineshop.model;

public class Category {
    public static final String TABLE_NAME = "\"Category\"";
    public static final String FIND_ALL_QUERY = String.format("select * from %s",TABLE_NAME);
    public static final String SAVE_CATEGORY_QUERY = "Insert into %s values(%d, '%s');";
    public static final String FIND_BY_ID_QUERY = "select * from %s where \"categoryId\" = %d";
    public static final String DELETE_CATEGORY_BY_ID_QUERY = "delete from %s where \"categoryId\" = %d";
    public static final String UPDATE_CATEGORY_QUERY = "UPDATE %s  SET \"categoryName\"='%s' where \"categoryId\"=%d";

    private int categoryId;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String toString() {
        return "categoryId: " + this.getCategoryId() + "; categoryName: " + this.getCategoryName();
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }
}
