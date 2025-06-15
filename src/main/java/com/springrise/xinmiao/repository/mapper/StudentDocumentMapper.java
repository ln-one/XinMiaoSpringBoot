package com.springrise.xinmiao.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentDocumentMapper {
    /**
     * 查询学生已提交的文件ID列表
     * @param studentId 学号
     */
    @Select("SELECT document_id FROM student_documents WHERE student_id = #{studentId}")
    List<String> selectSubmittedDocIds(@Param("studentId") String studentId);
    
    /**
     * 批量插入提交记录
     */
    @Insert("<script>" +
            "INSERT INTO student_documents(student_id, document_id) VALUES " +
            "<foreach collection='docIds' item='docId' separator=','>(#{studentId}, #{docId})</foreach>" +
            "</script>")
    int batchInsert(@Param("studentId") String studentId, @Param("docIds") List<String> docIds);
}