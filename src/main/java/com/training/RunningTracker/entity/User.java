package com.training.RunningTracker.entity;


public class User {
    private int users_id;
    private String username;
    private String password;

    public User(int users_id, String username, String password) {
        this.users_id = users_id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return  password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
