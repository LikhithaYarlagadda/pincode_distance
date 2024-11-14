package com.example.pincode_dist.service;

import com.example.pincode_dist.client.GoogleMapsClient;
import com.example.pincode_dist.dto.RouteResponse;
import com.example.pincode_dist.model.RouteData;
import com.example.pincode_dist.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private GoogleMapsClient googleMapsClient;

    @Cacheable("routeCache")
    public RouteResponse getRouteDetails(String fromPincode, String toPincode) {
        Optional<RouteData> existingRoute = routeRepository.findByFromPincodeAndToPincode(fromPincode, toPincode);
        if (existingRoute.isPresent()) {
            return new RouteResponse(existingRoute.get());
        }

        RouteData newRouteData = googleMapsClient.fetchRouteData(fromPincode, toPincode);
        routeRepository.save(newRouteData);

        return new RouteResponse(newRouteData);
    }
}
