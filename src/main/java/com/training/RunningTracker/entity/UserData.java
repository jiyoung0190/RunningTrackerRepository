package com.training.RunningTracker.entity;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
public class UserData { // this is the data which needs to be saved to and retrieved from the db
    private Date date;
    private float distance;
    private Time time;

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

}
