package com.springrise.xinmiao.dto.request.preparation;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LuggageSubmitRequest {
    @NotEmpty(message = "学号不能为空")
    private String studentId;
    
    @NotEmpty(message = "至少添加一件行李")
    private List<LuggageItemRequest> items;
    
    @Data
    public static class LuggageItemRequest {
        private String name;
        private String category; // clothing/electronics/etc
        private boolean isEssential;
    }
}
