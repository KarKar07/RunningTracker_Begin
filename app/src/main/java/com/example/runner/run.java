package com.example.runner;

import java.io.Serializable;

public class run implements Serializable {
    public long id;
    public String date;
    public long dateMillis;
    public double distanceKm;
    public String duration;

    public run(long id, String date, double distanceKm, String duration) {
        this.id = id;
        this.date = date;
        this.distanceKm = distanceKm;
        this.duration = duration;
    }
}