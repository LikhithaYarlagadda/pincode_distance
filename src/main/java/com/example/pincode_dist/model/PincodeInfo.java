package com.example.pincode_dist.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PincodeInfo {

    @Id
    private String pincode;
    private double latitude;
    private double longitude;
    private String polygon;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }
}
