package com.springrise.xinmiao.service;

import com.springrise.xinmiao.entity.StudentProfile;

public interface StudentProfileService {
    // 获取学生档案
    StudentProfile getProfile(String studentId);
    
    // 更新档案信息
    void updateProfile(StudentProfile profile);
    
    // 新生注册验证（身份证+通知书）
    boolean verifyIdentity(String idCardNo, String admissionNoticeNo);
    
    // 获取学生生源地气候信息
    String getClimateZone(String studentId);
}
