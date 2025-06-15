package com.springrise.xinmiao.dto.request.preparation;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TransportQueryRequest {
    @NotBlank(message = "出发城市不能为空")
    private String originCity;
    
    private String transportType; // 可选：train/bus/air/car
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate; // 出发日期
    
    private boolean includeCostComparison; // 是否包含费用对比
}
