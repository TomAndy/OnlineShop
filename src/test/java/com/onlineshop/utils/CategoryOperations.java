package com.onlineshop.utils;

import com.onlineshop.Exceptions.GenericException;
import com.onlineshop.model.Category;
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

            try {
                choice = Integer.parseInt(ss.next());

                switch(choice)
                {
                    case 1:
                        Scanner s1= new Scanner(System.in);
                        System.out.println("Enter category id:");
                        int id = Integer.parseInt(s1.next());
                        try {
                            System.out.println(csi.findById(id));
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 2:
                        Scanner s2 = new Scanner(System.in);
                        System.out.println("Enter category name:");
                        String categoryName = s2.nextLine();
                        try {
                            csi.saveCategory(new Category(categoryName));
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 3:
                        Scanner s3 = new Scanner(System.in);
                        System.out.println("Enter category id:");
                        int categoryIdUpdated = Integer.parseInt(s3.nextLine());
                        System.out.println("Enter category name:");
                        String categoryNameUpdated = s3.nextLine();
                        try {
                            csi.updateCategory(new Category(categoryIdUpdated, categoryNameUpdated));
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 4:
                        Scanner s4 = new Scanner(System.in);
                        System.out.println("Enter category id:");
                        int categoryIdToDelete = Integer.parseInt(s4.next());
                        try {
                            csi.deleteCategoryById(categoryIdToDelete);
                        } catch (GenericException e) {
                            System.out.println(MessageHelper.getMessageByCode(e.getErrorCode()));
                        }
                        System.out.println("###################################");
                        break;
                    case 5:
                        try {
                            System.out.println("=================================");
                            for(Category cat : csi.findAll()) {
                                System.out.println(cat);
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
