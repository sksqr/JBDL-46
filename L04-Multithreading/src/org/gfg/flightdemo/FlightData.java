package org.gfg.flightdemo;

import java.util.Date;

public class FlightData {

    private String src;

    private String dst;

    private double cost;

    public FlightData(String src, String dst, double cost) {
        this.src = src;
        this.dst = dst;
        this.cost = cost;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", dst='" + dst + '\'' +
                ", cost=" + cost +
                '}';
    }
}
