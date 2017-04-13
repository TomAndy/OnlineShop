package com.onlineshop.model;

public class Category {
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
