package com.springrise.xinmiao.external.dto;

import java.util.List;

import lombok.Data;

@Data
public class MapApiResponse {
    private String status;
    private Route route;
    
    @Data
    public static class Route {
        private List<Step> steps;
        private double duration; // 秒
        private double tollFee;  // 费用
        private String transportType;
    }

    @Data
    public static class Step {
        private String instruction;
        private double distance;
    }
}
