// src/main/java/com/springrise/xinmiao/entity/preparation/CampusFacility.java
package com.springrise.xinmiao.entity.preparation;

import lombok.Data;

@Data
public class CampusFacility {
    private Long id;
    private String name;          // 设施名称
    private String category;      // dining/shopping/medical/transport
    private String address;
    private Double latitude;      // 纬度
    private Double longitude;     // 经度
    private String openHours;     // 营业时间
    private String contactPhone;
    private String thumbnailUrl;  // 封面图URL
    private Double rating;        // 评分（0-5）
    private Integer status;       // 状态（0-关闭 1-营业）
}