package com.example.pincode_dist.controller;

import com.example.pincode_dist.dto.RouteResponse;
import com.example.pincode_dist.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/distance-duration")
    public ResponseEntity<RouteResponse> getRoute(@RequestParam String fromPincode, @RequestParam String toPincode) {
        RouteResponse response = routeService.getRouteDetails(fromPincode, toPincode);
        return ResponseEntity.ok(response);
    }
}
