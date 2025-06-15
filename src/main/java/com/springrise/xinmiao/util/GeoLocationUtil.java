package com.springrise.xinmiao.util;

import org.springframework.stereotype.Component;

@Component
public class GeoLocationUtil {
    
    /**
     * 验证城市有效性
     * @param cityName 城市名称
     * @return 是否有效
     */
    public boolean isValidCity(String cityName) {
        // 实际实现可接入第三方API或本地数据库校验
        return !cityName.isBlank(); // 示例简单实现
    }

    /**
     * 计算两个坐标的距离（公里）
     */
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // 实现Haversine公式等算法
        return 0.0; // 示例占位
    }
}
