package com.project.railwayreservation.model;

public class TrainStations {
    private int tid;
    private String station;

    public TrainStations(int tid, String station) {
        this.tid = tid;
        this.station = station;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
