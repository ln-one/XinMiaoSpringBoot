package com.springrise.xinmiao.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.springrise.xinmiao.entity.preparation.DocumentRequirement;

@Mapper
public interface DocumentRequirementMapper {
    @Select("SELECT * FROM document_requirements WHERE student_type = #{type}")
    List<DocumentRequirement> selectByStudentType(@Param("type") String studentType);

    @Select("SELECT document_id FROM document_requirements " +
            "WHERE student_type = (SELECT type FROM students WHERE id = #{studentId}) " +
            "AND is_mandatory = true")
    List<String> selectMandatoryDocs(@Param("studentId") String studentId);
}
