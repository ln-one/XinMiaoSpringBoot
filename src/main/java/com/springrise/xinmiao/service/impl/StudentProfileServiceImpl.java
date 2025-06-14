
package com.springrise.xinmiao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springrise.xinmiao.entity.StudentProfile;
import com.springrise.xinmiao.repository.mapper.StudentProfileMapper;
import com.springrise.xinmiao.service.StudentProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileMapper mapper;

    @Override
    public StudentProfile getProfile(String studentId) {
        return mapper.selectByStudentId(studentId);
    }

    @Override
    @Transactional
    public void updateProfile(StudentProfile profile) {
        if (mapper.selectByStudentId(profile.getStudentId()) == null) {
            mapper.insertProfile(profile);
        } else {
            mapper.updateProfile(profile);
        }
    }

    @Override
    public boolean verifyIdentity(String idCardNo, String admissionNoticeNo) {
        StudentProfile profile = mapper.selectByStudentId(idCardNo);
        return profile != null && 
               admissionNoticeNo.equals(profile.getAdmissionNoticeNo());
    }

    @Override
    public String getClimateZone(String studentId) {
        StudentProfile profile = getProfile(studentId);
        return profile != null ? profile.getClimateZone() : "unknown";
    }
}