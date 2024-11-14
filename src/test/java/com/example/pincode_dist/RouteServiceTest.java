package com.example.pincode_dist;

import com.example.pincode_dist.client.GoogleMapsClient;
import com.example.pincode_dist.dto.RouteResponse;
import com.example.pincode_dist.model.RouteData;
import com.example.pincode_dist.repository.RouteRepository;
import com.example.pincode_dist.service.RouteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RouteServiceTest {

    @MockBean
    private RouteRepository routeRepository;

    @MockBean
    private GoogleMapsClient googleMapsClient;

    @Autowired
    private RouteService routeService;

    @Test
    public void testGetRouteDetails_fromCache() {
        String fromPincode = "141106";
        String toPincode = "110060";
        RouteData routeData = new RouteData(fromPincode, toPincode, "20 km", "30 min", "encodedPolyline");

        Mockito.when(routeRepository.findByFromPincodeAndToPincode(fromPincode, toPincode))
                .thenReturn(Optional.of(routeData));

        RouteResponse response = routeService.getRouteDetails(fromPincode, toPincode);

        assertEquals("20 km", response.getDistance());
        assertEquals("30 min", response.getDuration());
    }
}
