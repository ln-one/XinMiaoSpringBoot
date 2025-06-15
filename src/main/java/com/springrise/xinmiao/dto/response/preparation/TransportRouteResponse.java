package com.springrise.xinmiao.dto.response.preparation;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransportRouteResponse {
    private String transportType;
    private double durationHours;
    private BigDecimal cost;
    private List<String> steps; // 解析后的路线步骤
}
