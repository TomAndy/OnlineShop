package com.onlineshop.utils;

import com.onlineshop.Exceptions.GenericException;
import com.onlineshop.model.Product;
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

            try {
                choice = Integer.parseInt(ss.next());

                switch(choice)
                {
                    case 1:
                        Scanner s1= new Scanner(System.in);
                        System.out.println("Enter product id:");
                        int id = Integer.parseInt(s1.next());
                        try {
                            System.out.println(psi.findById(id));
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 2:
                        Scanner s2 = new Scanner(System.in);
                        System.out.println("Enter product name:");
                        String productName = s2.nextLine();
                        System.out.println("Enter product price:");
                        double price = Double.parseDouble(s2.next());
                        System.out.println("Enter product color:");
                        String color = s2.next();
                        System.out.println("Enter product category id");
                        int categoryId = Integer.parseInt(s2.next());
                        try {
                            psi.saveProduct(new Product(productName, price, color, categoryId));
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 3:
                        Scanner s3 = new Scanner(System.in);
                        System.out.println("Enter product id:");
                        int productUpdateId = Integer.parseInt(s3.nextLine());
                        System.out.println("Enter product name:");
                        String productUpdateName = s3.nextLine();
                        System.out.println("Enter product price:");
                        double priceUpdate = Double.parseDouble(s3.next());
                        System.out.println("Enter product color:");
                        String colorUpdate = s3.next();
                        System.out.println("Enter product category id");
                        int categoryUpdateId = Integer.parseInt(s3.next());
                        try {
                            psi.updateProduct(new Product(productUpdateId, productUpdateName, priceUpdate, colorUpdate, categoryUpdateId));
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 4:
                        Scanner s4 = new Scanner(System.in);
                        System.out.println("Enter product id:");
                        int productIdToDelete = Integer.parseInt(s4.next());
                        try {
                            psi.deleteProductById(productIdToDelete);
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 5:
                        try {
                            for(Product prod : psi.findAll()) {
                                System.out.println(prod);
                            }
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
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
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
        }
    }
}
