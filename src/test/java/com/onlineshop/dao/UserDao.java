package com.onlineshop.dao;

import com.onlineshop.model.User;
import com.onlineshop.utils.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDao extends GenericDao {

    private String userTable = "User";

    public boolean saveUser(final User user) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "Insert into \"" + userTable + "\" values(" + user.getUserId() + ", '" + user.getUserName() +
                "', '" + user.getLogin() + "', '" + user.getEmail() + "');";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            int rowsInserted = st.executeUpdate();
            if(rowsInserted>=1) {
                st.close();
                return true;
            }
            else {
                st.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findById(final int userID) {
        String userName = "";
        String login = "";
        String email = "";

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from \"" + userTable + "\" where \"userId\" = " + userID);
            if(!rs.next()) {
                System.out.println("No such user in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    userName = String.valueOf(rs.getString("userName"));
                    login = String.valueOf(rs.getString("login"));
                    email = String.valueOf(rs.getString("email"));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(userID, userName, login, email);
    }


    public boolean updateUser(final User user) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "UPDATE \"" + userTable + "\"  SET \"userName\"='" + user.getUserName() + "', \"login\"='" + user.getLogin() +
                "', \"email\"='" + user.getEmail() + "'  where \"userId\"=" + user.getUserId();

        try {
            PreparedStatement st = conn.prepareStatement(query);
            int rowsUpdated = st.executeUpdate();
            if(rowsUpdated>=1) {
                st.close();
                return true;
            }
            else {
                st.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUserById(final int userID) {
        Connection conn = new ConnectToDb().getConnection();
        String query = "delete from \"" + userTable + "\" where \"userId\" = " + userID;
        try {
            PreparedStatement st = conn.prepareStatement(query);
            int rowsDeleted = st.executeUpdate();
            if(rowsDeleted>=1) {
                st.close();
                return true;
            }
            else {
                st.close();
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
}

    public Collection<User> findAll() {
        int userId=0;
        String userName = "";
        String login = "";
        String email = "";
        List<User> userList = new ArrayList<User>();

        Connection conn = new ConnectToDb().getConnection();
        try {
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from \"" + userTable + "\"");
            if(!rs.next()) {
                System.out.println("No users in DB");
                return null;
            }
            else {
                rs.beforeFirst();
                while(rs.next()) {
                    userId = Integer.valueOf(rs.getString("userId"));
                    userName = String.valueOf(rs.getString("userName"));
                    login = String.valueOf(rs.getString("login"));
                    email = String.valueOf(rs.getString("email"));
                    userList.add(new User(userId,userName,login,email));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
