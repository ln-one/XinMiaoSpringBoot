// src/main/java/com/springrize/xinmiao/entity/preparation/TransportRoute.java
package com.springrise.xinmiao.entity.preparation;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data // Lombok自动生成getter/setter
@Builder
public class TransportRoute {
    private Long id;
    private String transportType;  // 交通工具类型
    private Double durationHours;  // 时长（小时）
    private BigDecimal cost;      // 费用
    private List<String> steps;    // 路线步骤
    
    
}