import onlineshop.dao.CategoryDao;
import onlineshop.dao.ProductDao;
import onlineshop.dao.UserDao;
import onlineshop.service.CategoryServiceImpl;
import onlineshop.service.ProductServiceImpl;
import onlineshop.service.UserServiceImpl;
import onlineshop.utils.CategoryOperations;
import onlineshop.utils.ProductOperations;
import onlineshop.utils.UserOperations;

import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        UserServiceImpl usi = new UserServiceImpl(userDao);
        CategoryDao categoryDao = new CategoryDao();
        CategoryServiceImpl csi = new CategoryServiceImpl(categoryDao);
        ProductDao productDao = new ProductDao();
        ProductServiceImpl psi = new ProductServiceImpl(productDao);

        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        int choice;

        while(!quit) {
            System.out.println("Select:");
            System.out.println("1 - User");
            System.out.println("2 - Category");
            System.out.println("3 - Product");
            System.out.println("0 - Exit");
            try {
                choice = Integer.parseInt(sc.next());
                switch (choice) {
                    case 1:
                        UserOperations.operations(usi);
                        System.out.println("==================================");
                        break;
                    case 2:
                        CategoryOperations.operations(csi);
                        System.out.println("==================================");
                        break;
                    case 3:
                        ProductOperations.operations(psi);
                        System.out.println("==================================");
                        break;
                    case 0:
                        quit = true;
                        break;
                    default:
                        quit = true;
                        break;
                }
            }catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
        }
    }
}
