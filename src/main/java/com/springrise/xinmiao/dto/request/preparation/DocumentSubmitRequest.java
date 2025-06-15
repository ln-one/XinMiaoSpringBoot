package com.springrise.xinmiao.dto.request.preparation;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DocumentSubmitRequest {
    @NotEmpty(message = "学号不能为空")
    private String studentId;
    
    @NotEmpty(message = "至少提交一个文件")
    private List<String> documentIds;
}
