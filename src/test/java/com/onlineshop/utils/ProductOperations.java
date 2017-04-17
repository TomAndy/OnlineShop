package com.onlineshop.utils;

import com.onlineshop.model.Product;
import com.onlineshop.model.User;
import com.onlineshop.service.ProductServiceImpl;

import java.util.Scanner;

public class ProductOperations {
    public static void operations (ProductServiceImpl psi) {
        Scanner ss = new Scanner(System.in);
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("Select:");
            System.out.println("1 - Find product by id");
            System.out.println("2 - Create new product");
            System.out.println("3 - Update product");
            System.out.println("4 - Delete product by id");
            System.out.println("5 - Select all product");
            System.out.println("0 - Exit");
            choice = Integer.parseInt(ss.next());

            switch(choice)
            {
                case 1:
                    Scanner s1= new Scanner(System.in);
                    System.out.println("Enter product id:");
                    int id = Integer.parseInt(s1.next());
                    System.out.println(psi.findById(id));
                    System.out.println("###################################");
                    break;
                case 2:
                    Scanner s2 = new Scanner(System.in);
                    System.out.println("Enter product id:");
                    int productId = Integer.parseInt(s2.next());
                    System.out.println("Enter product name:");
                    String productName = s2.next();
                    System.out.println("Enter product price:");
                    double price = Double.parseDouble(s2.next());
                    System.out.println("Enter product color:");
                    String color = s2.next();
                    System.out.println("Enter product category id");
                    int categoryId = Integer.parseInt(s2.next());
                    psi.saveProduct(new Product(productId, productName, price, color, categoryId));
                    System.out.println("###################################");
                    break;
                case 3:
                    Scanner s3 = new Scanner(System.in);
                    System.out.println("Enter product id:");
                    int productUpdateId = Integer.parseInt(s3.next());
                    System.out.println("Enter product name:");
                    String productUpdateName = s3.next();
                    System.out.println("Enter product price:");
                    double priceUpdate = Double.parseDouble(s3.next());
                    System.out.println("Enter product color:");
                    String colorUpdate = s3.next();
                    System.out.println("Enter product category id");
                    int categoryUpdateId = Integer.parseInt(s3.next());
                    psi.updateProduct(new Product(productUpdateId, productUpdateName, priceUpdate, colorUpdate, categoryUpdateId));
                    System.out.println("###################################");
                    break;
                case 4:
                    Scanner s4 = new Scanner(System.in);
                    System.out.println("Enter product id:");
                    int productIdToDelete = Integer.parseInt(s4.next());
                    psi.deleteProductById(productIdToDelete);
                    System.out.println("###################################");
                    break;
                case 5:
                    for(Product prod : psi.findAll()) {
                        System.out.println(prod);
                    }
                    System.out.println("###################################");
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }
}
