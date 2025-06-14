package com.springrise.xinmiao.controller.preparation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrise.xinmiao.dto.response.ApiResponse;
import com.springrise.xinmiao.dto.response.preparation.TransportRouteResponse;
import com.springrise.xinmiao.service.preparation.TransportationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/preparation/transport")
@RequiredArgsConstructor
public class TransportationController {

    private final TransportationService transportationService;

    @GetMapping
    public ApiResponse<TransportRouteResponse> getRoute(
            @RequestParam String originCity,
            @RequestParam(required = false) String transportType) {
        
        return ApiResponse.success(
            transportationService.getRecommendedRoute(originCity, transportType)
        );
    }
}
