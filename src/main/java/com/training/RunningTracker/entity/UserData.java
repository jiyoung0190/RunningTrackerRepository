package com.training.RunningTracker.entity;


import java.sql.Time;
import java.util.Date;


public class UserData { // this is the data which needs to be saved to and retrieved from the db
    private Date date;
    private float distance;
    private Time time;
    private int id;
    private int usersId;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return "UserData{" + "date=" + date + ", distance=" + distance + ", time=" + time + '}';
    }
}
