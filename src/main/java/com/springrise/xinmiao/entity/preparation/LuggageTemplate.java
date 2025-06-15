package com.springrise.xinmiao.entity.preparation;

import lombok.Data;

@Data
public class LuggageTemplate {
    private Long id;
    private String itemName;
    private String category;
    private String climateZone;
    private String majorCategory;
    private Integer priority;
    private Boolean isEssential;
}