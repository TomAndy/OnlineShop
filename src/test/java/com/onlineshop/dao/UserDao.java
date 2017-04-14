package com.onlineshop.dao;

import com.onlineshop.model.User;
import com.onlineshop.utils.ConnectToDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDao extends GenericDao<User> {

    private final static String userTable = "\"User\"";

    public boolean saveUser(final User user) {
        Connection conn = new ConnectToDb().getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(String.format(User.SAVE_USER_QUERY, User.TABLE_NAME,
                    user.getUserId(), user.getUserName(), user.getLogin(), user.getEmail()));
            int rowsInserted = st.executeUpdate();
            if (rowsInserted >= 1) {
                st.close();
                return true;
            } else {
                st.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    public User findById(final int userID) {
        Connection conn = new ConnectToDb().getConnection();
        User user = null;
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(String.format(User.FIND_BY_ID_QUERY, User.TABLE_NAME, userID));
            if (!rs.next()) {
                System.out.println("No such user in DB");
                return null;
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    String userName = String.valueOf(rs.getString("userName"));
                    String login = String.valueOf(rs.getString("login"));
                    String email = String.valueOf(rs.getString("email"));
                    user = new User(userID, userName, login, email);
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return user;
    }


    public boolean updateUser(final User user) {
        Connection conn = ConnectToDb.getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(String.format(User.UPDATE_USER_QUERY, User.TABLE_NAME,
                    user.getUserName(), user.getLogin(), user.getEmail(), user.getUserId()));
            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated >= 1) {
                st.close();
                return true;
            } else {
                st.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    public boolean deleteUserById(final int userID) {
        Connection conn = new ConnectToDb().getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(String.format(User.DELETE_USER_BY_ID_QUERY, User.TABLE_NAME, userID));
            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted >= 1) {
                st.close();
                return true;
            } else {
                st.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectToDb.closeConnection(conn);
        }
    }

    public Collection<User> findAll() { //throws MyNewException {
        List<User> userList = new ArrayList<User>();

        Connection conn = ConnectToDb.getConnection();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(User.FIND_ALL_QUERY);
            if (!rs.next()) {
                System.out.println("No users in DB");
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    int userId = Integer.valueOf(rs.getString("userId"));
                    String userName = String.valueOf(rs.getString("userName"));
                    String login = String.valueOf(rs.getString("login"));
                    String email = String.valueOf(rs.getString("email"));
                    userList.add(new User(userId, userName, login, email));
                }
            }
            rs.first();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectToDb.closeConnection(conn);
        }
        return userList;
    }
}
