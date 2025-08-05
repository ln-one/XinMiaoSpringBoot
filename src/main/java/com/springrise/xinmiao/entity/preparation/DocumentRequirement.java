package com.springrise.xinmiao.entity.preparation;



import lombok.Data;

@Data
public class DocumentRequirement {
    private Long id;
    private String studentType;
    private String documentName;
    private boolean isMandatory;
    private String description;
}
