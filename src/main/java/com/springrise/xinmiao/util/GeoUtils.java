package com.springrise.xinmiao.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GeoUtils {
    private static final double EARTH_RADIUS_KM = 6371.0;

    /**
     * 计算两个坐标点之间的距离（Haversine公式）
     * @param lat1 起点纬度
     * @param lon1 起点经度
     * @param lat2 终点纬度
     * @param lon2 终点经度
     * @return 距离（公里），保留两位小数
     */
    public static BigDecimal calculateDistance(double lat1, double lon1, 
                                             double lat2, double lon2) {
        // 将度数转换为弧度
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                 + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                 * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS_KM * c;

        return new BigDecimal(distance).setScale(2, RoundingMode.HALF_UP);
    }
}
