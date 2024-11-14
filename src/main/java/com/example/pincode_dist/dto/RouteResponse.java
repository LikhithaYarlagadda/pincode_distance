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

    // Getters and Setters
}
