package onlineshop.service;

import onlineshop.Exceptions.GenericException;
import onlineshop.dao.UserDao;
import onlineshop.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Collections;

public class UserServiceImplTest {

    private UserServiceImpl unit;

    private UserDao userDaoMock;

    @Before
    public void setup() {
        userDaoMock = Mockito.mock(UserDao.class);
        unit = new UserServiceImpl(userDaoMock);

    }


    @Test
    public void findByIdTest() throws GenericException {
        int userId=1;
        User userDB = new User(userId, null, null, null);

        Mockito.when(userDaoMock.findById(userId)).thenReturn(userDB);

        User user = unit.findById(userId);

        Assert.assertEquals(1, user.getUserId());

        Mockito.verify(userDaoMock, Mockito.times(1)).findById(userId);
        Mockito.verifyNoMoreInteractions(userDaoMock);
    }


    @Test
    public void saveUserTest() throws GenericException {
        User userDB = new User(1, null, null, null);

        Mockito.when(userDaoMock.save(userDB)).thenReturn(true);

        boolean res = unit.saveUser(userDB);

        Assert.assertTrue(res);

        Mockito.verify(userDaoMock, Mockito.times(1)).save(userDB);
        Mockito.verifyNoMoreInteractions(userDaoMock);
    }


    @Test
    public void saveUserTest_Negative() throws GenericException {
        User userDB = new User(1, null, null, null);

        Mockito.when(userDaoMock.save(userDB)).thenReturn(false);

        boolean res = unit.saveUser(userDB);

        Assert.assertFalse(res);

        Mockito.verify(userDaoMock, Mockito.times(1)).save(userDB);
        Mockito.verifyNoMoreInteractions(userDaoMock);
    }


    @Test
    public void updateUserTest() throws GenericException {
        User userDB = new User(1, null, null, null);

        Mockito.when(userDaoMock.update(userDB)).thenReturn(true);

        boolean res = unit.updateUser(userDB);

        Assert.assertTrue(res);

        Mockito.verify(userDaoMock, Mockito.times(1)).update(userDB);
        Mockito.verifyNoMoreInteractions(userDaoMock);
    }


    @Test
    public void deleteUserByIdTest() throws GenericException {
        int userId=1;

        Mockito.when(userDaoMock.deleteById(userId)).thenReturn(true);

        boolean res = unit.deleteUserById(userId);

        Assert.assertTrue(res);

        Mockito.verify(userDaoMock, Mockito.times(1)).deleteById(userId);
        Mockito.verifyNoMoreInteractions(userDaoMock);
    }


    @Test
    public void findAllTest() throws GenericException {

        Mockito.when(userDaoMock.findAll()).thenReturn(Collections.EMPTY_LIST);

        Collection res = unit.findAll();

        Assert.assertNotNull(res);

        Mockito.verify(userDaoMock, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(userDaoMock);
    }


}
