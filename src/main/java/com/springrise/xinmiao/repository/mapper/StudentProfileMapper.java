
package com.springrise.xinmiao.repository.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springrise.xinmiao.entity.StudentProfile;

@Mapper
public interface StudentProfileMapper {
    @Select("SELECT * FROM student_profile WHERE student_id = #{studentId}")
    StudentProfile selectByStudentId(String studentId);

    @Update("UPDATE student_profile SET climate_zone=#{climateZone}, major_category=#{majorCategory} WHERE student_id=#{studentId}")
    int updateProfile(StudentProfile profile);

    @Insert("INSERT INTO student_profile(student_id, admission_notice_no, is_verified) " +
            "VALUES(#{studentId}, #{admissionNoticeNo}, #{isVerified})")
    int insertProfile(StudentProfile profile);
}