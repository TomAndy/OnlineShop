package com.onlineshop.model;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String productColor;
    private int categoryId;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String toString() {
        return "productId: " + this.getProductId() + "; productName: " + this.getProductName()+ "; productPrice: " + this.getProductPrice() + "; productColor: "
                + this.getProductColor()+ "; categoryId: " + this.getCategoryId();
    }

    public Product(int productId, String productName, double productPrice, String productColor, int categoryId) {
        this.productId=productId;
        this.productName=productName;
        this.productPrice=productPrice;
        this.productColor=productColor;
        this.categoryId=categoryId;
    }
}
