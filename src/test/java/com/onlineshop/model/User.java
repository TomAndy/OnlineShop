package com.onlineshop.model;

public class User {
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
        return "userId: " + this.getUserId() + "; userName: " + this.getUserName()+ "; login: " + this.getLogin() + "; email: "
                + this.getEmail();
    }

    public User(int userId, String userName, String login, String email) {
        this.userId = userId;
        this.login = login;
        this.userName = userName;
        this.email = email;
    }

}
