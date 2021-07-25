package com.training.RunningTracker.entity;


import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private List<UserData> dataList;

    public List<UserData> getDataList() {
        return dataList;
    }

    public void setDataList(List<UserData> dataList) {
        this.dataList = dataList;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username){
        this.username = username;
    }

    //temporary
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return "'" + username + "'";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return "'" + password + "'";
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + " }";
    }
}
