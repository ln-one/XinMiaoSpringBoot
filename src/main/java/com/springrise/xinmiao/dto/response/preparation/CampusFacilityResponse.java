// src/main/java/com/springrise/xinmiao/dto/response/preparation/CampusFacilityResponse.java
package com.springrise.xinmiao.dto.response.preparation;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// CampusFacilityResponse.java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampusFacilityResponse {
    private Long id;
    private String name;
    private String category;
    private String address;
    private BigDecimal distance;
}