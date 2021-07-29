package com.training.RunningTracker.entity;

import java.util.Date;

public class WeeklyActivityReport {
    private Date week;
    private Float avDistance;
    private Float avTime;
    private Float totalDistance;

    public WeeklyActivityReport(Date week, Float avDistance, Float avTime, Float totalDistance) {
        this.week = week;
        this.avDistance = avDistance;
        this.avTime = avTime;
        this.totalDistance = totalDistance;
    }

    public Date getWeek() {
        return week;
    }

    public void setWeek(Date week) {
        this.week = week;
    }

    public Float getAvDistance() {
        return avDistance;
    }

    public void setAvDistance(Float avDistance) {
        this.avDistance = avDistance;
    }

    public Float getAvTime() {
        return avTime;
    }

    public void setAvTime(Float avTime) {
        this.avTime = avTime;
    }

    public Float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Float totalDistance) {
        this.totalDistance = totalDistance;
    }
}
