package com.springrise.xinmiao.dto.response.preparation;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LuggageListResponse {
    private List<LuggageItem> essentials;
    private List<LuggageItem> recommendations;
    
    @Data
    @Builder
    public static class LuggageItem {
        private String name;
        private String category;
        private String recommendationReason;
    }
}
