package com.onlineshop.utils;

import com.onlineshop.model.Category;
import com.onlineshop.model.User;
import com.onlineshop.service.CategoryServiceImpl;

import java.util.Scanner;

public class CategoryOperations {
    public static void operations(CategoryServiceImpl csi) {
        Scanner ss = new Scanner(System.in);
        boolean quit = false;
        int choice;

        while (!quit) {
            System.out.println("Select:");
            System.out.println("1 - Find category by id");
            System.out.println("2 - Create new category");
            System.out.println("3 - Update category");
            System.out.println("4 - Delete category by id");
            System.out.println("5 - Select all categories");
            System.out.println("0 - Exit");
            choice = Integer.parseInt(ss.next());

            switch(choice)
            {
                case 1:
                    Scanner s1= new Scanner(System.in);
                    System.out.println("Enter category id:");
                    int id = Integer.parseInt(s1.next());
                    System.out.println(csi.findById(id));
                    System.out.println("###################################");
                    break;
                case 2:
                    Scanner s2 = new Scanner(System.in);
                    System.out.println("Enter category id:");
                    int categoryId = Integer.parseInt(s2.next());
                    System.out.println("Enter category name:");
                    String categoryName = s2.next();
                    csi.saveCategory(new Category(categoryId, categoryName));
                    System.out.println("###################################");
                    break;
                case 3:
                    Scanner s3 = new Scanner(System.in);
                    System.out.println("Enter category id:");
                    int categoryIdUpdated = Integer.parseInt(s3.next());
                    System.out.println("Enter category name:");
                    String categoryNameUpdated = s3.next();
                    csi.updateCategory(new Category(categoryIdUpdated, categoryNameUpdated));
                    System.out.println("###################################");
                    break;
                case 4:
                    Scanner s4 = new Scanner(System.in);
                    System.out.println("Enter category id:");
                    int categoryIdToDelete = Integer.parseInt(s4.next());
                    csi.deleteCategoryById(categoryIdToDelete);
                    System.out.println("###################################");
                    break;
                case 5:
                    for(Category cat : csi.findAll()) {
                        System.out.println(cat);
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
