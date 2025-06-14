package com.springrise.xinmiao.service.preparation.impl;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrise.xinmiao.dto.response.preparation.TransportRouteResponse;
import com.springrise.xinmiao.entity.preparation.TransportRoute;
import com.springrise.xinmiao.external.MapApiClient;
import com.springrise.xinmiao.external.dto.MapApiResponse;
import com.springrise.xinmiao.external.dto.MapApiResponse.Step;
import com.springrise.xinmiao.repository.mapper.TransportationMapper;
import com.springrise.xinmiao.service.preparation.TransportationService;
import com.springrise.xinmiao.util.GeoLocationUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportationServiceImpl implements TransportationService {

    private final TransportationMapper transportationMapper;
    private final GeoLocationUtil geoLocationUtil;

    @Override
    public TransportRouteResponse getRecommendedRoute(String originCity, String preferredTransport) {
        // 1. 验证城市有效性
        if (!geoLocationUtil.isValidCity(originCity)) {
            throw new IllegalArgumentException("无效的生源地城市");
        }

        // 2. 查询预置路线（数据库优先）
        TransportRoute route = transportationMapper.selectRoute(originCity, preferredTransport);
        
        // 3. 无预置数据时调用地图API
        if (route == null) {
            route = callMapApi(originCity, preferredTransport);
        }

        // 4. 转换为响应对象
        return TransportRouteResponse.builder()
            .transportType(route.getTransportType())
            .durationHours(route.getDurationHours())
            .cost(route.getCost())
            .steps(route.getSteps())
            .build();
    }

    private final MapApiClient mapApiClient;
    private final TransportationMapper mapper;

    private TransportRoute callMapApi(String originCity, String preferredTransport) {
        MapApiResponse response = mapApiClient.getRoute(
            originCity, 
            "XX大学", 
            preferredTransport != null ? preferredTransport : "driving"
        );

        if (!"OK".equals(response.getStatus())) {
            
        }

        return convertToTransportRoute(response);
    }

    private TransportRoute convertToTransportRoute(MapApiResponse response) {
        return TransportRoute.builder()
            .transportType(response.getRoute().getTransportType())
            .durationHours(response.getRoute().getDuration() / 3600)
            .cost(BigDecimal.valueOf(response.getRoute().getTollFee()))
            .steps(response.getRoute().getSteps().stream()
                .map(Step::getInstruction)
                .collect(Collectors.toList()))
            .build();
    }



}


