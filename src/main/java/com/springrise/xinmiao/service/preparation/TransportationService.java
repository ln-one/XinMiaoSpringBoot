// src/main/java/com/springrize/xinmiao/service/preparation/TransportationService.java
package com.springrise.xinmiao.service.preparation;

import com.springrise.xinmiao.dto.response.preparation.TransportRouteResponse;

public interface TransportationService {
    /**
     * 根据生源地推荐交通路线
     * @param originCity 学生生源地城市
     * @param preferredTransport 偏好交通方式（可选）
     */
    TransportRouteResponse getRecommendedRoute(String originCity, String preferredTransport);
}