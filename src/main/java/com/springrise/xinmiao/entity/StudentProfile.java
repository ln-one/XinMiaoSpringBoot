// src/main/java/com/springrize/xinmiao/entity/StudentProfile.java
package com.springrise.xinmiao.entity;

import lombok.Data;

@Data
public class StudentProfile {
    private String studentId;         // 学号/身份证号
    private String admissionNoticeNo; // 录取通知书编号
    private String climateZone;       // 生源地气候带（北方/南方等）
    private String majorCategory;     // 专业类别（工科/文科等）
    private Boolean isVerified;       // 是否完成双认证
    // 其他字段...
}
