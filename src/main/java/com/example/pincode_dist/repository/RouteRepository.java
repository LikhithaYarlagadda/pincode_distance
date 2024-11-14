package com.example.pincode_dist.repository;

import com.example.pincode_dist.model.RouteData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<RouteData, Long> {
    Optional<RouteData> findByFromPincodeAndToPincode(String fromPincode, String toPincode);
}
