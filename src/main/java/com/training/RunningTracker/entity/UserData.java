package com.training.RunningTracker.entity;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class UserData {
    private java.sql.Date date;
    private float distance;
    private Time time;
    private int id;
    private int usersId;
    private List<UserData> dataList;


    public List<UserData> getDataList() {
        return dataList;
    }

    public void setDataList(List<UserData> dataList) {
        this.dataList = dataList;
    }

    public UserData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


}
