package com.springrise.xinmiao.service.preparation;

import java.util.List;

import com.springrise.xinmiao.dto.response.preparation.CampusFacilityResponse;

public interface CampusFacilityService {
    /**
     * 按分类查询设施
     * @param category 设施分类 (dining/shopping/medical/transport)
     */
    List<CampusFacilityResponse> getFacilitiesByCategory(String category);

    /**
     * 搜索设施
     * @param keyword 搜索关键词
     */
    List<CampusFacilityResponse> searchFacilities(String keyword);

    /**
     * 获取设施详情
     * @param id 设施ID
     */
    CampusFacilityResponse getFacilityDetails(Long id);
}
