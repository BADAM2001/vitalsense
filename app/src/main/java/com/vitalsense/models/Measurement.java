package com.vitalsense.models;

public class Measurement {

    private int id;
    private int spo2;
    private int bp;
    private int heartRate;

    public Measurement(int id, int spo2, int bp, int heartRate) {
        this.id = id;
        this.spo2 = spo2;
        this.bp = bp;
        this.heartRate = heartRate;
    }

    public int getId() {
        return id;
    }

    public int getSpo2() {
        return spo2;
    }

    public int getBp() {
        return bp;
    }

    public int getHeartRate() {
        return heartRate;
    }
}
