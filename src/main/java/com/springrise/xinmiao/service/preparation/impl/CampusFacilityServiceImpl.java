package com.springrise.xinmiao.service.preparation.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrise.xinmiao.dto.response.preparation.CampusFacilityResponse;
import com.springrise.xinmiao.entity.preparation.CampusFacility;
import com.springrise.xinmiao.repository.mapper.CampusFacilityMapper;
import com.springrise.xinmiao.service.preparation.CampusFacilityService;
import com.springrise.xinmiao.util.GeoUtils;

@Service
public class CampusFacilityServiceImpl implements CampusFacilityService {
    
    private final CampusFacilityMapper facilityMapper;

    @Autowired
    public CampusFacilityServiceImpl(CampusFacilityMapper facilityMapper) {
        this.facilityMapper = facilityMapper;
    }

    @Override
    public List<CampusFacilityResponse> getFacilitiesByCategory(String category) {
        return facilityMapper.selectByConditions(category, null)
            .stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }

    private CampusFacilityResponse convertToResponse(CampusFacility facility) {
        CampusFacilityResponse response = new CampusFacilityResponse();
        response.setId(facility.getId());
        response.setName(facility.getName());
        response.setCategory(facility.getCategory());
        response.setAddress(facility.getAddress());
        // 手动计算距离
        response.setDistance(calculateDistanceFromSchool(facility));
        return response;
    }

    private BigDecimal calculateDistanceFromSchool(CampusFacility facility) {
    // 学校主门坐标（示例值，需替换为实际坐标）
    final double SCHOOL_LAT = 39.9912;
    final double SCHOOL_LON = 116.3456;
    
    return GeoUtils.calculateDistance(  // 调用修正后的方法名
        SCHOOL_LAT, SCHOOL_LON,
        facility.getLatitude(), facility.getLongitude()
    );
}

    @Override
    public List<CampusFacilityResponse> searchFacilities(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchFacilities'");
    }

    @Override
    public CampusFacilityResponse getFacilityDetails(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacilityDetails'");
    }
    
    public interface CampusFacilityService {
    List<CampusFacilityResponse> getFacilitiesWithinRadius(Integer radiusMeters, String facilityType);
}

    
}
