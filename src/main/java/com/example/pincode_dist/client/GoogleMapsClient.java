package com.example.pincode_dist.client;

import com.example.pincode_dist.dto.GoogleMapsResponse;
import com.example.pincode_dist.model.RouteData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GoogleMapsClient {

    @Value("${google.maps.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public RouteData fetchRouteData(String fromPincode, String toPincode) {
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + fromPincode +
                "&destination=" + toPincode + "&key=" + apiKey;
        GoogleMapsResponse response = restTemplate.getForObject(url, GoogleMapsResponse.class);

        if (response != null && !response.getRoutes().isEmpty()) {
            String distance = response.getRoutes().get(0).getLegs().get(0).getDistance().getText();
            String duration = response.getRoutes().get(0).getLegs().get(0).getDuration().getText();
            String polyline = response.getRoutes().get(0).getOverviewPolyline().getPoints();

            return new RouteData(fromPincode, toPincode, distance, duration, polyline);
        }

        throw new RuntimeException("No route found from Google Maps API");
    }
}
