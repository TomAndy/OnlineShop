import com.onlineshop.dao.CategoryDao;
import com.onlineshop.dao.ProductDao;
import com.onlineshop.dao.UserDao;
import com.onlineshop.service.CategoryServiceImpl;
import com.onlineshop.service.ProductServiceImpl;
import com.onlineshop.service.UserServiceImpl;

import java.sql.SQLException;

public class Testing {
    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDao();
        UserServiceImpl usi = new UserServiceImpl(userDao);
//        usi.updateUser(new User(2,"Linkoln","linko","linkoln@ukr.net"));
//        try {
//            for(User user : usi.findAll()) {
//                System.out.println(user);
//            }
//        } catch (MyNewException e) {
//            // Get error message proper to error code obtained from MyNewException
//            System.out.println("");
//        }

//        System.out.println(usi.updateUser(new User(2,"Linkoln123","linko1","linkoln1@ukr.net1")));




        CategoryDao categoryDao = new CategoryDao();
        CategoryServiceImpl csi = new CategoryServiceImpl(categoryDao);
//        csi.saveCategory(new Category(3,"err"));
//        System.out.println(csi.findAll());
//        System.out.println(csi.updateCategory(new Category(2, "games")));


        ProductDao productDao = new ProductDao();
        ProductServiceImpl psi = new ProductServiceImpl(productDao);
        System.out.println(psi.deleteProductById(5));

    }
}
