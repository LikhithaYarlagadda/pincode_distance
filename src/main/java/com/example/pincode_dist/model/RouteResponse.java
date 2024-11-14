package com.example.pincode_dist.dto;

import com.example.pincode_dist.model.RouteData;

public class RouteResponse {

    private String fromPincode;
    private String toPincode;
    private String distance;
    private String duration;
    private String routePolyline;

    public RouteResponse(RouteData routeData) {
        this.fromPincode = routeData.getFromPincode();
        this.toPincode = routeData.getToPincode();
        this.distance = routeData.getDistance();
        this.duration = routeData.getDuration();
        this.routePolyline = routeData.getRoutePolyline();
    }

    public String getFromPincode() {
        return fromPincode;
    }

    public void setFromPincode(String fromPincode) {
        this.fromPincode = fromPincode;
    }

    public String getToPincode() {
        return toPincode;
    }

    public void setToPincode(String toPincode) {
        this.toPincode = toPincode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRoutePolyline() {
        return routePolyline;
    }

    public void setRoutePolyline(String routePolyline) {
        this.routePolyline = routePolyline;
    }
}
