package com.springrise.xinmiao.dto.response.preparation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

// DocumentChecklistResponse.java
@Data
@Builder
@AllArgsConstructor // 添加全参构造器
public class DocumentChecklistResponse {
    private String documentName;
    private boolean mandatory;
    private String description;
    private String submitStatus;
}

