package com.onlineshop.model;

import java.util.Formatter;

public class User {
    public static final String TABLE_NAME = "\"User\"";
    public static final String FIND_ALL_QUERY = String.format("select * from %s",TABLE_NAME);
    public static final String SAVE_USER_QUERY = "Insert into %s values(%d, '%s', '%s', '%s');";
    public static final String FIND_BY_ID_QUERY = "select * from %s where \"userId\" = %d";
    public static final String DELETE_USER_BY_ID_QUERY = "delete from %s where \"userId\" = %d";
    public static final String UPDATE_USER_QUERY = "UPDATE %s  SET \"userName\"='%s', \"login\"='%s', \"email\"='%s' where \"userId\"=%d";

    private int userId;
    private String login;
    private String userName;
    private String email;

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter frt = new Formatter(sb);
        String template = "%-3s %-10s %-10s %-10s";
        frt.format(template, this.getUserId(), this.getUserName(), this.getLogin(), this.getEmail());
        return sb.toString();
    }

    public User(int userId, String userName, String login, String email) {
        this.userId = userId;
        this.login = login;
        this.userName = userName;
        this.email = email;
    }

}
