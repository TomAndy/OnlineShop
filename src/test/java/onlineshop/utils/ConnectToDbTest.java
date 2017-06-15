package onlineshop.utils;

import onlineshop.Exceptions.GenericException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectToDbTest {

    @Test
    public void getConnectionTest_Positive() throws GenericException {
        Connection con = ConnectToDb.getConnection();
        Assert.assertNotNull(con);
        ConnectToDb.closeConnection(con);
    }

    @Test
    public void getConnectionTest_Negative() throws GenericException, SQLException {
        Connection con = ConnectToDb.getConnection();
        ConnectToDb.closeConnection(con);
        Assert.assertTrue(con.isClosed());
    }

}
