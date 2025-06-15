package com.springrise.xinmiao.dto.response.preparation;

import lombok.Data;

@Data
public class LuggageItemDTO {
    private String itemName;     // 物品名称
    private String category;     // 物品类别
    private boolean isEssential; // 是否必带
    private String remarks;      // 备注
}